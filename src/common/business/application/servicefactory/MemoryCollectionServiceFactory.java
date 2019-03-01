package common.business.application.servicefactory;

import city.repo.impl.CityMemoryCollectionRepo;
import city.service.CityService;
import city.service.impl.CityDefaultService;
import country.repo.impl.CountryMemoryCollectionRepo;
import country.service.CountryService;
import country.service.impl.CountryDefaultService;
import order.repo.impl.OrderMemoryCollectionRepo;
import order.service.OrderService;
import order.service.impl.OrderDefaultService;
import user.repo.impl.UserMemoryCollectionRepo;
import user.service.UserService;
import user.service.impl.UserDefaultService;

public class MemoryCollectionServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryCollectionRepo(), new CountryMemoryCollectionRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryCollectionRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryCollectionRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryCollectionRepo());
    }
}