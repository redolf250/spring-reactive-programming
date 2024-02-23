package com.redolf.learn.ArgumentsProvider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ArgumentsProvider {

    public static Stream<Arguments> subtract() {
        return Stream.of(
                Arguments.of(55,50),
                Arguments.of(10,5),
                Arguments.of(20,10),
                Arguments.of(40,30));
    }

}
