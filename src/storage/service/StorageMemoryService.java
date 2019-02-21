package storage.service;

import city.City;
import country.Country;
import order.Order;
import storage.repo.StorageMemoryRepo;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class StorageMemoryService {
    List<User> userList;
    List<Country> countryList;
    List<City> cityList;
    List<Order> orderList;

    StorageMemoryRepo storageMemoryRepo = new StorageMemoryRepo(userList,countryList,cityList);

    public StorageMemoryService(List<User> userList, List<Country> countryList, List<City> cityList){
        this.userList = userList;
        this.countryList = countryList;
        this.cityList = cityList;
    }

    /**
     * ==================== User API ====================
     */

    public User findUserByPassport(Integer passport) {
        for (User user : userList) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public User findUserByLastName(String lastName) {
        for (User user : userList) {
            if (user.getLastName().equals(lastName)) {
                return user;
            }
        }
        return null;
    }

    private Integer findUserIndexByEntity(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(user)) {
                return i;
            }
        }
        return null;
    }


    public void deleteUserByPassport(Integer passport) {
        for (User user : userList) {
            if (user.getPassport().equals(passport)) {
                storageMemoryRepo.deleteUserByEntity(user);
            }
        }
    }

    public void printUsers() {
        System.out.println("All users:");
        for (User user : userList) {
            System.out.print(user + " ");
        }
    }

    /**
     * ==================== Country API ====================
     */

    public Country findCountryByLocation(String location) {
        for (Country country : countryList) {
            if (country.getLocation().equals(location)) {
                return country;
            }
        }
        return null;
    }

    private Integer findCountryIndexByEntity(Country country) {
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).equals(country)) {
                return i;
            }
        }
        return null;
    }


    public void deleteCountryByLocation(String location) {
        for (Country country : countryList) {
            if (country.getLocation().equals(location)) {
                storageMemoryRepo.deleteCountryByEntity(country);
            }
        }
    }

    public void printCountries() {
        System.out.println("All countries:");
        for (Country country : countryList) {
            System.out.print(country + " ");
        }
    }

    /**
     * ==================== City API ====================
     */

    public City findCityByNameCity(String nameCity) {
        for (City city : cityList) {
            if (city.getNameCity().equals(nameCity)) {
                return city;
            }
        }
        return null;
    }

    private Integer findCityIndexByEntity(City city) {
        for (int i = 0; i < cityList.size(); i++) {
            if (cityList.get(i).equals(city)) {
                return i;
            }
        }
        return null;
    }

    public void deleteCityByNameCity(String nameCity) {
        for (City city : cityList) {
            if (city.getNameCity().equals(nameCity)) {
                storageMemoryRepo.deleteCityByEntity(city);
            }
        }
    }

    public void printCities() {
        System.out.println("All cities:");
        for (City city : cityList) {
            System.out.print(city + " ");
        }
    }


    /**
     * ==================== Order API ====================
     */

    public Order findOrderByNumberOrder(Integer numberOrder) {
        for (Order order : orderList) {
            if (order.getNumberOrder().equals(numberOrder)) {
                return order;
            }
        }
        return null;
    }

    private Integer findOrderIndexByEntity(Order order) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).equals(order)) {
                return i;
            }
        }
        return null;
    }

    public void deleteOrderByNumberOrder(Integer numberOrder) {
        for (Order order : orderList) {
            if (order.getNumberOrder().equals(numberOrder)) {
                storageMemoryRepo.deleteOrderByEntity(order);
            }
        }
    }

    public void printOrders() {
        System.out.println("All orders:");
        for (Order order : orderList) {
            System.out.print(order + " ");
        }
    }

}
