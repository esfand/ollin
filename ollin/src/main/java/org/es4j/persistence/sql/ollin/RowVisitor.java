package org.es4j.persistence.sql.ollin;

import java.sql.SQLException;

/**
 * RowVisitor is used to iterate the rows resulting of a Query execution.
 *
 * @author Victor Hugo Herrera Maldonado
 */
public interface RowVisitor {

    /**
     * Called internally by Query.forEachRow method. 
     *
     * @param row The row view to the ResultSet
     * @throws SQLException
     * @see ResultSetRow
     */
    void visit(ResultSetRow row) throws SQLException;

}
