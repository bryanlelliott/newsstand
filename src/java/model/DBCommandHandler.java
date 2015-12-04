package model;

import java.io.*;
import java.sql.*;

/**
 * This class handles the DB command interface.
 *
 * @author R.Grove
 * @version 2014-10-06
 */
public class DBCommandHandler extends DBHandler implements Serializable {

    /**
     * Execute a command and return a result count.
     *
     * @param command An SQL command to be executed.
     * @return The count of rows affected by the command
     * @throws SQLException if there is a database error during command
     * execution
     */
    public int doCommand(String command) throws SQLException {
        if (!isOpen) {
            open();
        }
        int resultCount = stmt.executeUpdate(command);
        return resultCount;
    }
}