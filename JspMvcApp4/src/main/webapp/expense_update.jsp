<%@page import="com.parag.service.expenseServiceImpli"%>
<%@page import="com.parag.service.expenseService"%>
<jsp:useBean id="expense" class="com.parag.modal.Expense"></jsp:useBean>
<jsp:setProperty property="*" name="expense" />

<%
expenseService expenseservice = new expenseServiceImpli();
expenseservice.renew(expense);
response.sendRedirect("expense_list.jsp");


%>