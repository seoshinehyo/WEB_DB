package ssh.jwbook.com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "prtInfoServlet", urlPatterns = "/prtInfoServlet")
public class PrtInfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String gender = request.getParameter("gender");

        PrintWriter out = response.getWriter();
        out.write("<html><title></title><body>");

        out.write("이름 : " + name + "<br>");
        out.write("성별 : " + gender);

        out.write("</body></html>");
    }
}
