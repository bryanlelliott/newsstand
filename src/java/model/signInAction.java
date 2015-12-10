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
public class signInAction {
    private String userId;    
    private String password; 
    private boolean loggedIn;
    
    // perhaps use userType     
    private String userType = "Regular";
    
    DBQueryHandler handler = new DBQueryHandler();
    
public void validate() {
        if (!loggedIn) {
            DBQueryHandler handler = new DBQueryHandler();
            String query = "";
            
            // if logging in 
            query = "SELECT * FROM users WHERE userID = '" + userId 
                    + "' AND password = '" + password + "'";
            
          
            try {
                handler.doQuery(query);
            }
            catch(SQLException SQLE)
            {
                SQLE.printStackTrace();
            }
            
            // compare the result 
            // if the query returns null, then there is not a match.
               //if (result == null) {
                // redirect to login.jsp because the password didnt work.
              // }
               //else if (result != null) {
                  // execute();
               //}

             
            
        }        else if (loggedIn) {
            //execute();
        }
    }
   // public String execute() {
        //return SUCCESS;
    //}

}
