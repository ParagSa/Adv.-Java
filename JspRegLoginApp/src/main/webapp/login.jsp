<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>

<% 
String uname = request.getParameter("uname");
String upass = request.getParameter("upass");

Class.forName("com.mysql.cj.jdbc.Driver");
//create connection
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
	"parag123");
PreparedStatement s = con.prepareStatement("select * from userjsp where uname=? and upass=?");
s.setString(1, uname);
s.setString(2, upass);
ResultSet rs = s.executeQuery();
boolean flag = false;
if(rs.next()){
	flag = true;
}


s.close();
con.close();
if(flag){
	response.sendRedirect("home.jsp");
}else{
	response.sendRedirect("login_form.jsp");
}


%>