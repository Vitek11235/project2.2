package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;
    private Statement statement;
    {
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDaoJDBCImpl() {//конструктор пустой/по умолчанию

    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users " +
                "(id int NOT NULL AUTO_INCREMENT," +
                "name varchar(45) NOT NULL," +
                "lastname varchar(45) NOT NULL," +
                "age int DEFAULT NULL," +
                "PRIMARY KEY (id))";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users;";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into users (name, lastname, age) " +
                "values('" + name + "','" + lastName + "'," + age + ");";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String query = "delete from users where id =" + id + ";";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "select * from users;";
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                byte age = rs.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(id);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

        public void cleanUsersTable() {
        String query = "truncate users;";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
