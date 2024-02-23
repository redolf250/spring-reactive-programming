package com.redolf.learn.Domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {
    private int bookId;
    private String title;
    private String author;
    private String ISBN;
}
