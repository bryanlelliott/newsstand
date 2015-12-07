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

        public void validate() {
        
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
