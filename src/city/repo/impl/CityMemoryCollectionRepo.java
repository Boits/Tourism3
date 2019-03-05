package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import storage.SequenceGenerator;
import java.util.Collections;
import java.util.List;
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
    public List<City> search(CitySearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void update(City city) {
        //
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
        Collections.sort(cityList);
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

