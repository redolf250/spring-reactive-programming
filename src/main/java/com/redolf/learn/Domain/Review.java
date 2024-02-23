package com.redolf.learn.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private int reviewId;
    private int bookId;
    private double ratings;
    private String comments;
}
