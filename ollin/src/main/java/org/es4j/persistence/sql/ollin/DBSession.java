package org.es4j.persistence.sql.ollin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

/**
 * <p>
 * The main object for interacting with a database. The interaction is made by getting a connection from a DataSource. If a transaction is started, a long running connection
 * is used until the transaction is finished (by commiting or rollback). But if an operation is called and there's no transaction started, a connection is retrieved from the DataSource and
 * closed before returning from the method.
 * </p>
 * @author Victor Hugo Herrera Maldonado
 */
public class DBSession {

    private DataSource dataSource;
    private Connection connectionForTransaction;
    private boolean wasAutoCommit;

    public DBSession(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Create a query to retrieve data from the database.
     *
     * @param string Query string
     * @return A Query object.
     * @see Query
     */
    public Query createQuery(String string, Object... values) {
        QueryImpl query = new QueryImpl(string);
        for (int i = 0; i < values.length; i++) {
            query.setObject(i + 1, values[i]);
        }
        return query;
    }

    public Query createQueryFromResource(URL resource, Object... values) throws IOException {
        InputStream input = resource.openStream();
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            reader.close();
            reader = null;
        } catch (IOException ex) {
            if (reader != null) {
                reader.close();
            }
        }
        return createQuery(builder.toString(), values);
    }

    public Query createQueryFromResource(String resourceName, Object... values) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(resourceName);
        if (resource == null) {
            resource = getClass().getResource(resourceName);
            return createQueryFromResource(resource, values);
        } else {
            throw new IOException("Resource not found: " + resourceName);
        }
    }

    /**
     * Creates an Update object.
     * 
     * @param string
     * @return
     */
    public Update createUpdate(String string) {
        return new UpdateImpl(string);
    }

    /**
     * Indicates that all subsecuent updates will not be commited until a call to commitTransaction is made or will be undone if rollbackTransaction is called.
     *
     * @throws SQLException
     * @throws IllegalStateException if a transaction was already started.
     */
    public void startTransaction() throws SQLException {
        if (connectionForTransaction != null) {
            throw new IllegalStateException("Transaction already in progress");
        }
        connectionForTransaction = dataSource.getConnection();
        wasAutoCommit = connectionForTransaction.getAutoCommit();
        connectionForTransaction.setAutoCommit(false);
    }

    /**
     * Commit all updates made after startTransaction was invoked. The transaction is finished after commiting.
     *
     * @throws SQLException
     * @throws IllegalStateException if there's no transaction started.
     */
    public void commitTransaction() throws SQLException {
        if (connectionForTransaction == null) {
            throw new IllegalStateException("Not in transaction");
        }
        connectionForTransaction.commit();
        connectionForTransaction.setAutoCommit(wasAutoCommit);
        connectionForTransaction.close();
        connectionForTransaction = null;
    }

    /**
     * Rollback all updates made after startTransaction was invoked. The transaction is finished after rollback.
     *
     * @throws SQLException
     * @throws IllegalStateException if there's no transaction started.
     */
    public void rollbackTransaction() throws SQLException {
        if (connectionForTransaction == null) {
            throw new IllegalStateException("Not in transaction");
        }
        connectionForTransaction.rollback();
        connectionForTransaction.setAutoCommit(wasAutoCommit);
        connectionForTransaction.close();
        connectionForTransaction = null;


    }

    /*
     * Implementation of Query.
     *
     * The connection to the database is lazy. It means, this object just holds the information to connect to the database but is not connected  until forEachRow is called.
     */
    private class QueryImpl implements Query {

        private String queryString;
        private Map<Integer, Object> mapParameters = new HashMap<Integer, Object>();

        /**
         * Creates the QueryImpl object with the given query string.
         *
         * @param query The query string.
         */
        private QueryImpl(String query) {
            this.queryString = query;
        }

        public QueryImpl setObject(int index, Object object) {
            mapParameters.put(index, object);
            return this;
        }

        public <T> T get() throws SQLException {
            T t = forEachRow(new ObjectValuedRowVisitor<T>()).getValue();
            return t;
        }

        private class ObjectValuedRowVisitor<V> implements ValuedRowVisitor<V> {

            private Object o;

            public V getValue() {
                return (V) o;
            }

            public void visit(ResultSetRow row) throws SQLException {
                o = row.getObject(1);
            }
        }

        public <V extends RowVisitor> V forEachRow(V visitor) throws SQLException {
            if (visitor == null) {
                throw new IllegalArgumentException("rowVisitor is null");
            }
            Connection connection = null;
            PreparedStatement pstmt = null;
            ResultSet rset = null;
            try {
                connection = connectionForTransaction != null ? connectionForTransaction : dataSource.getConnection();
                pstmt = connection.prepareStatement(queryString);
                for (Map.Entry<Integer, Object> entry : mapParameters.entrySet()) {
                    pstmt.setObject(entry.getKey(), entry.getValue());
                }
                rset = pstmt.executeQuery();
                while (rset.next()) {
                    visitor.visit(new ResultSetRow(rset));
                }
                rset.close();
                rset = null;
                pstmt.close();
                pstmt = null;
                if (connectionForTransaction == null && connection != null) {
                    connection.close();
                    connection = null;
                }
            } finally {
                if (rset != null) {
                    rset.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connectionForTransaction == null && connection != null) {
                    connection.close();
                }
            }
            return visitor;
        }
    }

    private class UpdateImpl implements Update {

        private String updateStmt;
        private Map<Integer, Object> mapParameters = new HashMap<Integer, Object>();

        private UpdateImpl(String updateStmt) {
            this.updateStmt = updateStmt;
        }

        public UpdateImpl setObject(int index, Object value) {
            mapParameters.put(index, value);
            return this;
        }

        public int execute() throws SQLException {
            Connection connection = null;
            PreparedStatement pstmt = null;
            try {
                connection = connectionForTransaction != null ? connectionForTransaction : dataSource.getConnection();
                pstmt = connection.prepareStatement(updateStmt);
                for (Map.Entry<Integer, Object> entry : mapParameters.entrySet()) {
                    pstmt.setObject(entry.getKey(), entry.getValue());
                }
                int count = pstmt.executeUpdate();
                pstmt.close();
                pstmt = null;
                if (connectionForTransaction == null && connection != null) {
                    connection.close();
                    connection = null;
                }
                return count;
            } finally {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connectionForTransaction == null && connection != null) {
                    connection.close();
                }
            }
        }
    }
}
