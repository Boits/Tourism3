package order.domain;

import city.domain.City;
import common.business.domain.BaseDomain;
import country.domain.Country;
import user.domain.User;

public class Order extends BaseDomain {
    private User user;
    private int price;
    private Country country;
    private City city;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    @Override
    public String toString() {
        return "User: " + user.getLastName() + ". Price: " + getPrice() + ". Country: " + country.getName() + ". City: " + city.getNameCity();
    }
}
