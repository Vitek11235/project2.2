package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        for (int i = 1; i < 5; i++) {
            String name = "Name" + i;
            userDao.saveUser(name, "LastName" + i, (byte) (20 + i));
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        }
        userDao.removeUserById(1);
        System.out.println(Arrays.toString(userDao.getAllUsers().toArray()));
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
