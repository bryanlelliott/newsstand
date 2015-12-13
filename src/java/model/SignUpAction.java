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
import java.sql.ResultSet;
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

    private String secretQuestion;
    private int questionNum;
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
        else if( secretAnswer.length() == 0 || secretAnswer == null )
        {
            addFieldError("email", "This field cannot be blank.");
        }
        else if( confirmPassword.length() == 0 || confirmPassword == null )
        {
            addFieldError("confirmPassword", "This field cannot be left blank.");
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
        else if( !confirmPassword.equals(password) )
        {
            addFieldError("confirmPassword", "This field must be equivalent to your password.");
        }
        else
        {
            userId = helper.injectionReplace(userId);
            password = helper.hashPassword(password);
            realName = helper.injectionReplace(realName);
            bio = helper.injectionReplace(bio);
            email = helper.injectionReplace(email);
            secretAnswer = helper.injectionReplace(secretAnswer);
            
        if (secretQuestion.equals("What is the name of your childhood best friend?"))
            questionNum = 1;
        else if (secretQuestion.equals("What city were you born in?"))
            questionNum = 2;
        else if (secretQuestion.equals("What is the name of your first pet?"))
            questionNum = 3;
        else if (secretQuestion.equals("What is your favorite color?"))
            questionNum = 4;
        else if (secretQuestion.equals("Who is your favorite celebrity?"))
            questionNum = 5;
        }
    } 
    
    public String execute() {
        DBUpdate updater = new DBUpdate();
        DBQueryHandler dbqh = new DBQueryHandler();
        String query = "SELECT userId FROM users WHERE userId=\'" + userId + "\';";
        boolean found = false;
        
        try {
            ResultSet rs = dbqh.doQuery(query);
            if( rs.next() )
            {
                found = true;
                addFieldError("userId", "This means the query is working.");
            }
            else
            {
                found = false;
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
            addFieldError("userId", "This means the query isn't working.");
        }
        if (updater.insertUser(userId, password, email, realName, bio, questionNum, secretAnswer, "Regular"))
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
    

    public String getSecretQuestion() {
        return secretQuestion;
    }
    
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
    
    public String getSecretAnswer() {
        return secretAnswer;
    }
    
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
}
