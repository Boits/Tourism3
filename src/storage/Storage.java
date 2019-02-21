package storage;

import city.City;
import country.Country;
import order.Order;
import storage.repo.StorageMemoryRepo;
import storage.service.StorageMemoryService;
import user.User;

import java.util.List;

public class Storage {

    List<User> userList;
    List<Country> countryList;
    List<City> cityList;

    StorageMemoryRepo storageMemoryRepo = new StorageMemoryRepo(userList,countryList,cityList);
    StorageMemoryService storageMemoryService = new StorageMemoryService(userList,countryList,cityList);


    Storage(List<User> userList, List<Country> countryList, List<City> cityList){
        this.userList = userList;
        this.countryList = countryList;
        this.cityList = cityList;
    }

}