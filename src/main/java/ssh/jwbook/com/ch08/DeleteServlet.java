package ssh.jwbook.com.ch08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        UserDao uDAO = new UserDao();
        UserDto uDTO = new UserDto();

        // delete
        String numParam = request.getParameter("num");
        try {
            int num = Integer.parseInt(numParam);
            uDTO.setNum(num);

            int deleteResult = uDAO.delete(uDTO);

            if (deleteResult > 0) {
                out.println("<p>회원 정보가 성공적으로 삭제되었습니다.</p>");
            } else {
                out.println("<p>회원 정보 삭제에 실패했습니다.</p>");
            }
        } catch (NumberFormatException e) {
            out.println("<p>삭제할 회원 번호가 유효하지 않습니다.</p>");
        }
    }
}
