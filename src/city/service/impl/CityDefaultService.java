package city.service.impl;

import city.domain.City;
import city.repo.CityRepo;
import city.search.CitySearchCondition;
import city.service.CityService;
import order.domain.Order;
import order.repo.OrderRepo;

import java.util.Iterator;
import java.util.List;

public class CityDefaultService implements CityService {
    private final CityRepo cityRepo;
    private final OrderRepo orderRepo;

    public CityDefaultService(CityRepo cityRepo, OrderRepo orderRepo) {
        this.cityRepo = cityRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    @Deprecated
    public void add(City city) {
        if (city != null) {
            cityRepo.add(city);
        }
    }

    @Override
    public City findById(Long id) {
        if (id != null) {
            return cityRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(City city) {
        if (city.getId() != null) {
            deleteOrdersByCity(city);
            deleteById(city.getId());
        }
    }

    private void deleteOrdersByCity(City city) {

        List<Order> orders = orderRepo.getAll();
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (city.getId().equals(order.getCity().getId())) {
                iterator.remove();
            }
        }
    }

//    private void deleteOrdersByCity(City city) {
//        for (Order order : orderRepo.getAll()) {
//            if (order.getCity().getId() != null) {
//                if (city.getId().equals(order.getCity().getId())) {
//                    System.out.println("Hello!");
//                    orderRepo.deleteById(order.getId());
//                }
//            }
//        }
//    }

    @Override
    public void deleteById(Long idCity) {
        if (idCity != null) {
            cityRepo.deleteById(idCity);
        }
    }

    @Override
    public List<City> search(CitySearchCondition searchCondition) {
        return cityRepo.search(searchCondition);
    }

    @Override
    public void update(City city) {
        if (city.getId() != null) {
            cityRepo.update(city);
        }
    }

    @Override
    public void printAll() {
        cityRepo.printAll();
    }

    @Override
    public List<City> getAll() {
        return cityRepo.getAll();
    }

}
