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
public class EditProfileAction extends ActionSupport{
    private String editName;
    private String editEmail;
    private String editBio;
    private String oldPassword;
    private String editPassword;
    private String confirmPassword;
    private String userId;

    public String getEditName() {
        return editName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEditName(String editName) {
        this.editName = editName;
    }

    public String getEditEmail() {
        return editEmail;
    }

    public void setEditEmail(String editEmail) {
        this.editEmail = editEmail;
    }

    public String getEditBio() {
        return editBio;
    }

    public void setEditBio(String editBio) {
        this.editBio = editBio;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getEditPassword() {
        return editPassword;
    }

    public void setEditPassword(String editPassword) {
        this.editPassword = editPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
   
    public void validate()
    {
        ActionHelper helper = new ActionHelper();
        
        if( editName == null )
        {
            addFieldError("editName", "This field cannot be left blank.");
        }
        else if( editEmail == null )
        {
            addFieldError("editEmail", "This field cannot be blank.");
        }
 
        editName = helper.injectionReplace(editName);
        editEmail = helper.injectionReplace(editEmail);
        editBio = helper.injectionReplace(editBio);
        if( oldPassword != null )
        {
            oldPassword = helper.hashPassword(oldPassword);
            DBQueryHandler handler = new DBQueryHandler();
            String query = "SELECT * FROM users WHERE userPassword='" +
                    oldPassword + "'";
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
            catch( SQLException e )
            {
                e.printStackTrace();
            }
            
            if( !found )
            {
                addFieldError("oldPassword", "You entered the incorrect password.");
            }
            else
            {
                if( editPassword.equals(confirmPassword) )
                {
                    if( editPassword == null )
                    {
                        addFieldError("editPassword", "Your new password cannot be empty.");
                    }
                    else if( editPassword.length() > 20 )
                    {
                        addFieldError("editPassword", "Your new password cannot be longer than 20 characters.");
                    }
                    else if( confirmPassword == null )
                    {
                        addFieldError("confirmPassword", "You must confirm your new password.");
                    }
                    else if( confirmPassword.length() > 20 )
                    {
                        addFieldError("confirmPassword", "Your new password cannot be longer than 20 characters.");
                    }
                    else
                    {
                        editPassword = helper.hashPassword(editPassword);
                    }
                }
            }
        }
    }
    
    public String execute()
    {
        DBUpdate updater = new DBUpdate();
        
        if( oldPassword != null )
        {
            updater.updateUser(userId, editPassword, editEmail, editName, NONE, editName);
        }
        else
        {
            updater.updateUser(userId, editEmail, editName, NONE, editName);
        }
        return SUCCESS;
    }
}
