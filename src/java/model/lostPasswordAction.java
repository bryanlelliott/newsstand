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
public class lostPasswordAction extends ActionSupport {
    private String userId;
    private int secretQuestion;
    private String secretAnswer;
    
        public void validate() {
        // ask secret question
        
        String query = "SELECT * FROM users WHERE userRecoveryQuestionID = '" + secretQuestion 
                    + "' AND userRecoveryAnswer = '" + secretAnswer + "'";
            
          
            // if the query returns null, then there is not a match.
               if (query == null) {
                // redirect to login.jsp
                // tell the user that their secret answer wasnt correct
               }
               else if (query != null) {
                   
               }
        }
        
        public String execute() {
            
            
            String newPassword = "X0j9eS3jlPo";
            DBQueryHandler handler = new DBQueryHandler();
            String query = "UPDATE users SET userPassword '" + newPassword + "'"
                    + "WHERE userId = '" + userId + "'";
            
            try {
                handler.doQuery(query);
            }
            catch(SQLException E)
            {
                E.printStackTrace();
            }
            
            return SUCCESS;
        }
   

    
}
