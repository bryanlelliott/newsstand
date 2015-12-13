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
 *
 * @author katie
 */
public class SignInAction extends ActionSupport {
    private String userId;    
    private String password; 
    private String realName;
    private boolean loggedIn;

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
                session.put("loggedIn", true);
                session.put("userId", userId);
                session.put("realName", realName);
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
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
    
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
}
