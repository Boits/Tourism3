package solution;

import city.City;
import city.service.CityMemoryService;
import country.Country;
import country.service.CountryMemoryService;
import order.Order;
import order.service.OrderMemoryService;
import storage.Storage;
import user.User;
import user.service.UserMemoryService;

public class Solution {
    public static void main(String[] args) {

        UserMemoryService userService = new UserMemoryService();
        CountryMemoryService countryService = new CountryMemoryService();
        CityMemoryService cityService = new CityMemoryService();
        OrderMemoryService orderService = new OrderMemoryService();

        //Storage storage = new Storage();

        User user1 = new User("Chandler", "Bing", 1111);
        userService.addUser(user1);
        User user2 = new User("Joey", "Tribbiani", 2222);
        userService.addUser(user2);
        User user3 = new User("Ross", "Geller", 3333);
        userService.addUser(user3);

        Country country1 = new Country("Russia", "RU");
        countryService.addCountry(country1);
        Country country2 = new Country("USA", "EN");
        countryService.addCountry(country2);

        City city1 = new City("Saint-Petersburg", 5, false);
        cityService.addCity(city1);
        City city2 = new City("Moscow", 12, true);
        cityService.addCity(city2);
        City city3 = new City("San Francisco", 0.8, false);
        cityService.addCity(city3);

        Order order1 = new Order(user1, country1, city1);
        orderService.addOrder(order1);
        Order order2 = new Order(user2, country1, city2);
        orderService.addOrder(order2);
        Order order3 = new Order(user3, country2, city3);
        orderService.addOrder(order3);

        userService.printUsers();
        System.out.println();

        orderService.printOrders();
    }
}