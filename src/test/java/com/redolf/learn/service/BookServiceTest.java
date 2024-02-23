package com.redolf.learn.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceTest {

    BookService bookService;

    @BeforeEach
    void setUp() {
        BookInfoService bookInfoService = new BookInfoService();
        ReviewService reviewService = new ReviewService();
        bookService = new BookService(bookInfoService, reviewService);
    }

    @Test
    void getBooks() {
        StepVerifier.create(bookService.getBooks().log())
                .assertNext(book -> {
                    assertEquals("Book One",book.getBookInfo().getTitle());
                    assertEquals(2,book.getReview().size());
                })
                .assertNext(book -> {
                    assertEquals("Book Two",book.getBookInfo().getTitle());
                    assertEquals(2,book.getReview().size());
                })
                .assertNext(book -> {
                    assertEquals("Book Three",book.getBookInfo().getTitle());
                    assertEquals(2,book.getReview().size());
                })
                .verifyComplete();
    }
}