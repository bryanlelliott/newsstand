/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author yokumtj
 */
public class DeleteUserAction extends ActionSupport {
    private String userId;
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void validate() {
        
    }
    
    public String execute() {
        DBUpdate dbu = new DBUpdate();
        
        dbu.deleteAccount(userId);
        
        return SUCCESS;
    }
}
