package hello.toby.user.dao;

import hello.toby.user.dao.connect.ConnectionMaker;
import hello.toby.user.dao.connect.DConnectionMaker;

import java.sql.*;

public class UserDao {

    private ConnectionMaker simpleConnectionMaker;

    public UserDao() {
        simpleConnectionMaker = new DConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection conn = simpleConnectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection conn = simpleConnectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);

        ResultSet resultSet = ps.executeQuery();

        resultSet.next();
        User user = new User();

        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        ps.close();
        conn.close();

        return user;
    }

    public void deleteAll() throws ClassNotFoundException, SQLException {
        Connection conn = simpleConnectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM users");

        ps.executeUpdate();
    }
}
