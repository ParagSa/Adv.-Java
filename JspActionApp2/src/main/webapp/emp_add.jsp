
<jsp:useBean id="e" class="modal.Employee" scope="session"></jsp:useBean>
<jsp:setProperty  name="e"  property="*"/>


<%

response.sendRedirect("emp_info.jsp");

%>