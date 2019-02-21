package storage;

import city.City;
import country.Country;
import order.Order;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    List<User> userList = new ArrayList<>();
    List<Country> countryList = new ArrayList<>();
    List<City> cityList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();
}