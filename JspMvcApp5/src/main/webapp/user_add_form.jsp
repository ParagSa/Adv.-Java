<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login form</title>
</head>
<body>
<form action="user_login.jsp" action="post">
<div>
<label>User Name :</label>
<input type="text" name="uname">
</div>
<div>
<label>Password :</label>
<input type="password" name="upass">
</div>
<button type="submit">login</button>
</form>
<a href="user_reg_form.jsp">New User?</a>

</body>
</html>