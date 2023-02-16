<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee form</title>
</head>
<body>
<form action="emp_add.jsp" method="post">
<div>
<label>Id</label>
<input type="text" name="eid">
</div>
<div>
<label>Name</label>
<input type="text" name="ename">
</div>
<div>
<label>Salary</label>
<input type="text" name="esal">
</div>
<button type="submit">Submit</button>

</form>

</body>
</html>