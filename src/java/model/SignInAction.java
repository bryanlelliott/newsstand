/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
/**
 * SignInAction is the action class for login.jsp
 * @author katie
 */
public class SignInAction extends ActionSupport {
    private String userId;    
    private String password; 
    private String realName;
    private String userType;
    private boolean loggedIn;

    /********
     * Validate() checks each private attribute for correctness.
     ********/ 
    public void validate() {
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
    }
    
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute() {
        String ret = INPUT;
        DBQueryProcessor processor = new DBQueryProcessor();
        ActionHelper helper = new ActionHelper();
        Map session = (Map) ActionContext.getContext().get("session");
   
        try {
            ResultSet rs = processor.getUser(userId, password);
            
            if(rs.next())
            {
                realName = rs.getString(2);
                userType = rs.getString(8);
                session.put("loggedIn", true);
                session.put("userId", userId);
                session.put("realName", realName);
                session.put("userType", userType);
                processor.endQuery();
                rs.close();
                ret = SUCCESS;
            }
        } catch( SQLException e ) {
            e.printStackTrace();
            session.put("loggedIn", false);
            ret = INPUT;
        }
        return ret;
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
     * @param String userid
     * 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /********
     * Getter for boolean loggedIn.
     * 
     * @return boolean loggedIn
     */
    public boolean getLoggedIn() {
        return loggedIn;
    }
    
   /********
     * Setter for boolean loggedIN.
     * @param boolean loggedIn
     * 
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    /********
     * Getter for String userType.
     * 
     * @return String userType
     */
    public String getUserType() {
        return userType;
    }
    
   /********
     * Setter for String userType.
     * @param String userType
     * 
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
}
