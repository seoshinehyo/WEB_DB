package ssh.jwbook.com.addressbook;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AddressBookDao {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/jdbc_test";
    String id = "root";
    String pw = "ssh159357!";

    public AddressBookDao() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<AddressBookDto> listAll(){
        ArrayList<AddressBookDto> list = new ArrayList<AddressBookDto>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT * FROM addressbook";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String addr = rs.getString("addr");
                String tel = rs.getString("tel");
                AddressBookDto addrbookDTO = new AddressBookDto(num,name, email, addr, tel);
                list.add(addrbookDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }

    public int del(HttpServletRequest request, HttpServletResponse response) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int res = 0;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String name = request.getParameter("name");
            String sql = "DELETE FROM addressbook WHERE (name = ?);";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }


    public int add(HttpServletRequest request, HttpServletResponse response) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int res = 0;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String addr = request.getParameter("addr");
            String tel = request.getParameter("tel");
            String sql = "INSERT INTO addressbook (name,email,addr,tel) VALUES (?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, addr);
            pstmt.setString(4, tel);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }

    public int modify(HttpServletRequest request, HttpServletResponse response) {

        Connection con = null;
        PreparedStatement pstmt = null;
        int res = 0;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String addr = request.getParameter("addr");
            String tel = request.getParameter("tel");
            String sql = "UPDATE addressbook SET name = ?, email = ?, addr = ?, tel = ? WHERE name = ?";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, addr);
            pstmt.setString(4, tel);
            pstmt.setString(5, name);
            res = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return res;
    }

    public AddressBookDto search(HttpServletRequest request, HttpServletResponse response) {

        AddressBookDto addressBookDto = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(url, id, pw);
            String name = request.getParameter("name");
            String sql = "SELECT * FROM addressbook WHERE name = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();

            if (rs.next()) { // 결과가 있을 때만 데이터 가져오기
                int num = rs.getInt("num");
                String email = rs.getString("email");
                String addr = rs.getString("addr");
                String tel = rs.getString("tel");
                addressBookDto = new AddressBookDto(num, name, email, addr, tel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return addressBookDto;
    }

}
