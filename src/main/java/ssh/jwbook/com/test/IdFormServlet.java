package ssh.jwbook.com.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "/idFormServlet", urlPatterns = "/idFormServlet")
public class IdFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        String name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("id"));
        String gender;

        if (id / 1_000_000 == 1 || id / 1_000_000 == 3) {
            gender = "male";
        } else if (id / 1_000_000 == 2 || id / 1_000_000 == 4) {
            gender = "female";
        } else {
            gender = "error";
        }

        request.setAttribute("name", name);
        request.setAttribute("gender", gender);

        String viewPath = "WEB-INF/prtInfo.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

//        response.sendRedirect("/prtInfoServlet?name=" + name + "&gender=" + gender);
    }
}
