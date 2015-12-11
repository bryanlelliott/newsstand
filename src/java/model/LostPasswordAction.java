/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author katie
 */
public class LostPasswordAction extends ActionSupport {
    private String userId;
    private int secretQuestion;
    private String secretAnswer;
    
        public void validate() {
        
        ActionHelper helper = new ActionHelper();
        
        userId = helper.injectionReplace(userId);
        secretAnswer = helper.injectionReplace(secretAnswer);
        }
        
        public String execute() {
           
            DBQueryHandler handler = new DBQueryHandler();
            String query = "SELECT * FROM users WHERE userRecoveryAnswer='" +
                    secretAnswer + "'";
            boolean found = false;
            
            try {
                ResultSet rs = handler.doQuery(query);
                if( rs.next() )
                {
                    found = true;
                }
                else
                {
                    found = false;
                }
            }
            catch(SQLException E)
            {
                E.printStackTrace();
            }
            if( found )
            {
                String newPassword = "X0j9eS3jlPo";
                query = "UPDATE users SET password='" + newPassword +
                        "' WHERE userId ='" + userId + "'";
                try {
                    handler.doQuery(query);
                }
                catch( SQLException e )
                {
                    e.printStackTrace();
                }
                return SUCCESS;
            }
            else
            {
                return "input";
            }
        }
   

    
}
