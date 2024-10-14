package ssh.jwbook.com.ch05.ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nPageServlet")
public class NPageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("name");

        Cookie cookie = new Cookie("id", id);
        cookie.setMaxAge(60);
        response.addCookie(cookie);

        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        Integer count = (Integer) (session.getAttribute("count"));

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);

        out.print("로그인 성공<br>" + count + "번째 방문입니다.<br><br>" + session.getAttribute("name") + "님 환영합니다.");
    }
}
