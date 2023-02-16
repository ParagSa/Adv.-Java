<%@page import="java.util.Date" %>
<%@page errorPage="error.jsp" %>

<%@include file="header.jsp" %>

<%="<h1>"+new Date()+"</h1>" %>

<%!
int res;
 void divide(int i,int j){
	 res = i/j;
 }

%>
<%
String p1 = request.getParameter("num1");
String p2 = request.getParameter("num2");
int i = Integer.parseInt(p1);
int j = Integer.parseInt(p2);
divide(i, j);

%>
<%=res%>