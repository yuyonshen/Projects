package dao;

import domain.User;
import util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    Connection c=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    public User login(User users) {
        List<User> list = new ArrayList<User>();
        User u = null;
        try {
            c = DBUtil.getConnection();

            String sql = "select * from user where username = ? and password = ?";

            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPassword());
             u = new User();
            while (rs.next()) {
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}
