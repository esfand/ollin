package org.es4j.persistence.sql.ollin.examples;

import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDataSource;
import org.es4j.persistence.sql.ollin.DBSession;
import org.es4j.persistence.sql.ollin.ResultSetRow;
import org.es4j.persistence.sql.ollin.RowPrinter;
import org.es4j.persistence.sql.ollin.ValuedRowVisitor;

/**
 * This is a proof of concept of Ollin. We use Derby DB that is integrated 
 * in netbeans (you can change the code for another DB).
 *
 * @author Victor Hugo Herrera Maldonado
 */
public class Main1 {
    /* for counting rows */
//    private static int rowCounter;

    /**
     * @param args No params
     */
    public static void main(String[] args) throws SQLException {
        /*
         * We need an instance of DataSource to use with Ollin.
         * In these case we use the implementation that Derby provides.
         */
        ClientDataSource dataSource = new ClientDataSource();
        dataSource.setDatabaseName("sample");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(1527);
        dataSource.setUser("app");
        dataSource.setPassword("app");

        DBSession dbSession = new DBSession(dataSource);

        /*
         * A query for selecting rows. We use rowVisitor to count the rows that we've got.
         */
        int count = dbSession.createQuery("select * from APP.CUSTOMER")
                             .forEachRow(new RowCounter())
                             .getValue();
        System.out.println("row count: " + count);
        int count2 = dbSession.createQuery("select count(*) from APP.CUSTOMER")
                              .<Integer>get();
        System.out.println("row count2: " + count2);

        /*
         * Now we print rows in an single step.
         */
        dbSession.createQuery("select * from APP.EMPLOYEE")
                 .forEachRow(new RowPrinter());

        /*
         * Testing transaction capabilities. We introduce code to throw a dummy exception.
         * See the if conditional that appears after the second update.
         * After the try block, we print the tables to see the content of the table.
         */
        dbSession.startTransaction();
        System.out.println("start transaction");
        try {
            dbSession.createUpdate("insert into app.person(id,name) values(99, 'X')").execute();
            dbSession.createUpdate("insert into app.employee(employee_id,name) values(100, 'Y')").execute();

            /* Set to true or false to see what happens when a exception occurs. */
            if (true) {
                throw new Exception("Exception");
            }
            System.out.println("commit transaction");
            dbSession.commitTransaction();
        } catch (Exception ex) {
            System.out.println("rollback transaction");
            dbSession.rollbackTransaction();
            ex.printStackTrace();
        }
        dbSession.createQuery("select * from APP.PERSON").forEachRow(new RowPrinter());
        dbSession.createQuery("select * from APP.EMPLOYEE").forEachRow(new RowPrinter());
    }

    private static class RowCounter implements ValuedRowVisitor<Integer> {

        private int counter;

        @Override
        public void visit(ResultSetRow row) throws SQLException {
            counter++;
        }

        @Override
        public Integer getValue() {
            return counter;
        }
    }
}
