package common.business.application.servicefactory;

import city.service.CityService;
import common.business.application.StorageType;
import country.service.CountryService;
import order.service.OrderService;
import user.service.UserService;

public final class ServiceSupplier {
    private static ServiceSupplier INSTANCE;
    private ServiceFactory serviceFactory;

    public static ServiceSupplier getInstance() {
        return INSTANCE;
    }

    public static ServiceSupplier newInstance(StorageType storageType) {

        if (INSTANCE == null) {
            synchronized (ServiceSupplier.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ServiceSupplier(storageType);
                }
            }
        }
        return INSTANCE;
    }

    private ServiceSupplier(StorageType storageType) {
        initServiceFactory(storageType);
    }

    private void initServiceFactory(StorageType storageType) {
        switch (storageType) {
            case MEMORY_ARRAY: {
                serviceFactory = new MemoryArrayServiceFactory();
            }
            case MEMORY_COLLECTION: {
                serviceFactory = new MemoryCollectionServiceFactory();
            }
        }
    }

//    private ServiceSupplier(SortType sortType) {
//        initServiceFactory2(sortType);
//    }
//
//    private void initServiceFactory2(SortType sortType) {
//        switch (sortType) {
//            case ASC: {
//                serviceFactory = new MemoryArrayServiceFactory();
//            }
//            case DESC: {
//                serviceFactory = new MemoryCollectionServiceFactory();
//            }
//        }
//    }

    public CityService getCityService() {
        return serviceFactory.getCityService();
    }

    public CountryService getCountryService() {
        return serviceFactory.getCountryService();
    }

    public OrderService getOrderService() {
        return serviceFactory.getOrderService();
    }

    public UserService getUserService() {
        return serviceFactory.getUserService();
    }
}