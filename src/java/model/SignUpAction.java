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
 * SignUpAction is the action class for signup.jsp
 * @author katie
 */
public class SignUpAction extends ActionSupport {
    private String userId;    
    private String password; 
    private String confirmPassword;
    private String realName;
    private String bio = "This user has not created a bio yet.";
    private String email;

    private String secretQuestion;
    private int questionNum;
    private String secretAnswer;
    
    DBQueryHandler handler = new DBQueryHandler();

    /********
     * Validate() checks each private attribute for correctness.
     ********/     
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
    
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute() throws SQLException {
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
            dbqh.close();       // added
            return SUCCESS;
        }
        else
        {
            return INPUT;
        }
    }
    
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
     * @param String userid
     * 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /********
     * Getter for String password.
     * 
     * @return String password
     */
    public String getPassword() {
        return password;
    }
    
       /********
     * Setter for String password.
     * @param String password
     * 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /********
     * Getter for String confirmPassword.
     * 
     * @return String confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
       /********
     * Setter for String confirmPassword.
     * @param String confirmPassword
     * 
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    /********
     * Getter for String realName.
     * 
     * @return String realName
     */
    public String getRealName() {
        return realName;
    }
    
       /********
     * Setter for String realName.
     * @param String realName
     * 
     */
    public void setRealName(String realName)
    {
        this.realName = realName;
    }
    
        /********
     * Getter for String bio.
     * 
     * @return String bio
     */
    public String getBio() {
        return bio;
    }
    
       /********
     * Setter for String bio.
     * @param String bio
     * 
     */
    public void setBio(String bio) {
        this.bio = bio;
    }
    
        /********
     * Getter for String email.
     * 
     * @return String email
     */
    public String getEmail() {
        return email;
    }
    
       /********
     * Setter for String email.
     * @param String email
     * 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    

        /********
     * Getter for String secretQuestion.
     * 
     * @return String secretQuestion
     */
    public String getSecretQuestion() {
        return secretQuestion;
    }
    
       /********
     * Setter for String secretQuestion.
     * @param String secretQuestion
     * 
     */
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
    
        /********
     * Getter for String secretAnswer.
     * 
     * @return String secretAnswer
     */
    public String getSecretAnswer() {
        return secretAnswer;
    }
    
       /********
     * Setter for String secretAnswer.
     * @param String secretAnswer
     * 
     */
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
}
