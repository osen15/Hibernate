package hibernate.lesson4.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate.lesson4.entities.Filter;
import hibernate.lesson4.entities.Hotel;
import hibernate.lesson4.entities.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDAO extends GeneralDAO<Room> {
    private static Map<String, Object> parameters = new HashMap<>();
    private static StringBuffer queryBuf = new StringBuffer("from Room as r join r.hotel as h ");
    private static boolean firstPosition = true;


    public void delete(long id) {
        new GeneralDAO<Room>().delete("Room", id);
    }

    public void update(Room room) {
        new GeneralDAO<Room>().update(room);
    }

    public Room findById(long id) {
        return new GeneralDAO<Room>().findById("Room", id);

    }


    // Bad example
   /* public List roomFilter(Filter filter) {

        if (filter.getNumberOfGuests() > 0) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("r.numberOfGuests = :numberOfGuests");
            parameters.put("numberOfGuests", filter.getNumberOfGuests());
            firstPosition = false;
        }
        if (filter.getPrice() > 0) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("r.price = :price");
            parameters.put("price", filter.getPrice());
            firstPosition = false;
        }
        if (filter.getBreakfastIncluded() == 1) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("r.breakfastIncluded = :breakfastIncluded");
            parameters.put("breakfastIncluded", filter.getBreakfastIncluded());
            firstPosition = false;
        }
        if (filter.getPetsAllowed() == 1) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("r.petsAllowed = :petsAllowed");
            parameters.put("petsAllowed", filter.getPetsAllowed());
            firstPosition = false;
        }
        if (filter.getDateAvailableFrom() != null) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("r.dateAvailableFrom = :dateAvailableFrom");
            parameters.put("dateAvailableFrom", filter.getDateAvailableFrom());
            firstPosition = false;
        }
        if (filter.getName() != null) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("h.name = :name");
            parameters.put("name", filter.getName());
            firstPosition = false;
        }

        if (filter.getCountry() != null) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("h.country = :country");
            parameters.put("country", filter.getCountry());
            firstPosition = false;
        }
        if (filter.getCity() != null) {
            queryBuf.append(firstPosition ? " where " : " and ");
            queryBuf.append("h.city = :city");
            parameters.put("city", filter.getCity());
            firstPosition = false;
        }

        System.out.println(queryBuf.toString());


        try (Session session = new GeneralDAO().createSessionFactory().openSession()) {
            String hqlQuery = queryBuf.toString();
            Query query = session.createQuery(hqlQuery);

            iterationParateters(parameters, query);

            return query.getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        return null;
    }


    private void iterationParateters(Map<String, Object> parameters, Query query) {
        for (Object o : parameters.keySet()) {
            String name = (String) o;
            Object value = parameters.get(name);
            query.setParameter(name, value);
        }


    } */

    public List<Room> roomFilter(Filter filter) {
        List<Room> rooms = null;
        try (Session session = createSessionFactory().openSession()) {
            ObjectMapper om = new ObjectMapper();
            Map<String, Object> filterParameters = om.convertValue(filter, Map.class);
            System.out.println(filterParameters);
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Room> cq = cb.createQuery(Room.class);

            Root<Room> root = cq.from(Room.class);


            Join<Hotel, Room> roomInHotel = root.join("hotel");

            Predicate predicate = cb.conjunction();

            for (String param : filterParameters.keySet()) {
                if (filterParameters.get(param) != null) {

                    if (param.equals("name") || param.equals("country") || param.equals("city")) {
                        predicate = cb.and(predicate, cb.equal(
                                roomInHotel.get(param), filterParameters.get(param)));
                    } else {

                        predicate = cb.and(predicate, cb.equal(
                                root.get(param), filterParameters.get(param)));
                    }
                }
            }
            cq.select(root).where(predicate);


            rooms = session.createQuery(cq).getResultList();
            System.out.println(rooms);

        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Smth went wrong");
        }

        return rooms;
    }

}

