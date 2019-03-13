import city.service.CityService;
import city.domain.City;
import common.business.application.StorageType;
import common.business.application.servicefactory.ServiceSupplier;
import common.business.search.OrderDirection;
import common.business.search.OrderType;
import country.domain.Country;
import country.search.CounrtyOrderByField;
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

    private static void addUsers() {
        User user1 = new User("Name1", "LastName1", 1111);
        User user6 = new User("Name6", "LastName6", 6666);

        userService.add(user1);
        userService.add(user6);
        user1.setId(120l);
        user6.setId(140l);
        userService.add(new User("Name3", "LastName3", 3333));
        userService.add(new User("Name2", "LastName2", 2222));
        userService.add(new User("Name5", "LastName5", 5555));
        userService.add(new User("Name4", "LastName4", 4444));


    }

    private static void addCities() {
        cityService.add(new City("Moscow", 12, true));
        cityService.add(new City("Saint-Petersburg", 5, false));
        cityService.add(new City("San Francisco", 0.8, false));
    }

    private static void addCountries() {
        countryService.add(new Country("Russia", "RU"));
        countryService.add(new Country("USA", "EN"));
        countryService.add(new Country("Germany", "GE"));
    }

    private static void addOrders() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("RussiaA", "RU"));
        list.add(new Country("RussiaT", "RU"));
        list.add(new Country("RussiaM", "RU"));

        orderService.add(new Order(new User("Name6", "LastName6", 6666), 500, list));
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

    public static void deleteUsers() {

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

    public static void deleteCities() {
        cityService.deleteById(6L);
        cityService.deleteById(33L);
    }

    public static void deleteCountries() {
        cityService.deleteById(9L);
        cityService.deleteById(33L);
    }

    public static void deleteOrders() {
        orderService.deleteById(1L);

    }


    public static void searchCountriesWithoutOrder() {
        System.out.println("\n----------Search countries No order ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getStr());
        }
    }

    public static void searchCountriesWithOrderAsc() {
        System.out.println("\n----------Search countries Order ASC ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.ASC);
        countrySearchCondition.setOrderByField(CounrtyOrderByField.LANGUAGE);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getStr());
        }
    }

    public static void searchCountriesWithOrderDesc() {
        System.out.println("\n----------Search countries Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.DESC);
        countrySearchCondition.setOrderByField(CounrtyOrderByField.LANGUAGE);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getStr());
        }
    }

    public static void searchCountriesWithComplexOrderAsc() {
        System.out.println("\n----------Search countries COMPLEX Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.ASC);
        countrySearchCondition.setOrderByField(CounrtyOrderByField.LANGUAGE);
        countrySearchCondition.setOrderType(OrderType.COMPLEX);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getStr());
        }
    }

    public static void searchCountriesWithComplexOrderDesc() {
        System.out.println("\n----------Search countries COMPLEX Order Desc ------------");
        CountrySearchCondition countrySearchCondition = new CountrySearchCondition();
        countrySearchCondition.setOrderDirection(OrderDirection.DESC);
        countrySearchCondition.setOrderByField(CounrtyOrderByField.LANGUAGE);
        countrySearchCondition.setOrderType(OrderType.COMPLEX);
        List<Country> searchResult = countryService.search(countrySearchCondition);
        for (Country country : searchResult) {
            System.out.println(country.getStr());
        }
    }

    public static void main(String[] args) {

        fillStorage();

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        System.out.println("----------Orders------------");
        printOrders();

//        deleteUsers();
//        deleteCities();
//        deleteCountries();
//        System.out.println();
//
//        System.out.println("----------Users------------");
//        printUsers();
//
//        System.out.println("----------Cities------------");
//        printCities();
//
//        System.out.println("----------Countries------------");
//        printCountries();

        searchCountriesWithoutOrder();
        searchCountriesWithOrderAsc();
        searchCountriesWithOrderDesc();
        searchCountriesWithComplexOrderAsc();
        searchCountriesWithComplexOrderDesc();

    }
}