package com.redolf.learn.controller;

import com.redolf.learn.Domain.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class WebClientController {

    @Autowired
    private WebClient webClient;
    @PostMapping("/bookInfo")
    public Mono<BookInfo> save(@RequestBody BookInfo bookInfo){
        return webClient
                .post()
                .uri("/")
                .syncBody(bookInfo)
                .retrieve()
                .bodyToMono(BookInfo.class);
    }

    @GetMapping("/bookInfos")
    public Flux<BookInfo> getAll(){
        return webClient
                .get()
                .uri("/")
                .retrieve()
                .bodyToFlux(BookInfo.class);
    }

    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable int id){
        return webClient
                .delete()
                .uri("/",id)
                .retrieve()
                .bodyToMono(String.class);
    }

    @PutMapping("/{id}")
    public Mono<BookInfo> update(@RequestBody BookInfo bookInfo, @PathVariable int id){
        return webClient
                .put()
                .uri("/",id)
                .syncBody(bookInfo)
                .retrieve()
                .bodyToMono(BookInfo.class);
    }

}
