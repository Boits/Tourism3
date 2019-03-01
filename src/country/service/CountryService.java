package country.service;

import common.business.service.BaseService;
import country.domain.Country;
import country.search.CountrySearchCondition;

import java.util.List;

public interface CountryService extends BaseService {
    void add(Country country);

    Country findById(Long id);

    void delete(Country country);

    List<Country> search(CountrySearchCondition searchCondition);

    void update(Country country);

}
