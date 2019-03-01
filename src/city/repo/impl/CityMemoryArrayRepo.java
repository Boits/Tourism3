package city.repo.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import common.solution.utils.ArrayUtils;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static common.solution.utils.StringUtils.isNotBlank;
import static storage.Storage.cityArray;

public class CityMemoryArrayRepo implements CityRepo {
    private int cityIndex = -1;

    @Override
    public void add(City city) {
        if (cityIndex == cityArray.length - 1) {
            City[] newArrCities = new City[cityArray.length * 2];
            System.arraycopy(cityArray, 0, newArrCities, 0, cityArray.length);
            cityArray = newArrCities;
        }

        cityIndex++;
        city.setId(SequenceGenerator.getNextValue());
        cityArray[cityIndex] = city;
    }

    @Override
    public City findById(long id) {
        Integer cityIndex = findCityIndexById(id);
        if (cityIndex != null) {
            return cityArray[cityIndex];
        }

        return null;
    }


    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            boolean searchByCountry = isNotBlank(searchCondition.getCountry());

            boolean searchByName = isNotBlank(searchCondition.getName());

            City[] result = new City[cityArray.length];
            int resultIndex = 0;

            for (City city : cityArray) {
                if (city != null) {
                    boolean found = true;

                    if (searchByCountry) {
                        found = searchCondition.getCountry().equals(city.getCountry());
                    }

                    if (found && searchByName) {
                        found = searchCondition.getName().equals(city.getNameCity());
                    }

                    if (found) {
                        result[resultIndex] = city;
                        resultIndex++;
                    }
                }
            }

            if (resultIndex > 0) {
                City toReturn[] = new City[resultIndex];
                System.arraycopy(result, 0, toReturn, 0, resultIndex);
                return new ArrayList<>(Arrays.asList(toReturn));
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void update(City city) {
        //
    }

    @Override
    public void deleteById(long id) {
        Integer cityIndex = findCityIndexById(id);

        if (cityIndex != null) {
            deleteCityByIndex(cityIndex);
        }
    }

    private void deleteCityByIndex(int index) {
        ArrayUtils.removeElement(cityArray, index);
        cityIndex--;
    }

    private Integer findCityIndexById(long cityId) {
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i] != null && Long.valueOf(cityId).equals(cityArray[i].getId())) {
                return i;
            }
        }
        return null;
    }


    @Override
    public void printAll() {
        for (City city : cityArray)
            if (city != null) {
                System.out.println(city);
            }
    }
}
