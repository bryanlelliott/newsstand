/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author bryanlelliott
 * 
 */
public class DBUpdate {
    
    private DBCommandHandler dbComHand = new DBCommandHandler();
    private DBQueryHandler dbqh = new DBQueryHandler();
    
    public boolean insertUser(String userId, String password, 
        String email,String realName, String bio, int secretQuestion,
            String secretAnswer, String userType) {
           
        String command = "INSERT INTO users (userID, userRealName, userBio, userEmail, "
         + "userPassword, userType, userRecoveryQuestionID, userRecoveryAnswer) "
         + "VALUES (\'" + userId + "\', \'" + realName + "\', \'" + bio +
         "\', \'" + email + "\', \'" + password + "\', \'" +
         userType + "\', \'" + secretQuestion + "\', \'" + secretAnswer + "\');";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }             
        
    }

    public boolean insertArticle(int articleId, String url, 
         String authorName, String providerName, String title, Date addDate, String category) throws SQLException {
        
        int authorId = 0;
        int providerId = 0;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(addDate);
        System.out.println("test: 1. insertArticle() article id: "+ articleId); // debug
        
        if (!authorExists(authorName)){
            authorId = generateID("AUT");
            System.out.println("test: 2. insertArticle() article id: "+ authorId); // debug
            insertAuthor(authorId, authorName);
        }
        else {
            try {
                ResultSet authorResult = dbqh.doQuery("SELECT authorID FROM authors "
                    + "WHERE authorName =\'" + authorName + "\';");
                if (authorResult.next())
                    authorId = authorResult.getInt("authorID");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }  
        }
        
        if (!providerExists(providerName)){
            providerId = generateID("PRV");
            System.out.println("test: 3. insertArticle() provider id: "+ providerId); // debug
            insertProvider(providerId, providerName);
        }
        else {
            try {
                ResultSet providerResult = dbqh.doQuery("SELECT providerID FROM providers "
                    + "WHERE providerName =\'" + providerName + "\';");
                if (providerResult.next())
                    providerId = providerResult.getInt("providerId");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }  
        }
        
        String command = "INSERT INTO articles VALUES ("
                + articleId + ", \'" + url + "\', " + authorId +
                ", \'" + providerId + "\', \'" + title + "\', \'" +
                date + "\');";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }              
    }

    public boolean insertRating(int ratingId, String userId,
        int articleId, int ratingValue, String ratingText, Date ratingDate) {
        String command = "INSERT INTO ratings VALUES ("
            + ratingId + ", \'" + userId + "\'," + articleId +
            ", " + ratingValue + ", \'" + ratingText + "\', \'" +
            ratingDate + "\');";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }              
    }

    public boolean insertProvider(int providerId, String providerName){
        String command = "INSERT INTO providers VALUES ("
            + providerId + ", \'" + providerName + "\', \'www.francisputthisintemporarily.com\');";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }
    
    public boolean insertAuthor(int authorId, String authorName){
        String command = "INSERT INTO authors VALUES ("
            + authorId + ", \'" + authorName + "\');";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    public boolean deleteAccount(String userId){
        String command = "DELETE FROM users WHERE userID = \'" + userId + "\';";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }
 
    public boolean deleteContent(int articleId) {
        String command = "DELETE FROM articles WHERE articleID = " + articleId + ";";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }     
    }
 
    public boolean updateUser(String userId, String password, 
        String email,String realName, String bio){
        
        String command = "UPDATE TABLE users SET userEmail = \'"
                + email + "\', userRealName = \'"
                + realName + "\', userBio = \'" 
                + bio + "\' WHERE userID = \'" + userId + "\';";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }  
    }

    public boolean updateUser(String userId, String password, String oldPassword,
        String email,String realName, String bio){
        
        String command = "UPDATE TABLE users SET userPassword = \'"
                + password + "\', userEmail = \'"
                + email + "\', userRealName = \'"
                + realName + "\', userBio = \'" 
                + bio + "\' WHERE userID = \'" + userId 
                + "\' AND userPassword = \'" + oldPassword + "\';";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }  
    }

    public boolean updateCategory(int articleId, String category){
        
        int articleCategoryId = 0;
        
        String command = "INSERT INTO articleCategories VALUES ("
                + articleCategoryId + ", \'"
                + articleId + "\', \'"
                + category + "\');";

        try {
            int resultCount = dbComHand.doCommand(command);
            dbComHand.close();
            return (resultCount > 0);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }
    
    public int generateID(String column) throws SQLException{
        boolean found = false;        
        int idNum = 0;
        
        ResultSet rs = null;
        
        try {
            while (!found) {
                idNum = (int) (Math.random() * 99999999) /* +1 */;
                //System.out.println("test: id " + idNum);            // debug
                switch(column){
                    case "ART": //articles
                        //System.out.println("test: id " + idNum);
                        rs = dbqh.doQuery("SELECT articleID FROM articles WHERE articleID = " + idNum + ";");
                        if (!rs.next()){
                            found = true;
                        }
                        break;
                    case "AUT": //authors
                        rs = dbqh.doQuery("SELECT authorID FROM authors WHERE authorID = " + idNum + ";");
                        if (!rs.next()){
                            found = true;
                        }
                        break;
                    case "PRV": //providers
                        rs = dbqh.doQuery("SELECT providerID FROM providers WHERE providerID = " + idNum + ";");
                        if (!rs.next()){
                            found = true;
                        }
                        break;
                    case "RAT":
                        rs = dbqh.doQuery("SELECT ratingID FROM ratings WHERE ratingID = " + idNum + ";");
                        if (!rs.next()){
                            found = true;
                        }
                        break;
                    default:
                        idNum = 0;
                        break;   
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return 0;
        }
        
        dbqh.close(); // added
                  
        return idNum;
    }
    
    public boolean authorExists(String authorName){
        
        try {
            ResultSet rs = dbqh.doQuery("SELECT authorName FROM authors "
                + "WHERE authorName = \'" + authorName + "\';");
            if (rs.next()) {
                // Francis added this, don't know if its good
                System.out.println("test: authorExists, nonempty resultSet");
                dbqh.close();           
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }
    public boolean providerExists(String providerName){
        
        try {
            ResultSet rs = dbqh.doQuery("SELECT providerName FROM providers "
                + "WHERE providerName = \'" + providerName + "\';");
            if (rs.next()) {
                // Francis added this, don't know if its good
                System.out.println("test: providerExists, nonempty resultSet");
                dbqh.close();           
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
        
        
    }
}
