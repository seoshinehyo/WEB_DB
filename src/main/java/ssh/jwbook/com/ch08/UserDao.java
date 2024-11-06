package ssh.jwbook.com.ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/jdbc_test";
    String id = "root";
    String pw = "ssh159357!";
    public UserDao() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserDto> select(){
        ArrayList<UserDto> list = new ArrayList<UserDto>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "SELECT * FROM user";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String email = rs.getString("email");
                UserDto uDTO = new UserDto(num, name, email);
                list.add(uDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null)
                    if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }

    public int insert(UserDto uDTO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int res =0;
        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "INSERT INTO user (`name`, `email`) VALUES (?, ?);";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uDTO.getName());
            pstmt.setString(2, uDTO.getEmail());
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

    public int delete(UserDto uDTO) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int res = 0;
        try {
            con = DriverManager.getConnection(url, id, pw);
            String sql = "DELETE FROM user WHERE num = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, uDTO.getNum());
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

}
