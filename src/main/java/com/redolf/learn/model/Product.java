package com.redolf.learn.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Product {
    private int id;
    private double price;
    private String productName;
}
