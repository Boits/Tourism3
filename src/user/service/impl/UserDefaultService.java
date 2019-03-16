package user.service.impl;

import order.domain.Order;
import order.repo.OrderRepo;
import user.domain.User;
import user.exceptions.UserHasNoOrdersException;
import user.repo.UserRepo;
import user.search.UserSearchCondition;
import user.service.UserService;

import java.util.List;

public class UserDefaultService implements UserService {

    private final UserRepo userRepo;
    private final OrderRepo orderRepo;

    public UserDefaultService(UserRepo userRepo, OrderRepo orderRepo) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void add(User user) {
        if (user != null) {
            userRepo.add(user);
        }
    }

    /*
    // this add() not good

    @Override
    public void add(User user) {
        if (user != null) {
            userRepo.add(user);

            if (user.getOrders() != null) {
                for (Order order : user.getOrders()) {
                    if (order != null) {
                        orderRepo.add(order);
                    }
                }
            }
        }
    }
    */

    @Override
    public User findById(Long id) {
        if (id != null) {
            return userRepo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(User user) {
        if (user.getId() != null) {
            try {
                deleteOrdersByUser(user);
            } catch (UserHasNoOrdersException e) {
                System.out.println(e.getMessageExceptions() + " Code exception = " + e.getCode());
            }
        }
        deleteById(user.getId());
    }

    private void deleteOrdersByUser(User user) throws UserHasNoOrdersException {

        if (user.getOrders() != null) {
            for (Order order : user.getOrders()) {
                orderRepo.deleteById(order.getId());
            }
        } else {
            throw new UserHasNoOrdersException();
        }
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return userRepo.search(searchCondition);
    }

    @Override
    public void update(User user) {
        if (user.getId() != null) {
            userRepo.update(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            userRepo.deleteById(id);
        }
    }

    @Override
    public void printAll() {
        userRepo.printAll();
    }
}