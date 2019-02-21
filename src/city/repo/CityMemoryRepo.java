package city.repo;

import city.City;

import java.util.ArrayList;
import java.util.List;

public class CityMemoryRepo {
    List<City> cityList = new ArrayList<>();

    public void addCity(City city) {
        cityList.add(city);
    }

    public void deleteCityByEntity(City city) {
        cityList.remove(city);
    }

    public void deleteCityByIndex(int index) {
        cityList.remove(index);
    }

    public City findCityByNameCity(String nameCity) {
        for (City city : cityList) {
            if (city.getNameCity().equals(nameCity)) {
                return city;
            }
        }
        return null;
    }

    public Integer findCityIndexByEntity(City city) {
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
                deleteCityByEntity(city);
            }
        }
    }

    public void printCities() {
        System.out.println("All cities:");
        for (City city : cityList) {
            System.out.print(city + " ");
        }
    }

}
