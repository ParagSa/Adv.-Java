
<jsp:useBean id="e" class="modal.Employee" scope="session"></jsp:useBean>
<jsp:setProperty  name="e" param="eid" property="empId"/>

<jsp:setProperty  name="e" param="ename" property="empName"/>

<jsp:setProperty  name="e" param="esal" property="empSal"/>
<%

response.sendRedirect("emp_info.jsp");

%>