package ssh.jwbook.com.addressbook;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/addressBook")
public class AddressBookController extends HttpServlet { // 여기서 관리

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fPage = null;

        try {
            String action = request.getParameter("action");

            switch (action) {
                case "list" : fPage = list_all(request, response); break;
                case "del" : fPage = del(request, response); break;
                case "add" : fPage = add(request, response); break;
                case "modify" : fPage = modify(request, response); break;
                case "search" : fPage = search(request, response); break;
                case "detail" : fPage = detail(request, response); break;
            }

            getServletContext().getRequestDispatcher(fPage).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String list_all(HttpServletRequest request, HttpServletResponse response) {

        AddressBookDao addressBookDao = new AddressBookDao();
        ArrayList<AddressBookDto> list = addressBookDao.listAll();

        ServletContext app = request.getServletContext();
        app.setAttribute("list_all", list); // select로 가져온 리스트를 application 단위로 넘기기
        return"/addressbook/listView.jsp";
    }

    private String del(HttpServletRequest request, HttpServletResponse response) {

        AddressBookDao addressBookDao = new AddressBookDao();
        int rs= addressBookDao.del(request,response);

        if (rs!= 0) {
            return "/addressbook/success.jsp";
        } else {
            return "/addressbook/error.jsp";
        }
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {

        AddressBookDao addressBookDao = new AddressBookDao();
        int rs= addressBookDao.add(request,response);

        if (rs!= 0) {
            return "/addressbook/success.jsp";
        } else {
            return "/addressbook/error.jsp";
        }
    }

    private String modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddressBookDao addressBookDao = new AddressBookDao();
        int rs= addressBookDao.modify(request,response);

        if (rs!= 0) {
            return "/addressbook/home.jsp";
        } else {
            return "/addressbook/error.jsp";
        }
    }

    private String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddressBookDao addressBookDao = new AddressBookDao();
        AddressBookDto addressBookDto = addressBookDao.search(request,response);

//        if (addressBookDto != null) {
//            System.out.println("DTO Found: " + addressBookDto.getName());
//        } else {
//            System.out.println("not found");
//        }

        if (addressBookDto != null) {
            request.getRequestDispatcher("/addressbook/detail.jsp").forward(request, response);
            return null;
        } else {
            return "/addressbook/error.jsp";
        }
    }

    private String detail(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
