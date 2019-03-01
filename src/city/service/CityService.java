package city.service;

import city.domain.City;
import city.search.CitySearchCondition;
import common.business.service.BaseService;

import java.util.List;

public interface CityService extends BaseService {
    void add(City city);

    City findById(Long id);

    void delete(City city);

    List<City> search(CitySearchCondition searchCondition);

    void update(City city);
}
