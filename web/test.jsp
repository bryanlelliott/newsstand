<%-- 
    Document   : test
    Created on : Dec 11, 2015, 5:36:15 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <% 
            try {
                boolean loggedIn = (boolean)session.getAttribute("loggedIn");
                String realName = (String)session.getAttribute("realName");
                String userType = (String)session.getAttribute("userType");
                out.println(realName + " is logged in");
                out.println("as a " + userType + " user.");
            } catch (Exception jsp){
                out.println("User is not logged in");   
            }
        %>
        
        <h4>username: <s:property value="userId"/></h4>
        <h4>name: <s:property value="realName"/></h4>
        <h4>password: <s:property value="password"/></h4>
        <h4>confirmPassword: <s:property value="confirmPassword"/></h4>
        <h4>email: <s:property value="email"/></h4>
        <h4>bio: <s:property value="bio"/></h4>
        <h4>question: <s:property value="secretQuestion"/></h4>
        <h4>answer: <s:property value="secretAnswer"/></h4>
        <hr>
        <a href="browse.jsp">Go to Browse</a>
    </body>
</html>
