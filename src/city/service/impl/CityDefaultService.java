package city.service.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import city.service.CityService;
import country.domain.Country;
import country.repo.CountryRepo;

import java.util.List;

public class CityDefaultService implements CityService {
    private final CityRepo cityRepo;
    private final CountryRepo countryRepo;

    public CityDefaultService(CityRepo cityRepo, CountryRepo countryRepo) {
        this.cityRepo = cityRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public void add(City city) {
        if (city != null) {
            cityRepo.add(city);

            if (city.getCountries() != null) {
                for (Country country : city.getCountries()) {
                    if (country != null) {
                        countryRepo.add(country);
                    }
                }
            }
        }
    }

    @Override
    public City findById(Long id) {
        if (id != null) {
            return cityRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(City city) {
        if (city.getId() != null) {
            this.deleteById(city.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            cityRepo.deleteById(id);
        }
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return cityRepo.search(searchCondition);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null) {
            cityRepo.update(city);
        }
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }
}
