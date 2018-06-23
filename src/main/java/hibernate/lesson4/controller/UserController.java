package hibernate.lesson4.controller;

import hibernate.lesson4.entities.User;
import hibernate.lesson4.service.UserService;

public class UserController {
    public  void userRegister(User user) {
       new  UserService().registerUser(user);
    }

    public static void login(String name, String password) throws Exception {
       new  UserService().login(name, password);
    }

    public static void logout() {
        UserService.logout();
    }
}
