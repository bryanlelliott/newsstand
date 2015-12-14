/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteUserAction is action class for article.jsp.
 * @author yokumtj
 */
public class DeleteUserAction extends ActionSupport {
    private String userId;
    
    /********
     * Getter for String userId.
     * 
     * @return String userId
     */
    public String getUserId() {
        return userId;
    }

    /********
     * Setter for String userId.
     * @param String userId
     * 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
        /********
     * Validate() checks each private attribute for correctness.
     ********/
    public void validate() {
        
    }
    
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute() {
        DBUpdate dbu = new DBUpdate();
        
        dbu.deleteAccount(userId);
        
        return SUCCESS;
    }
}
