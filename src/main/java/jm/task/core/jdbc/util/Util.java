package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


public class Util { // реализуйте настройку соеденения с БД
    private static String pass = "Sql_pas_314";
    private static String user = "root";
    private static String url = "jdbc:mysql://localhost:3306/sc_userdao_1.1.4";
    private static Connection connection = null;

    public static Connection getConnection() {
//        Class.forName("com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}