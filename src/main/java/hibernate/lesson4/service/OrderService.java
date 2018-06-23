package hibernate.lesson4.service;

import hibernate.lesson4.dao.OrderDAO;
import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.dao.UserDAO;
import hibernate.lesson4.entities.Order;
import hibernate.lesson4.entities.Room;
import hibernate.lesson4.entities.User;

import java.util.Date;


public class OrderService {
    public static void bookRoom(long roomId, long userId, Date dateTo) {
        Room room = new RoomDAO().findById(roomId);

        User user = new UserDAO().findById(userId);

        Order order = new Order();
        order.setRoom(room);
        order.setUser(user);

        order.setDateFrom(room.getDateAvailableFrom());

        order.setDateTo(new Date(order.getDateFrom().getTime()
                + (dateTo.getTime() - order.getDateFrom().getTime())));

        order.setMoneyPaid(room.getPrice());

        new OrderDAO().save(order);


    }

    public void cancelReservation(long roomId, long userId) {
        OrderDAO orderDAO = new OrderDAO();
        Order order = (Order) orderDAO.findRoomAndUser(roomId, userId).get(0);
        orderDAO.delete(order.getId());

        Room room = new RoomDAO().findById(roomId);
        room.setDateAvailableFrom(new Date());
        new RoomDAO().update(room);

    }
}
