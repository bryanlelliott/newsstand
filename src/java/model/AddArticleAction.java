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
 * @author katie
 */
public class AddArticleAction extends ActionSupport {
    
    private int articleId;
    private int authorId;
    private int providerId;
    
    private String url;
    private String title;
    private String category;
    
    private Date addDate;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    
    
    public void validate(){
        ActionHelper helper = new ActionHelper();
        
        if(url == null )
        {
            addFieldError("url", "This field cannot be left blank.");
        }
        else if(title == null )
        {
            addFieldError("title", "This field cannot be blank.");
        }
         else if(category == null )
        {
            addFieldError("category", "This field cannot be blank.");
        }
        category = helper.injectionReplace(category);
        title = helper.injectionReplace(title);
        url = helper.injectionReplace(url);
    }
    
    public String execute(){
        DBUpdate dbu = new DBUpdate();
        articleId = dbu.generateID("ART");
        dbu.insertArticle(articleId, url, authorId, providerId, title, addDate, category);
        return SUCCESS;
    }
}
