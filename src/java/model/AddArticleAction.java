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
    
    private String url;
    private String title;
    private String category;
    private String authorName;
    private String providerName;
    
    private Date addDate;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    
    public String getProviderName() {
        return providerName;
    }
    
    public void setProviderName() {
        this.providerName = providerName;
    }
    
    
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
