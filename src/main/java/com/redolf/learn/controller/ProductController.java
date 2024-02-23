package com.redolf.learn.controller;

import com.redolf.learn.model.Product;
import com.redolf.learn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(value = "/products",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProducts(){
        return repository.productList();
    }

    @GetMapping("/product")
    public Mono<Product> getProduct(){
        return repository.productMono();
    }
}
