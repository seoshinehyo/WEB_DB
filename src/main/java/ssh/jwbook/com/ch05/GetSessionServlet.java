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

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setAttribute("name", "kim");
        session.setAttribute("id", "kim_id");

        String name = session.getAttribute("name").toString();
        String id = (String) session.getAttribute("id");

        out.println("getAttribute : " + name + ",     " + id);

        Enumeration<String> en = session.getAttributeNames();
        while (en.hasMoreElements()) {
            String s_name = en.nextElement().toString();
            String value = session.getAttribute(s_name).toString();
            out.println(s_name + " : " + value);
        }


//        String name = (String) session.getAttribute("name");
//        String id = (String) session.getAttribute("id");
//
//
//        PrintWriter out = response.getWriter();
//        out.println("getAttribute : " + name + ",     " + id);
//
//        Enumeration<String> en = session.getAttributeNames();
//        while (en.hasMoreElements()) {
//            String s_name = en.nextElement().toString();
//            String value = session.getAttribute(s_name).toString();
//            out.println(s_name + " : " + value);
//        }

//        request.getHeaderNames().asIterator()
//                .forEachRemaining(headerName -> System.out.println(headerName + ": "+ request.getHeader(headerName)));

//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + request.getHeader(headerName));
//        }
    }
}
