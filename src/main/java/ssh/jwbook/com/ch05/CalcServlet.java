package ssh.jwbook.com.ch05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        double n1 = Double.parseDouble(request.getParameter("n1"));
        double n2 = Double.parseDouble(request.getParameter("n2"));
        String op = request.getParameter("op");

        double calc = 0.0;

        if (op.equals("+")) {
            calc = n1 + n2;
        } else if (op.equals("-")) {
            calc = n1 - n2;
        } else if (op.equals("*")) {
            calc = n1 * n2;
        } else {
            calc = n1 / n2;
        }

        PrintWriter out = response.getWriter();
        out.print("<html><head></head><body>");
        out.print("<h2>계산기 서블릿</h2><hr>");
        out.print("계산 결과 : " + calc);
        out.print("</body></html>");
    }
}
