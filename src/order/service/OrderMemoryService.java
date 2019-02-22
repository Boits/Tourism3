package order.service;

import order.Order;
import order.repo.OrderMemoryRepo;

public class OrderMemoryService {

    private OrderMemoryRepo orderMemoryRepo = new OrderMemoryRepo();

    public void addOrder(Order order) {
        orderMemoryRepo.addOrder(order);
    }

    public void deleteOrderByEntity(Order order) {
        orderMemoryRepo.deleteOrderByEntity(order);
    }

    public void deleteOrderByIndex(int index) {
        orderMemoryRepo.deleteOrderByIndex(index);
    }

//    public void deleteOrderByNumberOrder(Integer numberOrder) {
//        orderMemoryRepo.deleteOrderByNumberOrder(numberOrder);
//    }
//
//    public Order findOrderByNumberOrder(Integer numberOrder) {
//        return orderMemoryRepo.findOrderByNumberOrder(numberOrder);
//    }

    public int sizeList() {
        return orderMemoryRepo.sizeList();
    }

    public Integer findOrderIndexByEntity(Order order) {
        return orderMemoryRepo.findOrderIndexByEntity(order);
    }

    public void printOrders() {
        orderMemoryRepo.printOrders();
    }
}