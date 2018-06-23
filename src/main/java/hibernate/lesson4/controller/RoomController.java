package hibernate.lesson4.controller;

import hibernate.lesson4.entities.Filter;
import hibernate.lesson4.service.RoomService;

public class RoomController {
    public static java.util.List findRooms(Filter filter) {
        return new  RoomService().findRooms(filter);
    }}
