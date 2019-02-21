package storage.repo;

import city.City;
import country.Country;
import order.Order;
import user.User;

import java.util.ArrayList;
import java.util.List;

public class StorageMemoryRepo {

    List<User> userList;
    List<Country> countryList;
    List<City> cityList;
    List<Order> orderList;

    StorageMemoryRepo(List<User> userList, List<Country> countryList, List<City> cityList){
        this.userList = userList;
        this.countryList = countryList;
        this.cityList = cityList;
    }

    /**
     * ==================== User API ====================
     */
    public void addUser(User user) {
        userList.add(user);
    }

    public void deleteUserByEntity(User user) {
        userList.remove(user);
    }

    private void deleteUserByIndex(int index) {
        userList.remove(index);
    }

    /**
     * ==================== Country API ====================
     */
    public void addCountry(Country country) {
        countryList.add(country);
    }

    public void deleteCountryByEntity(Country country) {
        countryList.remove(country);
    }

    private void deleteCountryByIndex(int index) {
        countryList.remove(index);
    }
    /**
     * ==================== City API ====================
     */
    public void addCity(City city) {
        cityList.add(city);
    }

    public void deleteCityByEntity(City city) {
        cityList.remove(city);
    }

    private void deleteCityByIndex(int index) {
        cityList.remove(index);
    }

    /**
     * ==================== Order API ====================
     */

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void deleteOrderByEntity(Order order) {
        orderList.remove(order);
    }

    private void deleteOrderByIndex(int index) {
        orderList.remove(index);
    }

}
