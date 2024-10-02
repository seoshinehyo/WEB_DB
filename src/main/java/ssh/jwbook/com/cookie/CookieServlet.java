package ssh.jwbook.com.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cookieServlet", urlPatterns = "/cookieServlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.addCookie(new Cookie("name", "kim"));

        Cookie[] cookies = request.getCookies();

        PrintWriter out = response.getWriter();

        boolean isLoggedIn = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    out.write(cookie.getValue() + " 회원님 로그인 하세요");
                    isLoggedIn = true;
                    break;
                }
            }
        }

        if (!isLoggedIn) {
            out.write("회원가입 하세요");
        }

    }
}
