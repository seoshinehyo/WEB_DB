package ssh.jwbook.com.ch08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        // insert
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        UserDao uDAO = new UserDao();
        UserDto uDTO = new UserDto();
        uDTO.setName(name);
        uDTO.setEmail(email);

        int result = uDAO.insert(uDTO);

        if (result > 0) {
            out.println("<p>회원 정보가 성공적으로 저장되었습니다.</p>");
        } else {
            out.println("<p>회원 정보 저장에 실패했습니다.</p>");
        }

    }
}
