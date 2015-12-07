/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
/**
 *
 * @author katie
 */
public class signUpAction extends ActionSupport {
    private String userId;    
    private String realName;
    private String bio = "This user has not created a bio yet.";
    private String email;
    private String password;
    private String userType = "Regular";
    private boolean submitted;    
    // from bryan?
    private boolean loggedIn;

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
    
    // not sure if i need this
    public void validate() {
        if (!loggedIn) {
            DBQueryHandler handler = new DBQueryHandler();
            String query = "INSERT INTO users VALUES ("
                    + userId + ", " + realName + ", " + bio +
                    ", " + email + ", " + password + ", " +
                    userType + ")";
            
            try {
                handler.doQuery(query);
            }
            catch(SQLException SQLE)
            {
                SQLE.printStackTrace();
            }
            
            execute();
        }
        else if (loggedIn) {
            
        }
    }
    public String execute() {
        return SUCCESS;
    }

}
