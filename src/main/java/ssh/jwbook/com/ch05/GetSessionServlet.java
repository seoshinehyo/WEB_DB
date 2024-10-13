package ssh.jwbook.com.ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/getSessionServlet")
public class GetSessionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.setAttribute("name", "kim");
        session.setAttribute("id", "kim_id");

        String name = (String) session.getAttribute("name");
        String id = (String) session.getAttribute("id");


        PrintWriter out = response.getWriter();
        out.println("getAttribute : " + name + ",     " + id);

        Enumeration<String> en = session.getAttributeNames();
        while (en.hasMoreElements()) {
            String s_name = en.nextElement().toString();
            String value = session.getAttribute(s_name).toString();
            out.println(s_name + " : " + value);
        }
    }
}
