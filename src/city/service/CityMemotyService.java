package city.service;


import city.City;
import city.repo.CityMemoryRepo;

public class CityMemotyService {
    CityMemoryRepo cityMemoryRepo = new CityMemoryRepo();

    public void addCity(City city) {
        cityMemoryRepo.addCity(city);
    }

    public void deleteCityByEntity(City city) {
        cityMemoryRepo.deleteCityByEntity(city);
    }

    public void deleteCityByIndex(int index) {
        cityMemoryRepo.deleteCityByIndex(index);
    }

    public void deleteCityByNameCity(String nameCity) {
        cityMemoryRepo.deleteCityByNameCity(nameCity);
    }

    public City findCityByNameCity(String nameCity) {
        return cityMemoryRepo.findCityByNameCity(nameCity);
    }

    public Integer findCityIndexByEntity(City city) {
        return cityMemoryRepo.findCityIndexByEntity(city);
    }

    public void printCities() {
        cityMemoryRepo.printCities();
    }

}
