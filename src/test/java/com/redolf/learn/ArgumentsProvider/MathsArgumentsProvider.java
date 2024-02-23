package com.redolf.learn.ArgumentsProvider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MathsArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(5,5),
                Arguments.of(90,5),
                Arguments.of(10,10),
                Arguments.of(10,30),
                Arguments.of(6,7),
                Arguments.of(9,5),
                Arguments.of(50,10),
                Arguments.of(70,30)
        );
    }
}
