package org.es4j.persistence.sql.ollin;

import java.sql.SQLException;

/**
 * <p>
 *  An object to modify the database.
 * </p>
 * 
 * <p>
 *  Query can contain parameters, using the holder '?'. Before execute the query the holder variables have to be set using setObject.
 *  (@see PreparedStatement.setObject(int, Object)).
 * </p>
 *
 * @author Victor
 */
public interface Update {

    /**
     * Execute the update.
     *
     * @return The number of modificated rows.
     * @throws SQLException
     */
    int execute() throws SQLException;

    /**
     * Set a param of the uodate.
     *
     * @param index The index of the param.
     * @param object Value of the param.
     * @return Update object for chainability.
     */
    Update setObject(int index, Object value);

}
