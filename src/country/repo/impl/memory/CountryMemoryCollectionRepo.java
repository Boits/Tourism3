package country.repo.impl.memory;

import country.domain.Country;
import country.repo.CountryRepo;
import country.search.CountrySearchCondition;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static common.solution.utils.StringUtils.isNotBlank;
import static storage.Storage.countryList;

public class CountryMemoryCollectionRepo implements CountryRepo {
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();

    @Override
    public void add(Country country) {
        country.setId(SequenceGenerator.getNextValue());
        countryList.add(country);
    }

    @Override
    public Country findById(Long id) {
        return findCountryById(id);
    }

    private Country findCountryById(long countryId) {
        for (Country country : countryList) {
            if (Long.valueOf(countryId).equals(country.getId())) {
                return country;
            }
        }
        return null;
    }

    @Override
    public void update(Country country) {
        //
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

            List<Country> result = new ArrayList<>();

            for (Country country : countryList) {
                if (country != null) {
                    boolean found = true;

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(country.getName());
                    }

                    if (searchByLanguage) {
                        found = searchCondition.getLanguage().equals(country.getLanguage());
                    }

                    if (found) {
                        result.add(country);
                    }
                }
            }

            return result;
        }
    }

    @Override
    public void deleteById(Long id) {
        Country found = findCountryById(id);

        if (found != null) {
            countryList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (Country country : countryList) {
            System.out.println(country);
        }
    }

    @Override
    public List<Country> getAll() {
        return countryList;
    }
}
