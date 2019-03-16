package order.repo.impl.memory;

import common.solution.utils.ArrayUtils;
import order.domain.Order;
import order.repo.OrderRepo;
import order.search.OrderSearchCondition;
import storage.SequenceGenerator;

import java.util.Collections;
import java.util.List;

import static storage.Storage.orderArray;


public class OrderMemoryArrayRepo implements OrderRepo {
    private static final Order[] EMPTY_ORDERS_ARR = new Order[0];
    private int orderIndex = -1;

    @Override
    public void add(Order order) {
        if (orderIndex == orderArray.length - 1) {
            Order[] newArrOrders = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newArrOrders, 0, orderArray.length);
            orderArray = newArrOrders;
        }

        orderIndex++;
        order.setId(SequenceGenerator.getNextValue());
        orderArray[orderIndex] = order;
    }

    @Override
    public Order findById(Long id) {
        Integer orderIndex = findOrderIndexById(id);
        if (orderIndex != null) {
            return orderArray[orderIndex];
        }

        return null;
    }

    @Override
    public void update(Order entity) {
        //
    }

    @Override
    public void deleteById(Long id) {
        Integer orderIndex = findOrderIndexById(id);

        if (orderIndex != null) {
            deleteOrderByIndex(orderIndex);
        }
    }

    @Override
    public void printAll() {
        for (Order order : orderArray) {
            if (order != null) {
                System.out.println(order);
            }
        }
    }

    @Override
    public List<Order> search(OrderSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    private void deleteOrderByIndex(int index) {
        ArrayUtils.removeElement(orderArray, index);
        orderIndex--;
    }

    private Integer findOrderIndexById(long orderId) {
        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i] != null && Long.valueOf(orderId).equals(orderArray[i].getId())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
