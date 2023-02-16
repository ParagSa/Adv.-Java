<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<form action="login.jsp" method="post">
<div>
<label>User Name:</label>
<input type="text" name="uname" placeholder="enter user name">
</div>
<div>
<label>password:</label>
<input type="password" name="upass" placeholder="enter password">
</div>
<button type="submit" >Login</button>
<a href="reg_form.jsp">New User ?</a>


</form>

</body>
</html>