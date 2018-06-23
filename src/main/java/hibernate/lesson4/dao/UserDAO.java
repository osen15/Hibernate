package hibernate.lesson4.dao;

import hibernate.lesson4.entities.User;

import java.util.HashMap;
import java.util.List;

public class UserDAO extends GeneralDAO<User> {
    private String NAME_AND_PASSWORD = "from User where userName = :name and password = :password";

    public void save(User user) {
        save(user);
    }

    public void delete(long id) {
        delete("User", id);
    }


    public void update(User user) {
        update(user);
    }

    public User findById(long id) {

        return findById("User", id);
    }


    public List nameAndPass(String name, String password) {
        HashMap<String, Object> putResults = new HashMap<>();
        putResults.put("name", name);
        putResults.put("password", password);
        return setParameter(NAME_AND_PASSWORD, putResults);

    }
}