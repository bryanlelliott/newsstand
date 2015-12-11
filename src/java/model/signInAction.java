/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
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
    
public void validate() {
    ActionHelper helper = new ActionHelper();   
    
    if( userId == null )
       {
           addFieldError("userId", "This field cannot be blank.");
       }
       else if( password == null )
       {
           addFieldError("password", "This field cannot be blank.");
       }
       else if( userId.length() > 16 )
       {
           addFieldError("userId", "No userId is longer than 16 characters.");
       }
       else if( password.length() > 20 )
       {
           addFieldError("password", "Passwords are not allowed to be longer than 20 characters.");
       }
       else
       {
           userId = helper.injectionReplace(userId);
           password = helper.hashPassword(password);
           
           String query = "SELECT userId FROM users WHERE password='" +
                   password + "'";
       }
    }
public String execute() {
        
        String query = "SELECT userId FROM users WHERE password='" +
                   password + "'";
        DBQueryHandler handler = new DBQueryHandler();
        boolean found = false;
        try {
            ResultSet rs = handler.doQuery(query);
            if( rs.next() )
            {
                found = true;
            }
            else
            {
                found = false;
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        if( found )
        {
            return SUCCESS;
        }
        else
        {
            return "input";
        }
    }

}
