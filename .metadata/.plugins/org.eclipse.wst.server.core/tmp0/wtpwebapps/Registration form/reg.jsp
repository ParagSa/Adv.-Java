<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<jsp:useBean id="user" class="modal.user" scope="session"></jsp:useBean>


<jsp:setProperty  name="user" param="User_Name" property="userName"/>

<jsp:setProperty  name="user" param="User_pass" property="userPass"/>

<jsp:setProperty  name="user" param="User_Email" property="userEmail"/>
<%

String uname = request.getParameter("User_Name");
String upass = request.getParameter("User_pass");
String uemail = request.getParameter("User_Email");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thane?useSSL=false","parag",
	"parag123");
PreparedStatement s = con.prepareStatement("insert into web_reg(name,password,email) values(?,?,?)");
s.setString(1, uname);
s.setString(2, upass);
s.setString(3, uemail);
int i = s.executeUpdate();
s.close();
con.close();

response.sendRedirect("info_jsp.jsp");

%>