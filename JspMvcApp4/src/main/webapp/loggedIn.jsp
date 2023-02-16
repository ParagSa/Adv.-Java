
<%@page import="com.parag.modal.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
  User user = (User)session.getAttribute("user");
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Account</title>
</head>
<body>
<h1>Successfully logged in!!!!!</h1>
<h3><%=user.getUname() %></h3>
<h3><%=user.getUpass() %></h3>
<%@include file="user_menu.jsp" %>

</body>
</html>