package order.domain;

import common.business.domain.BaseDomain;
import country.domain.Country;
import user.domain.User;

import java.util.List;

public class Order extends BaseDomain{
    private User user;
    private double price;
    private List<Country> countries;

    public Order(){

    }

    public Order(User user, double price, List<Country> countries) {
        this.user = user;
        this.price = price;
        this.countries = countries;
    }

    public User getUser() {
        return user;
    }

    public double getPrice() {
        return price;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return id+" "+"User: " + user.getLastName() + ". Price: " + getPrice();
    }

}
