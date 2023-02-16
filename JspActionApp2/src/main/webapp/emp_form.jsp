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
<input type="text" name="empId">
</div>
<div>
<label>Name</label>
<input type="text" name="empName">
</div>
<div>
<label>Salary</label>
<input type="text" name="empSal">
</div>
<button type="submit">Submit</button>

</form>

</body>
</html>