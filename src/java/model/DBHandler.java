package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.*;

/**
 * An abstract parent class for database handlers. This class loads database
 * access parameters from web.xml and loads the database driver class.
 *
 * @author R.Grove
 * @version 2014-10-25
 */
public abstract class DBHandler {
    /** Database access credentials */
    protected String driverName = "com.mysql.jdbc.Driver";
    protected String url = "jdbc:mysql://us-cdbr-azure-southcentral-e.cloudapp.net/newsstand"; 
    protected String userId = "ba7e286a39ae9e"; 
    protected String password = "d89b6d9b";
    /** Database connection */
    private Connection con;
    /** SQL Statement */
    protected Statement stmt;
    /** Connection open status */
    protected boolean isOpen = false;

    /**
     * Get parameters required to open DBMS connection.
     */
    public DBHandler() {
        driverName = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://us-cdbr-azure-southcentral-e.cloudapp.net/newsstand";
        userId = (String) "ba7e286a39ae9e";
        password = (String) "d89b6d9b";
         
    }        
           
    

    /**
     * Open the DB connection
     *
     * @throws SQLException if the DB connection cannot be established
     */
    public void open() throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        con = DriverManager.getConnection(url, userId, password);
        stmt = con.createStatement();
        isOpen = true;
    }

    /**
     * Close the DB connection.
     *
     * @throws SQLException if the DB connection close fails
     */
    public void close() throws SQLException {
        stmt.close();
        con.close();
        isOpen = false;
    }
}