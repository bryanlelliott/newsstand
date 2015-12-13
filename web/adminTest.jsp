<%-- 
    Document   : adminTest
    Created on : Dec 13, 2015, 3:38:09 PM
    Author     : francis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String userType = (String) session.getAttribute("userType");
    if (!userType.equals("admin")) {
%>
    <jsp:forward page="browse.jsp"/>
<%
    }
%>

