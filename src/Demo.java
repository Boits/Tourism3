import city.service.CityService;
import city.domain.City;
import common.business.application.StorageType;
import common.business.application.servicefactory.ServiceSupplier;
import common.business.search.OrderDirection;
import common.business.search.OrderType;
import country.domain.Country;
import country.domain.Discriminator;
import country.search.CounrtryOrderByField;
import country.search.CountrySearchCondition;
import country.service.CountryService;
import order.domain.Order;
import order.service.OrderService;
import user.domain.User;
import user.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    static {
        ServiceSupplier.newInstance(StorageType.MEMORY_COLLECTION);
    }

    private static UserService userService = ServiceSupplier.getInstance().getUserService();
    private static OrderService orderService = ServiceSupplier.getInstance().getOrderService();
    private static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    private static CityService cityService = ServiceSupplier.getInstance().getCityService();

    public static void printUsers() {
        userService.printAll();
    }

    public static void printCities() {
        cityService.printAll();
    }

    public static void printCountries() {
        countryService.printAll();
    }

    public static void printOrders() {
        orderService.printAll();
    }

    public static void showAll() {
        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        System.out.println("----------Orders------------");
        printOrders();
    }

    public static void main(String[] args) {

        City city1 = new City("Moscow", 12, true);
        City city2 = new City("Saint-Petersburg", 5, false);
        City city3 = new City("San Francisco", 0.8, false);
        City city4 = new City("Dresden", 0.5, false);
        City city5 = new City("Berlin", 3.5, true);
        City city6 = new City("Paris", 2.2, true);

        Country country1 = new Country("Russia", "RU");
        List<City> cityListForCountry1 = new ArrayList<>();
        cityListForCountry1.add(city1);
        cityListForCountry1.add(city2);
        country1.setCities(cityListForCountry1);
        countryService.add(country1);


        Country country2 = new Country("USA", "EN");
        List<City> cityList2 = new ArrayList<>();
        cityList2.add(city3);
        country2.setCities(cityList2);
        countryService.add(country2);

        Country country3 = new Country("Germany", "GE");
        List<City> cityList3 = new ArrayList<>();
        cityList3.add(city4);
        cityList3.add(city5);
        country3.setCities(cityList3);
        countryService.add(country3);


        Country country4 = new Country("France", "FR");
        List<City> cityList4 = new ArrayList<>();
        cityList4.add(city6);
        country4.setCities(cityList4);
        countryService.add(country4);

        //countryService.add(new Country("Armenia", "HY"));
        //countryService.add(new Country("Belgium", "NL"));

        //cityService.add(new City("London", 8.1, true));

        User user1 = new User("Name1", "LastName1", 1111);
        User user2 = new User("Name2", "LastName2", 3333);
        User user3 = new User("Name3", "LastName3", 2222);
        User user4 = new User("Name4", "LastName4", 5555);
        User user5 = new User("Name5", "LastName5", 4444);
        User user6 = new User("Name6", "LastName6", 6666);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);
        userService.add(user6);


        Order order1 = new Order(user1, country1, city2, 5000);
        Order order2 = new Order(user2, country2, city3, 10000);
        Order order3 = new Order(user4, country4, city6, 4000);
        Order order4 = new Order(user2, country3, city4, 10000);
        Order order5 = new Order(user6, country4, city6, 4000);
        Order order6 = new Order(user4, country1, city2, 5000);
        orderService.add(order1);
        orderService.add(order2);
        orderService.add(order3);
        orderService.add(order4);
        orderService.add(order5);
        orderService.add(order6);

        List<Order> orderListForUser1 = new ArrayList<>();
        orderListForUser1.add(order1);
        user1.setOrders(orderListForUser1);

        List<Order> orderListForUser2 = new ArrayList<>();
        orderListForUser2.add(order2);
        orderListForUser2.add(order4);
        user2.setOrders(orderListForUser2);

        List<Order> orderListForUser4 = new ArrayList<>();
        orderListForUser4.add(order3);
        orderListForUser4.add(order6);
        user4.setOrders(orderListForUser4);

        List<Order> orderListForUser6 = new ArrayList<>();
        orderListForUser6.add(order5);
        user6.setOrders(orderListForUser6);

        showAll();

//        System.out.println("============== Delete orders ======================");
//        orderService.delete(order1);
//
//        System.out.println("============== Delete users ======================");
//        userService.delete(user2);
//        userService.delete(user3); // throw UserHasNoOrdersException
//
//        System.out.println("============== Delete cities ======================");
//        cityService.delete(city1);
//        cityService.delete(city6);
//        System.out.println("============== Delete countries ======================");
//        countryService.delete(country1);
//        countryService.delete(country4);
//        showAll();
        
    }
}