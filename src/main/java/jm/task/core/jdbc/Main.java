package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        logger.info("Таблица пользователей создана");

        userService.saveUser("John", "Doe", (byte) 25);
        logger.info("User с именем – John добавлен в базу данных");

        userService.saveUser("Jane", "Doe", (byte) 30);
        logger.info("User с именем – Jane добавлен в базу данных");

        userService.saveUser("Alice", "Smith", (byte) 22);
        logger.info("User с именем – Alice добавлен в базу данных");

        userService.saveUser("Bob", "Johnson", (byte) 35);
        logger.info("User с именем – Bob добавлен в базу данных");

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            logger.info("Пользователь: " + user);
        }

        userService.cleanUsersTable();
        logger.info("Таблица пользователей очищена");

        userService.dropUsersTable();
        logger.info("Таблица пользователей удалена");
    }
}
