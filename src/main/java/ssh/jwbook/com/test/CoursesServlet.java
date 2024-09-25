package ssh.jwbook.com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/coursesServlet")
public class CoursesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String nickname = request.getParameter("nickname");
        String grade = request.getParameter("grade");
        String gender = request.getParameter("gender");
        String[] courses = request.getParameterValues("courses");

        PrintWriter out = response.getWriter();

        out.write("<html><title></title><body>정보 확인<br><br>");
        out.write("이름 : " + name);
        out.write("<br>별명 : " + nickname);
        out.write("<br>학년 : " + grade + " 학년");
        out.write("<br>성별 : " + gender);
        out.write("<br>수강 과목 : ");
        if (courses != null && courses.length > 0) {
            for (String course : courses) {
                out.write(course + " ");
            }
        } else {
            out.write("선택한 과목이 없습니다.");
        }
        out.write("</body></html>");
    }
}
