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
public class DeleteArticleAction extends ActionSupport {
    private int articleId;
    
    public void validate(){
        
    }
    
    public String execute(){
        DBUpdate dbu = new DBUpdate();
        dbu.deleteContent(articleId);
        return SUCCESS;
    }
}
