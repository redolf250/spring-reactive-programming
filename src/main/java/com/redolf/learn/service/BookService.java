package com.redolf.learn.service;


import com.redolf.learn.Domain.Book;
import com.redolf.learn.Domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class BookService {

    private BookInfoService bookInfoService;
    private ReviewService reviewService;

    public BookService(BookInfoService bookInfoService, ReviewService reviewService) {
        this.bookInfoService = bookInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Book> getBooks(){
        var allBooks = bookInfoService.getBooks();
        return allBooks.flatMap(bookInfo -> {
            Mono<List<Review>> reviewList = reviewService.getReviews(bookInfo.getBookId()).collectList();
            return reviewList.map(reviews -> new Book(bookInfo,reviews));
        });
    }
}
