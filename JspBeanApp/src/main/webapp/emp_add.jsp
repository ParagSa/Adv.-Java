<%@page import="modal.Employee"%>
<%
String p1 = request.getParameter("eid");
String p2 = request.getParameter("ename");
String p3 = request.getParameter("esal");

int empId = Integer.parseInt(p1);
float empSal = Float.parseFloat(p3);

Employee e = new Employee();
e.setEmpId(empId);
e.setEmpName(p2);
e.setEmpSal(empSal);
session.setAttribute("emp", e);
response.sendRedirect("emp_info.jsp");

%>