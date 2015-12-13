<%-- 
    Document   : loginTest
    Created on : Dec 13, 2015, 3:34:43 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || !loggedIn.booleanValue()) {
%>
    <jsp:forward page="login.jsp"/>
<%
    }
%>
