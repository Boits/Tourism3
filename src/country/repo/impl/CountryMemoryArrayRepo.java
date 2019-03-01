package country.repo.impl;

import common.solution.utils.ArrayUtils;
import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import storage.SequenceGenerator;

import java.util.Collections;
import java.util.List;

import static storage.Storage.countryArray;

public class CountryMemoryArrayRepo implements CountryRepo {
    private static final Country[] EMPTY_COUNTRIES_ARR = new Country[0];
    private int countryIndex = -1;

    @Override
    public void add(Country country) {
        if (countryIndex == countryArray.length - 1) {
            Country[] newArrModels = new Country[countryArray.length * 2];
            System.arraycopy(countryArray, 0, newArrModels, 0, countryArray.length);
            countryArray = newArrModels;
        }

        countryIndex++;
        country.setId(SequenceGenerator.getNextValue());
        countryArray[countryIndex] = country;
    }

    @Override
    public Country findById(long id) {
        Integer countryIndex = findCountryIndexById(id);
        if (countryIndex != null) {
            return countryArray[countryIndex];
        }

        return null;
    }

    private Integer findCountryIndexById(long countryId) {
        for (int i = 0; i < countryArray.length; i++) {
            if (countryArray[i] != null && Long.valueOf(countryId).equals(countryArray[i].getId())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void update(Country country) {
        //
    }

    @Override
    public void deleteById(long id) {
        Integer countryIndex = findCountryIndexById(id);

        if (countryIndex != null) {
            deleteCountryByIndex(countryIndex);
        }
    }

    private void deleteCountryByIndex(int index) {
        ArrayUtils.removeElement(countryArray, index);
        countryIndex--;
    }

    @Override
    public void printAll() {
        for (Country country : countryArray) {
            if (country != null) {
                System.out.println(country);
            }
        }
    }
}
