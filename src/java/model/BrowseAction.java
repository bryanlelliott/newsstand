/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.opensymphony.xwork2.Action.SUCCESS;
import model.ArticleBox;
/**
 * BrowseAction is the action class for browse.jsp.
 * @author francis
 */
public class BrowseAction {
    ArticleBox boxes[] = new ArticleBox[9];
     /*
     * execute() method goes to dbupdate.java to either return success or input.
     * @return String SUCCESS
     * 
     */
    public String execute() {
        
        return SUCCESS;
    }
}
