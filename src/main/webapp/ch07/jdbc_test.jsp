<%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-10-30
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jdbc_test</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
Connection con = null;
try{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/jdbc_test?serverTimezone=UTC",
"root", "ssh159357!");
response.getWriter().println("Success");
}
catch(SQLException ex){
response.getWriter().println("SQLException" + ex);
ex.printStackTrace();
}
catch(Exception ex){
response.getWriter().println("Exception:" + ex);
ex.printStackTrace();
}
%>
</body>
</html>
