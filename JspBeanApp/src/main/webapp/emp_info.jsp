<%@page import="modal.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Employee e = (Employee)session.getAttribute("emp");

%>
<h3><%=e.getEmpId()%></h3>
<h3><%=e.getEmpName()%></h3>
<h3><%=e.getEmpSal()%></h3>

</body>
</html>