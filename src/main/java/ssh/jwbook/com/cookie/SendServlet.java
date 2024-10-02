package ssh.jwbook.com.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sendServlet", urlPatterns = "/sendServlet")
public class SendServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Login</title>" +
                "</head>" +
                "<body>" +
                "    <form method=\"GET\" action=\"/sendServlet\">" +
                "        ID : <input type=\"text\" name=\"id\"><br>" +
                "        PW : <input type=\"text\" name=\"ps\"><br>" +
                "        <input type=\"submit\" value=\"send\">" +
                "    </form>" +
                "</body>" +
                "</html>");

        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            response.addCookie(new Cookie("name", id));
            response.sendRedirect("/welcome1Servlet");
        }
    }
}
