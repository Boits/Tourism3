import city.service.CityService;
import city.domain.City;
import city.search.CitySearchCondition;
import common.business.application.StorageType;
import common.business.application.servicefactory.ServiceSupplier;
import country.domain.Country;
import country.service.CountryService;
import order.domain.Order;
import order.service.OrderService;
import user.domain.User;
import user.service.UserService;

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
        String[] usersAsCsv = new String[]{
                "Chandler    | Bing      | 1111",
                "Joey        | Tribbiani | 2222",
                "Ross        | Geller    | 3333",};
        for (String csvUser : usersAsCsv) {
            String[] users = csvUser.split("\\|");

            int index = -1;
            userService.add(new User(users[++index].trim(), users[++index].trim(), Integer.parseInt(users[++index].trim())));
        }
    }

    private static void addCities0(String cityCsv, String[] countriesCsv) {

        String[] attrs = cityCsv.split("\\|");
        int attrIndex = -1;

        City city = new City(attrs[++attrIndex].trim(), attrs[++attrIndex].trim());
        city.setCountries(new Country[countriesCsv.length]);

        for (int i = 0; i < countriesCsv.length; i++) {
            String csvCounty = countriesCsv[i];
            attrIndex = -1;
            attrs = csvCounty.split("\\|");

            Country country = new Country();
            country.setName(attrs[++attrIndex].trim());

            city.getCountries()[i] = country;
        }

        cityService.add(city);
    }

    private static void addCities() {

        String[] cityCountryCsv = new String[]{
                "Spb   | Russia",
                "Msc   | Russia",
                "NY    | USA   ",};

        for (String csvUser : cityCountryCsv) {
            String[] cities = csvUser.split("\\|");

            int index = -1;
            City city = new City(cities[++index].trim(), cities[++index].trim());
            cityService.add(city);
        }
    }

    private static void addCountries() {

        String[] cityCountryCsv = new String[]{
                "Russia     | RU",
                "USA        | EN",
                "Germany    | DE",};

        for (String csvUser : cityCountryCsv) {
            String[] countries = csvUser.split("\\|");

            int index = -1;
            Country country = new Country(countries[++index].trim(), countries[++index].trim());
            countryService.add(country);
        }
    }

    public static void fillStorage() {
        addUsers();
        addCities();
        addCountries();

        System.out.println("+++++++++++++++");

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

        System.out.println("----------Search cities by country and countries name------------");
        CitySearchCondition citySearchCondition = new CitySearchCondition();
        citySearchCondition.setCountry("Russia");
        citySearchCondition.setName("Ural");
        List<City> searchResult = cityService.search(citySearchCondition);

        System.out.println("----------Search result----------------------");
        for (City city : searchResult) {
            System.out.println(city);
        }

        userService.add(new User("Monica", "Geller", 4444));
        userService.deleteById(33L);
    }

    public static void deleteCities() {
        cityService.deleteById(1L);
        cityService.deleteById(33L);
    }

    public static void deleteCountries() {
        cityService.deleteById(1L);
        cityService.deleteById(33L);
    }

    public static void deleteOrders() {
        orderService.deleteById(1L);
        //
    }


    public static void main(String[] args) {

//        Country country1 = new Country("Russia", "RU");
//        Country country2 = new Country("USA", "EN");
//
//        City city1 = new City("Saint-Petersburg", 5, false);
//        City city2 = new City("Moscow", 12, true);
//        City city3 = new City("San Francisco", 0.8, false);
//
//        Order order1 = new Order(user1, country1, city1);
//        Order order2 = new Order(user2, country1, city2);
//        Order order3 = new Order(user3, country2, city3);

        fillStorage();

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

        deleteUsers();
        deleteCities();
        deleteCountries();
        System.out.println();

        System.out.println("=======================");

        System.out.println("----------Users------------");
        printUsers();

        System.out.println("----------Cities------------");
        printCities();

        System.out.println("----------Countries------------");
        printCountries();

    }
}