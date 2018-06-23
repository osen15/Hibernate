package hibernate.lesson4.dao;

import hibernate.lesson4.entities.Hotel;

import java.util.HashMap;
import java.util.List;

public class HotelDAO extends GeneralDAO<Hotel> {
    private String FIND_BY_NAME = "from Hotel where name = :name";
    private String FIND_BY_CITY = "from Hotel where city = :city";


    public void save(Hotel hotel) {
        save(hotel);
    }

    public void delete(long id) {
        delete("Hotel", id);
    }


    public void update(Hotel hotel) {
        update(hotel);
    }

    public void findById(long id) {
        findById("Hotel", id);
    }


    public List findHotelByName(String name) {
        HashMap<String, Object> putResults = new HashMap<>();
        putResults.put("name", name);
        return setParameter(FIND_BY_NAME, putResults);
    }

    public List findHotelByCity(String city) {
        HashMap<String, Object> putResults = new HashMap<>();
        putResults.put("city", city);
        return setParameter(FIND_BY_NAME, putResults);
    }


}
