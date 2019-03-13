package country.repo.impl.memory;

import common.solution.utils.ArrayUtils;
import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static common.solution.utils.StringUtils.isNotBlank;
import static storage.Storage.countryArray;

public class CountryMemoryArrayRepo implements CountryRepo {
    private static final Country[] EMPTY_COUNTRIES_ARR = new Country[0];
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();
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
    public Country findById(Long id) {
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
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<Country> result = doSearch(searchCondition);
            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();

            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }

    private List<Country> doSearch(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByName = isNotBlank(searchCondition.getName());
            boolean searchByLanguage = isNotBlank(searchCondition.getLanguage());

            Country[] result = new Country[countryArray.length];
            int resultIndex = 0;

            for (Country country : countryArray) {
                if (country != null) {
                    boolean found = true;

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(country.getName());
                    }

                    if (searchByLanguage) {
                        found = searchCondition.getLanguage().equals(country.getLanguage());
                    }

                    if (found) {
                        result[resultIndex] = country;
                        resultIndex++;
                    }
                }
            }

            if (resultIndex > 0) {
                Country toReturn[] = new Country[resultIndex];
                System.arraycopy(result, 0, toReturn, 0, resultIndex);
                return new ArrayList<>(Arrays.asList(toReturn));
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void update(Country country) {
        //
    }

    @Override
    public void deleteById(Long id) {
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
