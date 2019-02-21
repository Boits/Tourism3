package order.repo;

import order.Order;
import order.service.OrderMemoryService;

import java.util.ArrayList;
import java.util.List;

public class OrderMemoryRepo {
    List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void deleteOrderByEntity(Order order) {
        orderList.remove(order);
    }

    public void deleteOrderByIndex(int index) {
        orderList.remove(index);
    }

    public Order findOrderByNumberOrder(Integer numberOrder) {
        for (Order order : orderList) {
            if (order.getNumberOrder().equals(numberOrder)) {
                return order;
            }
        }
        return null;
    }

    public Integer findOrderIndexByEntity(Order order) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).equals(order)) {
                return i;
            }
        }
        return null;
    }

    public void deleteOrderByNumberOrder(Integer numberOrder) {
        for (Order order : orderList) {
            if (order.getNumberOrder().equals(numberOrder)) {
                deleteOrderByEntity(order);
            }
        }
    }

    public void printOrders() {
        System.out.println("All orders:");
        for (Order order : orderList) {
            System.out.print(order + " ");
        }
    }
}
