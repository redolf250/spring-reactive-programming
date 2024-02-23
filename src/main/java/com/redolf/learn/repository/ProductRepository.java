package com.redolf.learn.repository;

import com.redolf.learn.model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository {

    public Flux<Product> productList(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,200,"Royal Aroma 4.5kg"));
        productList.add(new Product(2,250,"Royal Aroma 5kg"));
        productList.add(new Product(3,100,"Frytol Oilers 3.5g"));
        productList.add(new Product(1,200,"Royal Aroma 4.5kg"));
        productList.add(new Product(2,250,"Royal Aroma 5kg"));
        productList.add(new Product(3,100,"Frytol Oilers 3.5g"));
        productList.add(new Product(1,200,"Royal Aroma 4.5kg"));
        productList.add(new Product(2,250,"Royal Aroma 5kg"));
        productList.add(new Product(3,100,"Frytol Oilers 3.5g"));
        return Flux.fromIterable(productList)
                .delayElements(Duration.ofMillis(1000))
                .log();
    }

    public Flux<String> fruitFlux(){
        return Flux.fromIterable(List.of("Mango","Orange"));
    }

    public Flux<String> fruitFluxFlatMap(){
        return Flux.fromIterable(List.of("Mango","Orange")).flatMap(s -> Flux.just(s.split(""))).log();
    }

    public Flux<String> fruitFluxConcatMap(){
        return Flux.fromIterable(List.of("Mango","Orange")).concatMap(s -> Flux.just(s.split(""))).log();
    }

    public Flux<String> fruitFluxFlatMapAsync(){
        return Flux.fromIterable(List.of("Mango","Orange")).flatMap(s -> Flux.just(s.split(""))
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))).log();
    }

    public Flux<String> fruitFluxFilter(int length){
        return Flux.fromIterable(List.of("Mango","Orange"))
                .filter(s -> s.length() == length)
                .log();
    }

    public Flux<String> fruitFluxFilterSwitchIfEmpty(int length){
        return Flux.fromIterable(List.of("Mango","Orange"))
                .filter(s -> s.length() == length)
                .switchIfEmpty(Flux.just("Pineapple","Cucumber"))
                .log();
    }

    public Flux<String> fruitFluxConcat(){
        var fruits = Flux.just("Mango","Orange");
        var veggies = Flux.just("Carrot","Cabbage");
        return Flux.concat(fruits,veggies).log();
    }

    public Flux<String> fruitFluxConcatWith(){
        var fruits = Flux.just("Mango","Orange");
        var veggies = Flux.just("Carrot","Cabbage");
        return fruits.concatWith(veggies).log();
    }

    public Flux<String> fruitFluxMerge(){
        var fruits = Flux.just("Mango","Orange")
                .delayElements(Duration.ofMillis(new Random().nextInt(50)));
        var veggies = Flux.just("Carrot","Cabbage")
                .delayElements(Duration.ofMillis(new Random().nextInt(75)));;
        return Flux.merge(fruits,veggies).log();
    }

    public Flux<String> fruitFluxZip(){
        var fruits = Flux.just("Mango","Orange");
        var veggies = Flux.just("Carrot","Cabbage");
        return Flux.zip(fruits,veggies,(first,second)->first+second).log();
    }

    public Flux<String> fruitFluxOnErrorMap(){
        return Flux.just("Mango","Orange","Carrot","Cabbage")
                .<String>handle((s, sink) -> {
                    if (s.equalsIgnoreCase("Orange")) {
                        sink.error(new RuntimeException("Bad fruit flavor"));
                        return;
                    }
                    sink.next(s.toUpperCase());
                }).onErrorMap(throwable -> {
                    System.out.println(throwable.getMessage());
                   return new IllegalAccessException();
                });
    }

    public Flux<String> fruitFluxDoOnError(){
        return Flux.just("Mango","Orange","Carrot","Cabbage")
                .<String>handle((s, sink) -> {
                    if (s.equalsIgnoreCase("Orange")) {
                        sink.error(new RuntimeException("Bad fruit flavor"));
                        return;
                    }
                    sink.next(s.toUpperCase());
                }).doOnError(throwable -> {
                    System.out.println(throwable.getMessage());
                });
    }

    public Mono<Product> productMono(){
        return Mono.just(new Product(1,200,"Royal Aroma 4.5kg")).log();
    }

    public Flux<Integer> multiplyByFive(){
        return Flux.just(1,2,3,4,5)
                .map(integer -> integer * 5)
                .map(integer -> integer * 5)
                .flatMap(Flux::just)
                .doOnComplete(() -> System.out.println("done!!!"))
                .log();
    }

    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
//        repository.productList().subscribe(product -> {
//            System.out.println("product = " + product);
//        });

        repository.multiplyByFive().subscribe(System.out::println);
    }
}
