package order.repo.impl.memory;

import city.domain.City;
import order.domain.Order;
import order.repo.OrderRepo;
import order.search.OrderSearchCondition;
import storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static storage.Storage.orderList;

public class OrderMemoryCollectionRepo implements OrderRepo {

    @Override
    public void add(Order order) {
        order.setId(SequenceGenerator.getNextValue());
        orderList.add(order);
    }

    @Override
    public Order findById(Long id) {
        return findOrderById(id);
    }

    @Override
    public void update(Order entity) {
        //
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    @Override
    public void deleteById(Long id) {
        Order found = findOrderById(id);

        if (found != null) {
            orderList.remove(found);
        }
    }

    @Override
    public void printAll() {
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    private Order findOrderById(long orderId) {
        for (Order order : orderList) {
            if (Long.valueOf(orderId).equals(order.getId())) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> findByUserId(long userId) {
        List<Order> ordersWithUserId = new ArrayList<>();

        for (Order order : orderList) {
            if (order.getUser().getId().equals(userId)) {
                ordersWithUserId.add(order);
            }
        }

        return ordersWithUserId;
    }

}