<%@page import="com.parag.service.UserServiceImpli"%>
<%@page import="com.parag.service.UserService"%>
<%@page import="com.parag.modal.User"%>
<jsp:useBean id="user" class="com.parag.modal.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user" />
<%
UserService userservice = new UserServiceImpli();

if(userservice.account(user)){
	response.sendRedirect("loggedIn.jsp");
}else{
	response.sendRedirect("user_add_form.jsp?msg=wrong username/password");
}


%>