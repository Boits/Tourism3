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

public class DemoDraft {
    /*
    static {
        ServiceSupplier.newInstance(StorageType.MEMORY_COLLECTION);
    }

    private static UserService userService = ServiceSupplier.getInstance().getUserService();
    private static OrderService orderService = ServiceSupplier.getInstance().getOrderService();
    private static CountryService countryService = ServiceSupplier.getInstance().getCountryService();
    private static CityService cityService = ServiceSupplier.getInstance().getCityService();

    private static void addUsers() {
        userService.add(new User("NameA", "LastNameA", 1111));
        userService.add(new User("NameC", "LastNameC", 3333));
        userService.add(new User("NameB", "LastNameB", 2222));
        userService.add(new User("NameF", "LastNameF", 5555));
        userService.add(new User("NameE", "LastNameE", 4444));
        userService.add(new User("NameG", "LastNameG", 6666));
    }

    private static void addCities() {
        cityService.add(new City("Moscow", 12, true));
        cityService.add(new City("Saint-Petersburg", 5, false));
        cityService.add(new City("San Francisco", 0.8, false));
        cityService.add(new City("Paris", 2.2, true));
        cityService.add(new City("London", 8.1, true));
        cityService.add(new City("Dresden", 0.5, false));
    }

    private static void addCountries() {
        countryService.add(new Country("Russia", "RU"));
        countryService.add(new Country("USA", "EN"));
        countryService.add(new Country("Germany", "GE"));
        countryService.add(new Country("Armenia", "HY"));
        countryService.add(new Country("Belgium", "NL"));
        countryService.add(new Country("France", "FR"));
    }

    private static void addOrders() {
//        List<Country> list = new ArrayList<>();
//        list.add(new Country("RussiaA", "RU"));
//        list.add(new Country("RussiaT", "RU"));
//        list.add(new Country("RussiaM", "RU"));
//
//        orderService.add(new Order(new User("Name6", "LastName6", 6666), 500, list));


        orderService.add(new Order(new User("NameA", "LastNameA", 1111),
                new Country("Russia", "RU"),
                new City("Saint-Petersburg", 5, false),
                5000));

        orderService.add(new Order(new User("NameC", "LastNameC", 3333),
                new Country("USA", "EN"),
                new City("San Francisco", 0.8, false),
                10000));

        orderService.add(new Order(new User("NameF", "LastNameF", 5555),
                new Country("France", "FR"),
                new City("Paris", 2.2, true),
                4000));


    }

    public static void fillStorage() {
        addUsers();
        addCities();
        addCountries();
        addOrders();
    }

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

    public static void deleteUsersById() {

        userService.deleteById(1L);

        System.out.println("----------Search country by countryName and language ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
//        countrySearchCondition.setName("Russia");
//        countrySearchCondition.setLanguage("RU");

        countrySearchCondition.setName("Germany");
        countrySearchCondition.setLanguage("GE");
        List<Country> searchResult = countryService.search(countrySearchCondition);

        for (Country country : searchResult) {
            System.out.println(country);
        }

        userService.add(new User("Monica", "Geller", 1234));
        userService.deleteById(33L);
    }

    public static void deleteCitiesById() {
        cityService.deleteById(6L);
        cityService.deleteById(33L);
    }

    public static void deleteCountriesById() {
        cityService.deleteById(9L);
        cityService.deleteById(33L);
    }

    public static void deleteOrdersById() {
        orderService.deleteById(1L);

    }


    public static void searchCountriesWithoutOrder() {
        System.out.println("\n----------Search countries No order ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country);
        }
    }

    public static void searchCountriesWithOrderAsc() {
        System.out.println("\n----------Search countries Order ASC ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.ASC);
        countrySearchCondition.setOrderByField(CounrtryOrderByField.NAME);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country);
        }
    }

    public static void searchCountriesWithOrderDesc() {
        System.out.println("\n----------Search countries Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.DESC);
        countrySearchCondition.setOrderByField(CounrtryOrderByField.NAME);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country);
        }
    }

    public static void searchCountriesWithComplexOrderAsc() {
        System.out.println("\n----------Search countries COMPLEX Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.ASC);
        countrySearchCondition.setOrderByField(CounrtryOrderByField.NAME);
        countrySearchCondition.setOrderType(OrderType.COMPLEX);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country);
        }
    }

    public static void searchCountriesWithComplexOrderDesc() {
        System.out.println("\n----------Search countries COMPLEX Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.DESC);
        countrySearchCondition.setOrderByField(CounrtryOrderByField.NAME);
        countrySearchCondition.setOrderType(OrderType.COMPLEX);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country);
        }
    }


    public static void deleteUsers() {
        userService.deleteById(1L);
    }

    public static void deleteCities() {
        System.out.println("===============================================");
        City city1 = new City("Viborg", 44, false);
        cityService.add(city1);
        Order order1 = new Order(new User("NameN", "LastNameM", 5555),
                new Country("Russia", "RU"),
                city1,
                1000);
        orderService.add(order1);

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        System.out.println("----------Orders------------");
        printOrders();

        System.out.println("===============================================");
        cityService.delete(city1);

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        System.out.println("----------Orders------------");
        printOrders();

//        cityService.deleteById(6L);
//        cityService.deleteById(33L);
    }

    public static void deleteCountries() {
        cityService.deleteById(9L);
        cityService.deleteById(33L);
    }

    public static void deleteOrders() {
        orderService.deleteById(1L);

    }

    public static void mainDraft() {

        fillStorage();

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        System.out.println("----------Orders------------");
        printOrders();

        deleteUsersById();
        deleteCitiesById();
        deleteCountriesById();
        System.out.println();

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        searchCountriesWithoutOrder();
        searchCountriesWithOrderAsc();
        searchCountriesWithOrderDesc();
        searchCountriesWithComplexOrderAsc();
        searchCountriesWithComplexOrderDesc();

        System.out.println("+++++++++++ Delete cities +++++++++++++++++++++");
        //deleteCities();

    }
    */
}