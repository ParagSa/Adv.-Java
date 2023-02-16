<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form action="reg.jsp" method="post">
<div>
<label>User Name:</label>
<input type="text" name="uname" placeholder="enter user name">
</div>
<div>
<label>password:</label>
<input type="password" name="upass" placeholder="enter password">
</div>
<button type="submit" >Registration</button>
<a href="login_form.jsp">Back</a>


</form>


</body>
</html>