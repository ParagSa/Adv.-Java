<%@page import="modal.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="e" class="modal.Employee" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3><jsp:getProperty  name="e"  property="empId"/></h3>
<h3><jsp:getProperty  name="e"  property="empName"/></h3>
<h3><jsp:getProperty  name="e"  property="empSal"/></h3>

</body>
</html>