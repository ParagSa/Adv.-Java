<%@page import="java.lang.reflect.Parameter"%>
<%@page import="com.parag.modal.Expense"%>
<%@page import="com.parag.service.expenseServiceImpli"%>
<%@page import="com.parag.service.expenseService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    String p1 = request.getParameter("id");
    int id = Integer.parseInt(p1);
    expenseService expenseservice =new expenseServiceImpli();
    Expense expense = expenseservice.getById(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Update</title>
</head>
<body>
<form action="expense_update.jsp" action="post">
<input type="hidden" name="id" value="<%=expense.getId()%>">
<div>
<label>item :</label>
<input type="text" name="item" value="<%=expense.getItem()%>">
</div>
<div>
<label>price :</label>
<input type="text" name="price" value="<%=expense.getPrice()%>">
</div>
<div>
<label>quantity :</label>
<input type="text" name="quantity" value="<%=expense.getQuantity()%>">
</div>
<div>
<label>date :</label>
<input type="text" name="edate" value="<%=expense.getEdate() %>>">
</div>
<button type="submit">update</button>
</form>

</body>
</html>