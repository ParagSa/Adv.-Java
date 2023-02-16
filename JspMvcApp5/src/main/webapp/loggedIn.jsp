
<%@page import="com.parag.modal.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="cache_control_page.jsp" %>  
 <%
  User user = (User)session.getAttribute("user");
 	if(user!=null && user.getUname()!=null ){
 		
 	
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
<%
 	}else{
 		response.sendRedirect("logout.jsp");
 	}
%>