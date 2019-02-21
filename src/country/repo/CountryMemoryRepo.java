package country.repo;

import country.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryMemoryRepo {
    List<Country> countryList = new ArrayList<>();

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public void deleteCountryByEntity(Country country) {
        countryList.remove(country);
    }

    public void deleteCountryByIndex(int index) {
        countryList.remove(index);
    }

    public Country findCountryByLocation(String location) {
        for (Country country : countryList) {
            if (country.getLocation().equals(location)) {
                return country;
            }
        }
        return null;
    }

    public Integer findCountryIndexByEntity(Country country) {
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
                deleteCountryByEntity(country);
            }
        }
    }

    public void printCountries() {
        System.out.println("All countries:");
        for (Country country : countryList) {
            System.out.print(country + " ");
        }
    }

}
