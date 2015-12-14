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
 * AddArticleAction is the action class for article.jsp.
 */
public class AddArticleAction extends ActionSupport {
    
    private int articleId;
    
    private String url;
    private String title;
    private String category;
    private String authorName;
    private String providerName;
    
    private Date addDate;

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
     * Getter for String url.
     * 
     * @return String articleId
     */
    public String getUrl() {
        return url;
    }
    
    /********
     * Setter for String url.
     * @param String url
     * 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /********
     * Getter for String title.
     * 
     * @return String title
     */
    public String getTitle() {
        return title;
    }

    /********
     * Setter for String title.
     * @param String title
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /********
     * Getter for String category.
     * 
     * @return String category
     */
    public String getCategory() {
        return category;
    }

    /********
     * Setter for String category.
     * @param String category
     * 
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /********
     * Getter for String authorName.
     * 
     * @return String authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /********
     * Setter for String authorName.
     * @param String authorName
     * 
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /********
     * Getter for String addDate.
     * 
     * @return String addDate
     */
    public Date getAddDate() {
        return addDate;
    }

    /********
     * Setter for String title.
     * @param String title
     * 
     */
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    
    /********
     * Getter for String providerName.
     * 
     * @return String providerName
     */
    public String getProviderName() {
        return providerName;
    }
    
    /********
     * Setter for String providerName.
     * @param String providerName
     * 
     */
    public void setProviderName() {
        this.providerName = providerName;
    }
    
    /********
     * Validate() checks each private attribute for correctness.
     ********/
    public void validate(){
        ActionHelper helper = new ActionHelper();
        
        if( url.length() == 0 || url == null )
        {
            addFieldError("url", "This field cannot be left blank.");
        }
        else if( !url.startsWith("http") || !url.startsWith("www") )
        {
            addFieldError("url", "Please copy and paste a real URL.");
        }
        else if( title.length() == 0 || title == null )
        {
            addFieldError("title", "This field cannot be blank.");
        }
        else if( authorName.length() == 0 || authorName == null )
        {
            addFieldError("authorName", "This field cannot be left blank.");
        }
        else if( providerName.length() == 0 || providerName == null )
        {
            addFieldError("providerName", "This field cannot be left blank.");
        }
     
        title = helper.injectionReplace(title);
        url = helper.injectionReplace(url);
        addDate = new Date();
        authorName = helper.injectionReplace(authorName);
        providerName = helper.injectionReplace(providerName);
    }
    
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute(){
        DBUpdate dbu = new DBUpdate();
        articleId = dbu.generateID("ART");
        if( dbu.insertArticle(articleId, url, authorName, providerName, title, addDate, category) )
        {
            return SUCCESS;
        }
        else
        {
            return INPUT;
        }
    }
}
