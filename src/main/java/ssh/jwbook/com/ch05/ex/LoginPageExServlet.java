package ssh.jwbook.com.ch05.ex;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginPageExServlet")
public class LoginPageExServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

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
