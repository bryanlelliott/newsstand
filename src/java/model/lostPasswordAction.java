/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * @author katie
 */
public class lostPasswordAction extends ActionSupport {
    private Boolean lostPassword;

    
        public void validate() {
        if (!lostPassword) {
            // redirect to login page
        }
        else if (lostPassword) {
            // redirect to lost password page where new password will be generated
        }
    }
   

    
}
