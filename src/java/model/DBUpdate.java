/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author bryanlelliott
 */
public class DBUpdate {
    
    private DBCommandHandler dbComHand = new DBCommandHandler();
    
    public boolean insertUser(String userId, String password, 
        String email,String realName, String bio, int secretQuestion,
        String secretAnswer, String userType) {

        // if logging in 
        /*query = "SELECT * FROM users WHERE userID = '" + userId 
                + "' AND password = '" + password + "'";


        try {
            handler.doQuery(query);
        }
        catch(SQLException SQLE)
        {
            SQLE.printStackTrace();
        }

        // compare the result 
        // if the query returns null, then there is not a match.
           if (result == null) {
            // redirect to login.jsp because the password didnt work.
           }
           else if (result != null) {
               execute();
           }

          */ 
        // if creating new account

        String command = "INSERT INTO users VALUES ("
                + userId + ", " + realName + ", " + bio +
                ", " + email + ", " + password + ", " +
                userType + "," + secretQuestion + "," + secretAnswer + ");";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }             
        
    }
    
    private boolean insertArticle(int articleId, String url, 
        int authorId, int providerId, String title, Date addDate, String category) {
        String command = "INSERT INTO articles VALUES ("
                + articleId + ", " + url + ", " + authorId +
                ", " + providerId + ", " + title + ", " +
                addDate + "," + category + ");";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }              
    }
    
    private boolean insertRating(boolean loggedIn, int ratingId, String userId,
        int articleId, int ratingValue, String ratingText, Date ratingDate) {
        String command = "INSERT INTO ratings VALUES ("
                + ratingId + ", " + userId + ", " + articleId +
                ", " + ratingValue + ", " + ratingText + ", " +
                ratingDate + ");";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }              
    }   
}
