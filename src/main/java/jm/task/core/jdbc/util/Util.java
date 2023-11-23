package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class Util { // реализуйте настройку соеденения с БД
    private static String pass = "Sql_pas_314";
    private static String user = "root";
    private static String url = "jdbc:mysql://localhost:3306/sc_userdao_1.1.4";

    public static Connection getConnection() throws SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }
}