/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class handles DB queries.
 * @author elliotbl
 */
public class DBQueryProcessor {
    
    DBQueryHandler dbqh = new DBQueryHandler();

    /********
     * Getter for String authorName.
     * @param String authorName
     * @return query for authorName
     */
    public ResultSet getAuthor(String authorName){
        String query = "SELECT * FROM authors WHERE authorName =\'" + authorName + "\';";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
        
    }
    
    /********
     * Getter for String users.
     * 
     * @return query for users
     */
    public ResultSet getUsers() {
        
        String query = "SELECT * FROM users;";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }
    
    /********
     * Getter for content.
     * 
     * @return query for content
     */
    public ResultSet getContent(String userId){
        
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
    
    /********
     * Getter for relevant articles.
     * 
     * @return query for articles
     */
    public ResultSet getRelevantArticles(){
        
        String query = "";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
    public ResultSet getPasswordRecovery(String userId){
        
        String query = "";
        
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
    /********
     * Getter for user.
     * 
     * @return query for user
     */
    public ResultSet getUser(String userId, String password){
        
        String query = "SELECT * FROM users WHERE userID = \'" + userId 
                + "\' AND userPassword = \'" + password + "\'";
        System.out.println("test: " + query);
        try {
            return dbqh.doQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }

    }
    
    /********
     * Ends/ closes the query.
     */
    public void endQuery() throws SQLException {
        
        dbqh.close();

    }
    
}
