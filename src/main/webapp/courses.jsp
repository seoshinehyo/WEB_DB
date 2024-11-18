<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>정보 확인</title>
</head>
<body>
<h1>정보 확인</h1>
<br><br>
<%--<p>이름 : <%= request.getParameter("name") %></p>--%>
<%--<p>별명 : <%= request.getParameter("nickname") %></p>--%>
<%--<p>학년 : <%= request.getParameter("grade") %>학년</p>--%>
<%--<p>성별 : <%= request.getParameter("gender") %></p>--%>

<%--<%String[] courses = request.getParameterValues("courses");%>--%>

<%--<p>수강 과목 :--%>
<%--  <%--%>
<%--    if (courses != null && courses.length > 0) {--%>
<%--      for (String course : courses) {--%>
<%--        out.print(course + " ");--%>
<%--      }--%>
<%--    } else {--%>
<%--      out.print("선택한 과목이 없습니다.");--%>
<%--    }--%>
<%--  %>--%>
<%--</p>--%>

<%
  String name = request.getParameter("name");
  String nickname = request.getParameter("nickname");
  String grade = request.getParameter("grade");
  String gender = request.getParameter("gender");
  String[] courses = request.getParameterValues("courses");
%>

<p>이름 : <%=name%></p>
<p>닉네임 : <%=nickname%></p>
<p>학년 : <%=grade%></p>
<p>성별 : <%=gender%></p>
<p>수강 과목 : <%=String.join(", ", courses)%></p>
</body>
</html>







































<%--<%--%>
<%--  String name = request.getParameter("name");--%>
<%--  String nickname = request.getParameter("nickname");--%>
<%--  String grade = request.getParameter("grade");--%>
<%--  String gender = request.getParameter("gender");--%>
<%--  String[] courses = request.getParameterValues("courses");--%>
<%--%>--%>

<%--<p>이름 : <%= name != null ? name : "정보 없음" %></p>--%>
<%--<p>별명 : <%= nickname != null ? nickname : "정보 없음" %></p>--%>
<%--<p>학년 : <%= grade != null ? grade + " 학년" : "정보 없음" %></p>--%>
<%--<p>성별 : <%= gender != null ? gender : "정보 없음" %></p>--%>