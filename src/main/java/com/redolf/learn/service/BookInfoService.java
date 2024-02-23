package com.redolf.learn.service;

import com.redolf.learn.Domain.BookInfo;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class BookInfoService {

    public Flux<BookInfo> getBooks(){
        var  bookInfos = List.of(new BookInfo(1,"Book One","Author One","1234"),
                                new BookInfo(2,"Book Two","Author Two","8989"),
                                new BookInfo(3,"Book Three","Author Three","58659"));
        return Flux.fromIterable(bookInfos).log();
    }

    public Mono<BookInfo> getBookById(int bookId){
        var  bookInfos = new BookInfo(bookId,"Book One","Author One","1234");
        return Mono.just(bookInfos);
    }
}
