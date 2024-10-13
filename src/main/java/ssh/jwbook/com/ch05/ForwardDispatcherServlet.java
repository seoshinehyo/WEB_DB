package ssh.jwbook.com.ch05;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forwardDispatcherServlet")
public class ForwardDispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("forward");
        RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcherServlet");
        dispatcher.forward(request, response);
    }
}
