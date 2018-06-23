package hibernate.lesson4.controller;

import hibernate.lesson4.service.HotelService;

public class HotelController {
    public void findHotelByName(String name) {
        new HotelService().findHotelsByName(name);
    }

    public static void findHotelByCity(String city) {
        HotelService.findHotelsCity(city);
    }
}
