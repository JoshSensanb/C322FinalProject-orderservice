package edu.iu.c322.group10.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int itemId;

    @NotEmpty
    private String name;

    private float price;

    public int getItemId(){
        return itemId;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return getItemId() == item.getItemId() && Float.compare(item.getPrice(), getPrice()) == 0 && getName().equals(item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getName(), getPrice());
    }
}
