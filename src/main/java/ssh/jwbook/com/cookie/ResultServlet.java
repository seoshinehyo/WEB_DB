package ssh.jwbook.com.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "resultServlet", urlPatterns = "/resultServlet")
public class ResultServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("name");

        Cookie cookie1 = new Cookie("id", id);
        response.addCookie(cookie1);


        HttpSession session = request.getSession();

        session.setAttribute("name", name);


        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("count", count);



        out.write("<html><title></title><body>");
        out.write("로그인 성공<br>");
        out.write(count + "번째 방문입니다<br><br>");
        out.write(session.getAttribute("name") +"님 환영합니다.");
        out.write("</body></html>");
    }
}
