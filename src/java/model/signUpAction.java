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
public class signUpAction extends ActionSupport {
    private String userId;    
    private String password; 
    private boolean submitted;    
    // from bryan?
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
    
    private static String hashPassword(String password){
        String digest;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.reset();
            byte[] bytes = md.digest(password.getBytes());
            digest = new BigInteger(1, bytes).toString(16);
        }
        catch( NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
            digest = null;
        }
        
        return digest;
    }
    
    // not sure if i need this
    public void validate() {
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
            userId = userId.replaceAll("^<$", "&lt;");
            userId = userId.replaceAll("^>$", "&gt;");
            userId = userId.replaceAll("^\\($", "&#40");
            userId = userId.replaceAll("^\\)$", "&#41");
            userId = userId.replaceAll("^&$", "&#38");
            userId = userId.replaceAll("^|$", "&#124");
            
            password = hashPassword(password);
            
            realName = realName.replaceAll("^<$", "&lt;");
            realName = realName.replaceAll("^>$", "&gt;");
            realName = realName.replaceAll("^\\($", "&#40");
            realName = realName.replaceAll("^\\)$", "&#41");
            realName = realName.replaceAll("^&$", "&#38");
            realName = realName.replaceAll("^|$", "&#124");
            
            bio = bio.replaceAll("^<$", "&lt;");
            bio = bio.replaceAll("^>$", "&gt;");
            bio = bio.replaceAll("^\\($", "&#40");
            bio = bio.replaceAll("^\\)$", "&#41");
            bio = bio.replaceAll("^&$", "&#38");
            bio = bio.replaceAll("^|$", "&#124");
            
            email = email.replaceAll("^<$", "&lt;");
            email = email.replaceAll("^>$", "&gt;");
            email = email.replaceAll("^\\($", "&#40");
            email = email.replaceAll("^\\)$", "&#41");
            email = email.replaceAll("^&$", "&#38");
            email = email.replaceAll("^|$", "&#124");
            
            secretAnswer = secretAnswer.replaceAll("^<$", "&lt;");
            secretAnswer = secretAnswer.replaceAll("^>$", "&gt;");
            secretAnswer = secretAnswer.replaceAll("^\\($", "&#40");
            secretAnswer = secretAnswer.replaceAll("^\\)$", "&#41");
            secretAnswer = secretAnswer.replaceAll("^&$", "&#38");
            secretAnswer = secretAnswer.replaceAll("^|$", "&#124");
        }
    } 
   
    public String execute() {
        DBUpdate updater = new DBUpdate();
        
        updater.insertUser(userId, password, email, realName, bio, secretQuestion, secretAnswer, userType);
        
        return SUCCESS;
    }

}
