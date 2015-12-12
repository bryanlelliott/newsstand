/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elliotbl
 */
public class DBQueryProcessor {
    
    DBQueryHandler dbqh = new DBQueryHandler();

    private ResultSet getAuthor(String authorName){
        String query = "SELECT * FROM authors WHERE authorName = " + authorName + ";";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
        
    }
    
    private ResultSet getUsers() {
        
        String query = "SELECT * FROM users;";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }
    
    private ResultSet getContent(String userId){
        
        String query = "SELECT a.articleURL, a.articleURL, a.authorID, "
            + "a.providerID, a.articleTitle, a.articleAddDate,"
            + " a.ArticleCategory\n" +
            "FROM articles a, userArticles ua \n" +
            "WHERE ua.userID = " + userId + " AND a.articleID = ua.articleID;";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
    private ResultSet getRelevantArticles(){
        
        String query = "";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
    private ResultSet getPasswordRecovery(String userId){
        
        String query = "";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
    private ResultSet getUser(String userId, String password){
        
        String query = "SELECT * FROM users WHERE userid = \'" + userId 
                + "AND userPassword = \'" + password;
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
}
