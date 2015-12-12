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
    private String confirmPassword;
    //private boolean submitted;    
    //private boolean loggedIn;
    private String realName;
    private String bio;
    private String email;
    // private String userType = "Regular";
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
    
    public void validate() {
        ActionHelper helper = new ActionHelper();
        
        if( userId.length() == 0 || userId == null )
        {
            addFieldError("userId", "This field cannot be blank.");
        }
        else if( password.length() == 0 || password == null )
        {
            addFieldError("password", "This field cannot be blank.");
        }
        else if( realName.length() == 0 || realName == null )
        {
            addFieldError("realName", "This field cannot be blank.");
        }
        else if( email.length() == 0 || email == null )
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
        
        if( updater.insertUser(userId, password, email, realName, bio, secretQuestion, secretAnswer, "Regular") )
        {
            return SUCCESS;
        }
        else
        {
            return INPUT;
        }
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
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName)
    {
        this.realName = realName;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getSecretQuestion() {
        return secretQuestion;
    }
    
    public void setSecretQuestion(int secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
    
    public String getSecretAnswer() {
        return secretAnswer;
    }
    
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
}
