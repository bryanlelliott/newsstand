<%-- 
    Document   : logout
    Created on : Dec 13, 2015, 4:17:11 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    session.putValue("loggedIn", false);
    session.putValue("userId", "");
    session.putValue("realName", "");
    session.putValue("userType", "");
    session.putValue("password", "");
%>
<jsp:forward page="login.jsp"/>
