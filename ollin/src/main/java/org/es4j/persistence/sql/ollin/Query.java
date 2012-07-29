package org.es4j.persistence.sql.ollin;

import java.sql.SQLException;

/**
 * <p>
 *  An object to query the database.
 * </p>
 *
 * <p>
 *  Query can contain parameters, using the holder '?'. Before execute the query the holder variables have to be set using setObject.
 *  (@see PreparedStatement.setObject(int, Object)).
 * </p>
 *
 * @author Victor
 */
public interface Query{

    /**
     * Opens the connection to the database, executes this query and retrievese the ResultSet iterating every row in it and calling rowVisitor.visit(row) for each row in the ResultSet.
     *
     * @param visitor The row visitor that is called for each iteration in the ResultSet
     * @throws SQLException
     */
    <V extends RowVisitor> V forEachRow(V visitor) throws SQLException;

    /**
     * Executes the query and return a value.
     *
     * @param <T> The type of the returned value.
     * @return
     * @throws SQLException
     */
    <T> T get() throws SQLException;

    /**
     * Set a param of the query.
     *
     * @param index The index of the param.
     * @param object Value of the param.
     * @return Query object for chainability.
     */
    Query setObject(int index, Object object);

}
