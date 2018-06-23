package hibernate.lesson4.service;

import hibernate.lesson4.dao.UserDAO;
import hibernate.lesson4.entities.User;

public class UserService {
    private static boolean online;


    public void registerUser(User user) throws NullPointerException {
        if (user == null)
            throw new NullPointerException("user is null");
        new UserDAO().save(user);


    }


    public void login(String name, String password) throws Exception {
        if (isOnline()) {

            throw new Exception("Other user is online");
        }
        User user = (User) new UserDAO().nameAndPass(name, password).get(0);
        setOnline(true);
        System.out.println(user.toString() + ": is login and " + online);

    }


    public static void logout() {
        UserService.setOnline(false);
    }


    private static boolean isOnline() {
        return online = false;
    }


    private static void setOnline(boolean online) {
        UserService.online = online;
    }


}
