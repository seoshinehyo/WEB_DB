package ssh.jwbook.com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookie2Servlet", urlPatterns = "/cookie2Servlet")
public class Cookie2Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

//        if (request.getCookies() == null) {
//            out.write("<html><title></title><body>");
//            out.write("Welcome ");
//            out.write("<a href=\"/sendServlet\">Login</a>");
//            out.write("</body></html>");
//        }
        out.write("<html><title></title><body>");
        out.write("Welcome ");
        out.write("<a href=\"/sendServlet\">Login</a>");
        out.write("</body></html>");
    }
}
