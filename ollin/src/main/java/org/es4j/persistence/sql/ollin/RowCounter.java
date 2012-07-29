package org.es4j.persistence.sql.ollin;

import java.sql.SQLException;

/**
 * An implementation of ValuedRowVisitor for counting rows. With each iteration, an internal counter is incremented.
 *
 * @author Victor
 */
public final class RowCounter implements ValuedRowVisitor<Integer>{
    private int counter;

    /**
     * Return the count of rows visited.
     * @return
     */
    public Integer getValue() {
        return counter;
    }


    /**
     * Increment the count with every invocation.
     * 
     * @param row
     * @throws SQLException
     */
    public void visit(ResultSetRow row) throws SQLException {
        counter++;
    }

}
