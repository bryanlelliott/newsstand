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
public class signUpAction extends ActionSupport {
    private String userId;    
    private String password; 
    private boolean submitted;    
    // from bryan?
    private boolean loggedIn;
    
    DBQueryHandler handler = new DBQueryHandler();
    
    // database name?

    /*
    NOTES FROM CH 10: SECURITY-ENCRYPTION
    // login handling
    If (...login is successful...) {  
        session.setAttribute("loggedIn", new Boolean (true));}
    // logout handling
    session.setAttribute("loggedIn", new Boolean (false));

    <%@ page %>
    <% Boolean loggedIn =   session.getAttribute("loggedIn"); 
        if (loggedIn == null || !loggedIn.booleanValue()) {   
               response.sendRedirect("/login.jsp"); }
    %> */  
    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
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

    public Boolean getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Boolean submitted) {
        this.submitted = submitted;
    }
    
    // not sure if i need this
    public void validate() {
        if (!loggedIn) {
            String query = "INSERT INTO users VALUE " + userId + " " + password;
            
        }
        else if (loggedIn) {
            // redirect to article list
        }
    }
    public String execute() {
        return SUCCESS;
    }

}
