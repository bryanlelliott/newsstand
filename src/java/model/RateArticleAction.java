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
        
    public void validate() {
        DBQueryHandler handler = new DBQueryHandler();

    }
    
    public String execute() {
        return SUCCESS;
    }
}
