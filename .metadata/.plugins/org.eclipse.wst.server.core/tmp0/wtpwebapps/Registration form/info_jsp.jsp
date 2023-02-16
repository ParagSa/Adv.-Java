<%@page import="modal.user"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:useBean id="user" class="modal.user" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info</title>
</head>
<body>
<h3><jsp:getProperty  name="user"  property="userName"/></h3>
<h3><jsp:getProperty  name="user"  property="userPass"/></h3>
<h3><jsp:getProperty  name="user"  property="userEmail"/></h3>

</body>
</html>