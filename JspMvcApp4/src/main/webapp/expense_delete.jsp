<%@page import="com.parag.service.expenseServiceImpli"%>
<%@page import="com.parag.service.expenseService"%>
<%
String p1 = request.getParameter("id");
int id = Integer.parseInt(p1);
expenseService expencservice = new expenseServiceImpli();
expencservice.removeById(id);
response.sendRedirect("expense_list.jsp");


%>