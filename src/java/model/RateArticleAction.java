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
    private String ratingValue;
    private int rating;

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

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
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
    
    public String execute() {
        DBUpdate dbu = new DBUpdate();
        ratingID = dbu.generateID("RAT");
        dbu.insertRating(ratingID, userID, articleID, rating, ratingText, ratingDate);
        return SUCCESS;
    }
}
