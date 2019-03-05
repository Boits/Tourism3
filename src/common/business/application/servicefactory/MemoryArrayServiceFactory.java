package common.business.application.servicefactory;

import city.service.CityService;
import city.repo.impl.CityMemoryArrayRepo;
import city.service.impl.CityDefaultService;
import country.repo.impl.CountryMemoryArrayRepo;
import country.service.CountryService;
import country.service.impl.CountryDefaultService;
import order.repo.impl.OrderMemoryArrayRepo;
import order.service.OrderService;
import order.service.impl.OrderDefaultService;
import user.repo.impl.UserMemoryArrayRepo;
import user.service.UserService;
import user.service.impl.UserDefaultService;

public class MemoryArrayServiceFactory implements ServiceFactory {

    @Override
    public CityService getCityService() {
        return new CityDefaultService(new CityMemoryArrayRepo());
    }

    @Override
    public CountryService getCountryService() {
        return new CountryDefaultService(new CountryMemoryArrayRepo());
    }

    @Override
    public OrderService getOrderService() {
        return new OrderDefaultService(new OrderMemoryArrayRepo());
    }

    @Override
    public UserService getUserService() {
        return new UserDefaultService(new UserMemoryArrayRepo());
    }
}