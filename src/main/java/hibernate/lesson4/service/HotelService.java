package hibernate.lesson4.service;

import hibernate.lesson4.dao.HotelDAO;

public class HotelService {
    public void findHotelsByName(String name) {
        new HotelDAO().findHotelByName(name);
    }

    public static void findHotelsCity(String city) {
        new HotelDAO().findHotelByCity(city);
    }
}
