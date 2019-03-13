package user.domain;

import common.business.domain.BaseDomain;
import order.domain.Order;

import java.util.List;

public class User extends BaseDomain{
    private String firstName;
    private String lastName;
    private Integer passport;
    private List<Order> orders;
    private ClientType clientType;

    public User() {
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, Integer passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
    }

    public User(String firstName, String lastName, Integer passport, List<Order> orders) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPassport() {
        return passport;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    @Override
    public String toString() {
        return id + " " + firstName + " " + lastName;
    }
}
