<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="expense_add.jsp" action="post">
<div>
<%=(request.getParameter("msg")!=null)?request.getParameter("msg"):"" %>
</div>
<div>
<label>item :</label>
<input type="text" name="item">
</div>
<div>
<label>price :</label>
<input type="text" name="price">
</div>
<div>
<label>quantity :</label>
<input type="text" name="quantity">
</div>
<div>
<label>date :</label>
<input type="text" name="edate">
</div>
<button type="submit">Add</button>
</form>

</body>
</html>