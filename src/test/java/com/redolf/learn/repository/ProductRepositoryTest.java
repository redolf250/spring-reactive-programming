package com.redolf.learn.repository;

import com.redolf.learn.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("My Test Suite")
class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    @Test
    void productList() {
        StepVerifier.create(repository.fruitFlux())
                .expectNext("Mango", "Orange")
                .verifyComplete();
    }

    @Test
    void flatMap(){
        StepVerifier.create(repository.fruitFluxFlatMap()).expectNextCount(11).verifyComplete();
    }

    @Test
    void concatMap(){
        StepVerifier.create(repository.fruitFluxConcatMap()).expectNextCount(11).verifyComplete();
    }

    @Test
    void flatMapAsync(){
        StepVerifier.create(repository.fruitFluxFlatMapAsync()).expectNextCount(11).verifyComplete();
    }

    @Test
    void  fruitFluxFilter(){
        StepVerifier.create(repository.fruitFluxFilter(5)).expectNext("Mango").verifyComplete();
    }

    @Test
    void  fruitFluxFilterSwitchIfEmpty(){
        StepVerifier.create(repository.fruitFluxFilterSwitchIfEmpty(10))
                .expectNext("Pineapple","Cucumber")
                .verifyComplete();
    }

    @Test
    void  fruitFluxConcat(){
        StepVerifier.create(repository.fruitFluxConcat())
                .expectNext("Mango","Orange","Carrot","Cabbage")
                .verifyComplete();
    }

    @Test
    void  fruitFluxConcatWith(){
        StepVerifier.create(repository.fruitFluxConcatWith())
                .expectNext("Mango","Orange","Carrot","Cabbage")
                .verifyComplete();
    }

//    @Test
//    void  fruitFluxMerge(){
//        StepVerifier.create(repository.fruitFluxMerge())
//                .expectNext("Mango","Carrot","Orange","Cabbage")
//                .verifyComplete();
//    }

    @Test
    void  fruitFluxZip(){
        StepVerifier.create(repository.fruitFluxZip())
                .expectNext("MangoCarrot","OrangeCabbage")
                .verifyComplete();
    }

    @Test
    void fruitFluxOnErrorMap(){
        StepVerifier.create(repository.fruitFluxOnErrorMap())
                .expectNext("MANGO")
                .expectError(IllegalAccessException.class)
                .verify();
    }

    @Test
    void fruitFluxDoOnError(){
        StepVerifier.create(repository.fruitFluxDoOnError())
                .expectNext("MANGO")
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    void productMono() {
    }

}