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
 * LostPasswordAction is action class for lostpassword.jsp.
 * @author katie
 */
public class LostPasswordAction extends ActionSupport {
    private String userId;
    private int secretQuestion;
    private String secretAnswer;
    private String password;

   /********
     * Validate() checks each private attribute for correctness.
     ********/ 
    public void validate() {
        
        ActionHelper helper = new ActionHelper();
        if( userId.length() == 0 )
        {
            addFieldError("userId", "You must enter your userId.");
        }
        else if( userId.length() > 16 )
        {
            addFieldError("userId", "There is no userId longer than 16 characters.");
        }
        else if( secretAnswer.length() == 0 )
        {
            addFieldError("secretAnswer", "You must answer your secret question.");
        }
        userId = helper.injectionReplace(userId);
        secretAnswer = helper.injectionReplace(secretAnswer);
        }

    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
    public String execute() {
           
            DBQueryHandler handler = new DBQueryHandler();
            String query = "SELECT password FROM users WHERE userRecoveryAnswer='" +
                    secretAnswer + "'" + "AND userId='" + userId + "'";
            boolean found = false;
            
            try {
                ResultSet rs = handler.doQuery(query);
                if( rs.next() )
                {
                    found = true;
                    password = rs.getString("userPassword");
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
