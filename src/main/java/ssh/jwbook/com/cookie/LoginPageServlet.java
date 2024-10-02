package ssh.jwbook.com.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginPageServlet", urlPatterns = "/loginPageServlet")
public class LoginPageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String savedId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    savedId = cookie.getValue();
                    break;
                }
            }
        }

        out.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>Login</title>" +
                "</head>" +
                "<body>" +
                "    <form method=\"GET\" action=\"/resultServlet\">" +
                "        ID : <input type=\"text\" name=\"id\" value=\"" + (savedId != null ? savedId : "") + "\"><br>" +
                "        NAME : <input type=\"text\" name=\"name\"><br>" +
                "        <input type=\"submit\" value=\"send\">" +
                "    </form>" +
                "</body>" +
                "</html>");
    }
}
