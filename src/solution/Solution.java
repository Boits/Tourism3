package solution;

import city.City;
import country.Country;
import order.Order;
import storage.Storage;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();
        List<Country> countryList = new ArrayList<>();
        List<City> cityList = new ArrayList<>();
        //List<Order> orderList = new ArrayList<>();

        Storage storage = new Storage(userList,countryList,cityList);

        User user1 = new User("Chandler", "Bing", 1111);
        User user2 = new User("Joey", "Tribbiani", 2222);
        User user3 = new User("Ross", "Geller", 3333);

        Country country1 = new Country("Russia", "RU");
        Country country2 = new Country("USA", "EN");

        City city1 = new City("Saint-Petersburg", 5, false);
        City city2 = new City("Moscow", 12, true);
        City city3 = new City("San Francisco", 0.8, false);

        Order order1 = new Order(user1, country1, city1);
        System.out.println(order1);

        Order order2 = new Order(user2, country1, city2);
        System.out.println(order2);

        Order order3 = new Order(user3, country2, city3);
        System.out.println(order3);

    }
}