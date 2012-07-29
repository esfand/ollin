package org.es4j.persistence.sql.ollin;

import java.sql.SQLException;

/**
 * A implementaton of RowIterator for printing the rows in a simple format. Each row is printed in a line with each column separated by a tabulator character.
 *
 * @author Victor Hugo Herrera Maldonado
 */
public final class RowPrinter implements RowVisitor {

    /**
     * Print each column of the row. Each column is separated by a tabulator. A line separator is printed after printing the columns.
     *
     * @param row
     * @throws SQLException
     */
    public void visit(ResultSetRow row) throws SQLException {
        for (int i = 1; i < row.getResultSet().getMetaData().getColumnCount(); i++) {
            System.out.print(row.getString(i));
            System.out.print("\t");
        }
        System.out.println("");
    }
    
}
