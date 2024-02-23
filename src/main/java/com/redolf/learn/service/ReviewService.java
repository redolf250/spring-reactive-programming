package com.redolf.learn.service;

import com.redolf.learn.Domain.Review;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ReviewService {

    public Flux<Review> getReviews(int bookId){
        var  reviews = List.of(new Review(1,bookId,9.0,"Really good"),
                                new Review(2,bookId,5.0,"Awesome!"));
        return Flux.fromIterable(reviews);
    }

    public Mono<Review> getReview(int bookId){
        var  review = new Review(1,bookId,9.0,"Really good");
        return Mono.just(review);
    }
}
