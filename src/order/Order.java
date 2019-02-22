package order;

import city.City;
import country.Country;
import user.User;

public class Order {
    private Integer numberOrder;
    private User user;
    private int price;
    private Country country;
    private City city;

    public Order(User user, Country country, City city) {
        this.user = user;
        this.country = country;
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public int getPrice() {
        return price();
    }

    public Country getCountry() {
        return country;
    }

    public City getCity() {
        return city;
    }

    public int price() {
        price = 500;

        if (city.isCapital()) {
            price = price + 100;
        }
        if (city.getPopulation() > 4) {
            price = price + 150;
        }
        return price;
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    @Override
    public String toString() {
        return "User: " + user.getLastName() + ". Price: " + getPrice() + ". Country: " + country.getLocation() + ". City: " + city.getNameCity();
    }

}
