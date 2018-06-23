package hibernate.lesson4.entities;

import java.util.Date;

public class Filter {

    private Integer numberOfGuests;
    private Double price;
    private Integer breakfastIncluded;
    private Integer petsAllowed;
    private Date dateAvailableFrom;
    private String name;
    private String country;
    private String city;


    public Filter() {
    }

    public Filter(String name) {
        this.name = name;
    }

    public Filter(int numberOfGuests, double price, int breakfastIncluded, int petsAllowed,
                  Date dateAvailableFrom, String name, String country, String city) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.name = name;
        this.country = country;
        this.city = city;
    }


    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(Integer breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public Integer getPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(Integer petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}