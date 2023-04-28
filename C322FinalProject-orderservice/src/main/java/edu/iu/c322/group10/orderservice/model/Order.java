package edu.iu.c322.group10.orderservice.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private int customerId;

    private String orderStatus;

    @OneToMany(mappedBy = "itemId",cascade = CascadeType.ALL)
    private List<Item> items;


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return (getOrderId() == order.getOrderId());
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
