package ssh.jwbook.com.ch05;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/getServletContext")
public class GetServletContext extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.setAttribute("name", "kim");
        session.setAttribute("id", "kim_id");

        String name = (String) session.getAttribute("name");
        String id = (String) session.getAttribute("id");

        ServletContext appication = request.getServletContext();
        appication.setAttribute("ani", "dog");
        String ani = (String) appication.getAttribute("ani");

        PrintWriter out = response.getWriter();
        out.println("getAttribute : " + name + ",     " + id);
        out.println("ani : " + ani);


        Enumeration<String> en = session.getAttributeNames();
        while (en.hasMoreElements()) {
            String s_name = en.nextElement().toString();
            String value = session.getAttribute(s_name).toString();
            out.println(s_name + " : " + value);
        }
    }
}
