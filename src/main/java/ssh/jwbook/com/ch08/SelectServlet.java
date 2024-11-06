package ssh.jwbook.com.ch08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/selectServlet")
public class SelectServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        // select
        PrintWriter out = response.getWriter();
        UserDao uDAO = new UserDao();
        ArrayList<UserDto> list = uDAO.select();

        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i).getName() + " -------- " + list.get(i).getEmail());
            out.println("<br>");
        }
    }
}
