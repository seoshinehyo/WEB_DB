<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-06
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DB 연결 테스트</title>
</head>
<body>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con= DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/jdbc_test",
            "root", "ssh159357!");
    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM User");

    ResultSet rs = pstmt.executeQuery();

    String str = "";
    while(rs.next()) {
        str += rs.getString("name") + " " + rs.getString("email") + "<br>";
    }
    out.print(str);
    rs.close(); pstmt.close(); con.close();
%>
</body>
</html>
