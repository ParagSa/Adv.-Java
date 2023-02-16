<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
<form action="user_reg.jsp" action="post">
<div>
<label>User Name :</label>
<input type="text" name="uname">
</div>
<div>
<label>Password :</label>
<input type="password" name="upass">
</div>
<button type="submit">Register</button>
</form>
<a href="user_add_form.jsp">back</a>

</body>
</html>