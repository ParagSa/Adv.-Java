<%
session.removeAttribute("user");
session.invalidate();
response.sendRedirect("user_add_form.jsp");
%>