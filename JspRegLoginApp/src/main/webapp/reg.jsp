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
PreparedStatement s = con.prepareStatement("insert into userjsp values(?,?)");
s.setString(1, uname);
s.setString(2, upass);
int i = s.executeUpdate();
s.close();
con.close();
response.sendRedirect("login_form.jsp");

%>