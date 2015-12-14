/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import java.sql.SQLException;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * RateArticleAction is the action class for article.jsp
 * @author bryanlelliott
 */
public class RateArticleAction extends ActionSupport {
    private int ratingID;
    private int articleID;
    private String ratingValue;
    private int rating;

    private String userID;
    private String ratingText;

    private Date ratingDate;

    /********
     * Getter for int ratingId.
     * 
     * @return int ratingId
     */
    public int getRatingID() {
        return ratingID;
    }

   /********
     * Setter for int ratingId.
     * @param int ratingId
     * 
     */
    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    /********
     * Getter for int articleId.
     * 
     * @return int articleId
     */
    public int getArticleID() {
        return articleID;
    }

       /********
     * Setter for int articleId.
     * @param int articleid
     * 
     */
    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

   /********
     * Getter for String ratingValue.
     * 
     * @return String ratingValue
     */
    public String getRatingValue() {
        return ratingValue;
    }

    /********
     * Setter for String ratingValue.
     * @param String ratingValue
     * 
     */
    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    /********
     * Getter for String userId.
     * 
     * @return String userId
     */
    public String getUserID() {
        return userID;
    }

    /********
     * Setter for String userid.
     * @param String userid
     * 
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /********
     * Getter for String ratingText.
     * 
     * @return String ratingText
     */
    public String getRatingText() {
        return ratingText;
    }

    /********
     * Setter for String ratingText.
     * @param String ratingText
     * 
     */
    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    /********
     * Getter for Date ratingDate.
     * 
     * @return Date ratingDate
     */
    public Date getRatingDate() {
        return ratingDate;
    }

    /********
     * Setter for Date ratingDate.
     * @param Date ratingDate
     * 
     */
    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }
    
        
    
    /********
     * Validate() checks each private attribute for correctness.
     ********/ 
    public void validate() {
        DBQueryHandler handler = new DBQueryHandler();
        ActionHelper helper = new ActionHelper();
        
        if( ratingValue.equals("0") )
        {
            rating = 0;
        }
        else if( ratingValue.equals("1") )
        {
            rating = 1;
        }
        else if( ratingValue.equals("2") )
        {
            rating = 2;
        }
        else if( ratingValue.equals("3") )
        {
            rating = 3;
        }
        else if( ratingValue.equals("4") )
        {
            rating = 4;
        }
        else if( ratingValue.equals("5") )
        {
            rating = 5;
        }
        else if( ratingText.length() != 0 || ratingText != null )
        {
            ratingText = helper.injectionReplace(ratingText);
        }
        else
        {
            ratingDate = new Date();
        }

    }
    
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute() throws SQLException {
        DBUpdate dbu = new DBUpdate();
        ratingID = dbu.generateID("RAT");
        dbu.insertRating(ratingID, userID, articleID, rating, ratingText, ratingDate);
        return SUCCESS;
    }
}
