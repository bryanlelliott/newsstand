/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 *
 * @author katie
 */
public class ViewArticleAction {
    
        private String userID;
        int articleId;
        String category;
        
        
    /********
     * Validate() checks each private attribute for correctness.
     ********/ 
        public void validate() {
            
        }
    /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * @return String INPUT
     */
        public String execute() {
            return SUCCESS;
        }
}
