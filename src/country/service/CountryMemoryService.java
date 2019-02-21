package country.service;

import country.Country;
import country.repo.CountryMemoryRepo;

public class CountryMemoryService {
    CountryMemoryRepo countryMemoryRepo = new CountryMemoryRepo();

    public void addCountry(Country country) {
        countryMemoryRepo.addCountry(country);
    }

    public void deleteCountryByEntity(Country country) {
        countryMemoryRepo.deleteCountryByEntity(country);
    }

    public void deleteCountryByIndex(int index) {
        countryMemoryRepo.deleteCountryByIndex(index);
    }

    public void deleteCountryByLocation(String location) {
        countryMemoryRepo.deleteCountryByLocation(location);
    }

    public Country findCountryByLocation(String location) {
        return countryMemoryRepo.findCountryByLocation(location);
    }

    public Integer findCountryIndexByEntity(Country country) {
        return countryMemoryRepo.findCountryIndexByEntity(country);
    }

    public void printCountries() {
        countryMemoryRepo.printCountries();
    }
}
