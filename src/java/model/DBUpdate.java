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
         String authorName, String providerName, String title, Date addDate, String category) {
        
        int authorId = 0;
        
        if (!authorExists(authorName)){
            authorId = generateID("AUT");
            insertAuthor(authorId, authorName);
        }
        else {
            try {
                ResultSet authorResult = dbqh.doQuery("SELECT authorID FROM authors "
                    + "WHERE authorName =\'" + authorName + "\';");
                authorId = authorResult.getInt("authorId");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }  
        }
        
        String command = "INSERT INTO articles VALUES ("
                + articleId + ", \'" + url + "\', " + authorId +
                "\', \'" + providerName + "\', \'" + title + "\', \'" +
                addDate + "\',\'" + category + "\');";

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
        String command = "INSERT INTO ratings VALUES ("
            + providerId + ", \'" + providerName + "\');";

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
    
    public int generateID(String column){
        boolean found = false;        
        int idNum = 0;
        
        ResultSet rs = null;
        
        try {
            while (!found) {
                idNum = (int) Math.random() * 99999999;
                switch(column){
                    case "ART": //articles
                        rs = dbqh.doQuery("SELECT articleID FROM articles WHERE articleID = " + idNum + ";");
                        if (rs == null){
                            found = true;
                        }
                        break;
                    case "AUT": //authors
                        rs = dbqh.doQuery("SELECT authorID FROM authors WHERE authorID = " + idNum + ";");
                        if (rs == null){
                            found = true;
                        }
                        break;
                    case "PRV": //providers
                        rs = dbqh.doQuery("SELECT providerID FROM providers WHERE providerID = " + idNum + ";");
                        if (rs == null){
                            found = true;
                        }
                        break;
                    case "RAT":
                        rs = dbqh.doQuery("SELECT ratingID FROM ratings WHERE ratingID = " + idNum + ";");
                        if (rs == null){
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
                  
        return idNum;
    }
    
    public boolean authorExists(String authorName){
        
        try {
            ResultSet rs = dbqh.doQuery("SELECT authorName FROM authors "
                + "WHERE authorName = \'" + authorName + "\';");
            if (rs != null) {
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
