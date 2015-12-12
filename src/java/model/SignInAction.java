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
public class SignInAction extends ActionSupport {
    private String userId;    
    private String password; 
    private boolean loggedIn;
    
    // perhaps use userType     
    private String userType = "Regular";

    /*public void validate() {
    ActionHelper helper = new ActionHelper();
    DBQueryHandler handler = new DBQueryHandler();
    
    if( userId.length() == 0 || userId == null )
       {
           addFieldError("userId", "This field cannot be blank.");
       }
       else if( password.length() == 0 || password == null )
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
       }
    }*/
    public String execute() {
        
        String query = "SELECT password FROM users WHERE userId='" +
                   userId + "'";
        DBQueryHandler handler = new DBQueryHandler();
        // ActionHelper helper = new ActionHelper();
        String userPassword = "";
   
        try {
            ResultSet rs2 = handler.doQuery(query);
            if( rs2.getString("userPassword") != null )
            {
                userPassword = rs2.getString("userPassword");
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        if( password.equals(userPassword) )
        {
            loggedIn = true;
            return SUCCESS;
        }
        else
        {
            loggedIn = false;
            return "input";
        }
    }

}
