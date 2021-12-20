package com.example.spring_data_1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product() {
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
