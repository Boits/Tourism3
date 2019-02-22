package storage;

import city.City;
import country.Country;
import order.Order;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<User> userList = new ArrayList<>();
    public static List<Country> countryList = new ArrayList<>();
    public static List<City> cityList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();
}