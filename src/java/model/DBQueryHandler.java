package model;

import java.io.*;
import java.sql.*;

/**
 * This class handles the DB query interface.
 *
 * @author R.Grove
 * @version 2014-10-06
 */
public class DBQueryHandler extends DBHandler implements Serializable {

    /**
     * Execute a query and return a ResultSet.
     *
     * @param query The SQL query to be executed
     * @return A ResultSet of the query results
     * @throws SQLException if the database query action fails
     */
    public ResultSet doQuery(String query) throws SQLException {
        if (!isOpen) {
            open();
        }
        ResultSet rs = stmt.executeQuery(query);
        return rs;
    }
}