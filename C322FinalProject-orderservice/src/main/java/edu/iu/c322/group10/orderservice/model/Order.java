package edu.iu.c322.group10.orderservice.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;


    private String orderStatus;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Item> items;


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
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
