package edu.iu.c322.group10.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int itemId;
    private String customerName;
    private String body;

}
