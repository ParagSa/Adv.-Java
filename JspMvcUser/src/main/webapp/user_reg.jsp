<%@page import="com.parag.service.UserServiceImpli"%>
<%@page import="com.parag.service.UserService"%>
<jsp:useBean id="user" class="com.parag.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="user" />
<%
UserService userservice = new UserServiceImpli();
userservice.register(user);
response.sendRedirect("user_reg_form.jsp");

%>

