<%@page import="com.parag.modal.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.parag.service.expenseServiceImpli"%>
<%@page import="com.parag.service.expenseService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    expenseService expenseservice = new expenseServiceImpli();
    List<Expense> expenses = expenseservice.getAll(0);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense list</title>
</head>
<body>
<table>
<thead>
<tr>
<th>Item</th>
<th>price</th>
<th>quantity</th>
<th>date</th>
<th>delete</th>
</tr>
</thead>
<tbody>
<%for(Expense expense : expenses){ %>
<tr>
<td><%=expense.getItem() %></td>
<td><%=expense.getPrice() %></td>
<td><%=expense.getQauntity() %></td>
<td><%=expense.getEdate() %></td>
<td><a href="expense_delete.jsp?id=<%=expense.getId() %>">Delete</a></td>
</tr>
<%} %>
</tbody>
</table>

</body>
</html>