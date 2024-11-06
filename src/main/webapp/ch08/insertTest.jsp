<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: 82105
  Date: 2024-11-06
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert test</title>
</head>
<body>
<%
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    try {
        con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_test", "root", "ssh159357!");
    } catch (SQLException e) {
        e.printStackTrace();
    }

    try {
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO user (name,email) VALUES(?,?)");
        pstmt.setString(1, request.getParameter("name"));
        pstmt.setString(2, request.getParameter("email"));
        int res = pstmt.executeUpdate();
        if (res == 1)
            System.out.println("success");
        if (pstmt != null)
            con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
</body>
</html>