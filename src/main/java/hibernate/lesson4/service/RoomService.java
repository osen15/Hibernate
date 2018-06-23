package hibernate.lesson4.service;

import hibernate.lesson4.dao.RoomDAO;
import hibernate.lesson4.entities.Filter;
import hibernate.lesson4.entities.Room;

import java.util.List;

public class RoomService {

    public void save(Room room){
        new RoomDAO().save(room);
    }


    public List findRooms(Filter filter) {
        return new RoomDAO().roomFilter(filter);
    }
}
