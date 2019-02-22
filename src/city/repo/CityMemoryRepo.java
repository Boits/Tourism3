package city.repo;

import city.City;
import static storage.Storage.cityList;

public class CityMemoryRepo {

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

    public int sizeList() {
        return cityList.size();
    }

    public void printCities() {
        System.out.println("All cities:");
        for (City city : cityList) {
            System.out.print(city + " ");
        }
    }

}
