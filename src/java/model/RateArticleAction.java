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
 *
 * @author bryanlelliott
 */
public class RateArticleAction extends ActionSupport {
    private int ratingID;
    private int articleID;
    private int ratingValue;

    private String userID;
    private String ratingText;

    private Date ratingDate;

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }
    
    
        
    public void validate() {
        DBQueryHandler handler = new DBQueryHandler();

    }
    
    public String execute() {
        DBUpdate dbu = new DBUpdate();
        dbu.insertRating(ratingID, userID, articleID, ratingValue, ratingText, ratingDate);
        return SUCCESS;
    }
}
