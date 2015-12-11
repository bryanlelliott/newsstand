/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.opensymphony.xwork2.ActionSupport;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
/**
 *
 * @author katie
 */
public class SignUpAction extends ActionSupport {
    private String userId;    
    private String password; 
    private boolean submitted;    
    private boolean loggedIn;
    private String realName;
    private String bio = "This user has not created a bio yet.";
    private String email;
    private String userType = "Regular";
    private int secretQuestion;
    private String secretAnswer;
    
    DBQueryHandler handler = new DBQueryHandler();
    
    // database name?

    /*
    NOTES FROM CH 10: SECURITY-ENCRYPTION
    // login handling
    If (...login is successful...) {  
        session.setAttribute("loggedIn", new Boolean (true));}
    // logout handling
    session.setAttribute("loggedIn", new Boolean (false));

    <%@ page %>
    <% Boolean loggedIn =   session.getAttribute("loggedIn"); 
        if (loggedIn == null || !loggedIn.booleanValue()) {   
               response.sendRedirect("/login.jsp"); }
    %> */  

    public boolean getLoggedIn() {

        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
    
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
        else if( realName == null )
        {
            addFieldError("realName", "This field cannot be blank.");
        }
        else if( email == null )
        {
            addFieldError("email", "This field cannot be blank.");
        }
        else if( userId.length() > 16 )
        {
            addFieldError("userId", "This field cannot be longer than 16 characters.");
        }
        else if( password.length() > 20 )
        {
            addFieldError("password", "This field cannot be longer than 20 characters.");
        }
        else if( realName.length() > 50 )
        {
            addFieldError("realName", "This field cannot be longer than 50 characters.");
        }
        else if( email.length() > 50 )
        {
            addFieldError("email", "This field cannot be longer than 50 characters.");
        }
        else if( bio.length() > 1000 )
        {
            addFieldError("bio", "This field cannot be longer than 1000 characters.");
        }
        else if( secretAnswer.length() > 500 )
        {
            addFieldError("secretAnswer", "This field cannot be longer than 500 characters.");
        }
        else
        {
            userId = helper.injectionReplace(userId);
            password = helper.hashPassword(password);
            realName = helper.injectionReplace(realName);
            bio = helper.injectionReplace(bio);
            email = helper.injectionReplace(email);
            secretAnswer = helper.injectionReplace(secretAnswer);
        }
    } 
   
    public String execute() {
        DBUpdate updater = new DBUpdate();
        
        updater.insertUser(userId, password, email, realName, bio, secretQuestion, secretAnswer, userType);
        
        return SUCCESS;
    }

}
