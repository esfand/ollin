package org.es4j.persistence.sql.ollin;

/**
 * ValuedRowVisitor extends RowVisitor and defines the capacity to get a value after visiting the rows of a ResultSet.
 *
 * @author Victor Hugo Herrera Maldonado
 */
public interface ValuedRowVisitor<V> extends RowVisitor{

    /**
     * Get the value of this visitor.
     *
     * @return Visitor value.
     */
    V getValue();

}
