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
 * DeleteArticleAction is action class for article.jsp.
 * @author katie
 */
public class DeleteArticleAction extends ActionSupport {
    private int articleId;

    /********
     * Getter for int articleId.
     * 
     * @return int articleId
     */
    public int getArticleId() {
        return articleId;
    }

        /********
     * Setter for int articleId.
     * @param int articleId
     * 
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    
    /********
     * Validate() checks each private attribute for correctness.
     ********/
    public void validate(){
        
    }
    
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute(){
        DBUpdate dbu = new DBUpdate();
        dbu.deleteContent(articleId);
        return SUCCESS;
    }
}
