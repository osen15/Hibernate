package hibernate.lesson4;

import hibernate.lesson4.dao.HotelDAO;
import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.dao.UserDAO;
import hibernate.lesson4.entities.Filter;
import hibernate.lesson4.entities.Hotel;
import hibernate.lesson4.entities.Room;
import hibernate.lesson4.entities.User;
import hibernate.lesson4.service.RoomService;

import java.util.Calendar;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {


        HotelDAO hotelDAO = new HotelDAO();

        Hotel hotel = new Hotel();
        hotel.setId((long) 1);
        hotel.setCountry("test");
        hotel.setCity("tesr");
        hotel.setName("test");
        hotel.setStreet("test");
        // hotelDAO.save(hotel);

        RoomService roomService = new RoomService();
        Room room = new Room();
        room.setPrice(100.0);
        room.setBreakfastIncluded(1);
        room.setDateAvailableFrom(new Date());
        room.setHotel(hotel);
        room.setPetsAllowed(1);
        room.setNumberOfGuests(4);
       // roomService.save(room);


        UserDAO userDAO = new UserDAO();
        // System.out.println(userDAO.findNameAndPass("test", "1111").toString());


        User user = new User();

        user.setUserName("Ann3");
        user.setPassword("1111");
        user.setCountry("Ukr");
        user.setUserType(UserType.USER);
        //UserDAO.save(user);
        //System.out.println(UserDAO.findById(2));


        Filter filter = new Filter();
        filter.setName("Opera");
       // filter.setNumberOfGuests(4);
        RoomDAO roomDAO = new RoomDAO();
        System.out.println(roomDAO.roomFilter(filter));


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.YEAR, 2018);

        Date d = cal.getTime();
        // System.out.println(d);


        // OrderService.bookRoom(3,2, d);

        // UserDAO.findById(2);

        // System.out.println(OrderDAO.findRoomAndUser(3,2));

        //System.out.println(OrderDAO.findById(1));

        //OrderService.cancelReservation(3,2);


    }

}
