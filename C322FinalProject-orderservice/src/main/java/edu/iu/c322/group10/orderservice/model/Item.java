package edu.iu.c322.group10.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int itemId;

    @NotEmpty
    private String name;

    private float price;

    @OneToMany(mappedBy = "itemId",cascade = CascadeType.ALL)
    private List<Comment> comments;



    public int getItemId(){
        return itemId;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public List<Comment> getComments() {
        return comments;
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

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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