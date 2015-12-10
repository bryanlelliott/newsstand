/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
/**
 *
 * @author katie
 */
public class signInAction extends ActionSupport {
    private String userId;    
    private String password; 
    private boolean loggedIn;
    
    // perhaps use userType     
    private String userType = "Regular";
    
    DBQueryHandler handler = new DBQueryHandler();
    
public void validate() {
       
    }
public String execute() {
        return SUCCESS;
    }

}
