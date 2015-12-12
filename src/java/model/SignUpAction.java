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
    private String bio = "This user has not created a bio yet.";
    private String email;
    // private String userType = "Regular";
<<<<<<< HEAD
    //private int secretQuestion;
=======
    private String secretQuestion;
    private int questionNum;
>>>>>>> 99c96dbc6413875f71cacb64828a003c7d0202c7
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
    
    /*public void validate() {
        // ActionHelper helper = new ActionHelper();
        
        if( userId == null )
        {
            addFieldError("userId", "This field cannot be blank.");
        }
        if( password == null )
        {
            addFieldError("password", "This field cannot be blank.");
        }
        if( realName == null )
        {
            addFieldError("realName", "This field cannot be blank.");
        }
        if( email == null )
        {
            addFieldError("email", "This field cannot be blank.");
        }
        if( userId.length() > 16 )
        {
            addFieldError("userId", "This field cannot be longer than 16 characters.");
        }
        if( password.length() > 20 )
        {
            addFieldError("password", "This field cannot be longer than 20 characters.");
        }
        if( realName.length() > 50 )
        {
            addFieldError("realName", "This field cannot be longer than 50 characters.");
        }
        if( email.length() > 50 )
        {
            addFieldError("email", "This field cannot be longer than 50 characters.");
        }
        if( bio.length() > 1000 )
        {
            addFieldError("bio", "This field cannot be longer than 1000 characters.");
        }
        if( secretAnswer.length() > 500 )
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
    } */
    
    public String execute() {
        DBUpdate updater = new DBUpdate();
        
<<<<<<< HEAD
        if( updater.insertUser(userId, password, email, realName, bio, 2, secretAnswer, "Regular") )
=======
        if (secretQuestion.equals("What is the name of your childhood best friend?"))
            questionNum = 1;
        if (secretQuestion.equals("What city were you born in?"))
            questionNum = 2;
        if (secretQuestion.equals("What is the name of your first pet?"))
            questionNum = 3;
        if (secretQuestion.equals("What is your favorite color?"))
            questionNum = 4;
        if (secretQuestion.equals("Who is your favorite celebrity?"))
            questionNum = 5;
        if (password.equals(confirmPassword))
>>>>>>> 99c96dbc6413875f71cacb64828a003c7d0202c7
        {
            
        }
        else {
            addFieldError("confirmPassword", "The passwords must be matching");
            return INPUT;
        }
        if (updater.insertUser(userId, password, email, realName, bio, questionNum, secretAnswer, "Regular"))
            return SUCCESS;
        else
            return ERROR;
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
    
<<<<<<< HEAD
    /*public int getSecretQuestion() {
=======
    public String getSecretQuestion() {
>>>>>>> 99c96dbc6413875f71cacb64828a003c7d0202c7
        return secretQuestion;
    }
    
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }*/
    
    public String getSecretAnswer() {
        return secretAnswer;
    }
    
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
}
