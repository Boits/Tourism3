package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static common.solution.utils.StringUtils.isNotBlank;
import static storage.Storage.cityList;

public class CityMemoryCollectionRepo implements CityRepo {

    @Override
    public void add(City city) {
        city.setId(SequenceGenerator.getNextValue());
        cityList.add(city);
    }

    @Override
    public City findById(long id) {
        return findCityById(id);
    }

    @Override
    public void update(City city) {
        //we already in memory, no need to update object
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByCountry = isNotBlank(searchCondition.getCountry());

            boolean searchByName = isNotBlank(searchCondition.getName());

            List<City> result = new ArrayList<>();

            for (City city : cityList) {
                if (city != null) {
                    boolean found = true;

                    if (searchByCountry) {
                        found = searchCondition.getCountry().equals(city.getCountry());
                    }

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(city.getNameCity());
                    }

                    if (found) {
                        result.add(city);
                    }
                }
            }

            return result;
        }
    }

    @Override
    public void deleteById(long id) {
        City found = findCityById(id);

        if (found != null) {
            cityList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (City city : cityList) {
            System.out.println(city);
        }
    }

    private City findCityById(long cityId) {
        for (City city : cityList) {
            if (Long.valueOf(cityId).equals(city.getId())) {
                return city;
            }
        }
        return null;
    }

}

