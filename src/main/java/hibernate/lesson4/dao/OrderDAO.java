package hibernate.lesson4.dao;

import hibernate.lesson4.entities.Order;

import java.util.HashMap;
import java.util.List;

public class OrderDAO extends GeneralDAO<Order> {
    private static String FIND_ROOMID_AND_USER_ID_IN_ORDER = "from Order where USER_ID = :userId and ROOM_ID = :roomId";

    public void save(Order order) {
        save(order);
    }

    public void delete(long id) {
        delete("Order", id);
    }


    public void update(Order order) {
        update(order);
    }

    public Order findById(long id) {
        return findById("Order", id);
    }


    public List findRoomAndUser(long roomId, long userId) {
        HashMap<String, Object> putResults = new HashMap<>();
        putResults.put("userId", userId);
        putResults.put("roomId", roomId);
        return setParameter(FIND_ROOMID_AND_USER_ID_IN_ORDER, putResults);


    }

}
