package com.redolf.learn.service;

import com.redolf.learn.ArgumentsProvider.JobAggregator;
import com.redolf.learn.ArgumentsProvider.MathsArgumentsProvider;
import com.redolf.learn.Domain.Job;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(value = JUnitPlatform.class)
class MathServiceTest {

    MathService service;

    public static Stream<Arguments> add() {
        return Stream.of(
                Arguments.of(5,5),
                Arguments.of(90,5),
                Arguments.of(10,10),
                Arguments.of(10,30));
    }

    @BeforeEach
    void setUp() {
     service = new MathService();
    }

    @AfterEach
    void tearDown() {
        service=null;
    }


    @MethodSource
    @ParameterizedTest
    void add(int x, int y) {
        final int add = service.add(x, y);
        assertEquals(service.getResult(),add);
    }

    @ParameterizedTest
    @CsvSource({"100,100","200,200"})
    void addWithCsvSource(int x, int y) {
        final int add = service.add(x, y);
        assertEquals(service.getResult(),add);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv",numLinesToSkip = 1)
    void readData(String JobId, String Title, String Employer) {
        System.out.println("JobId = " + JobId + ", Title = " + Title + ", Employer = " + Employer);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv",numLinesToSkip = 1)
    void readData(@AggregateWith(JobAggregator.class) Job job) {
        assertNotNull(job);
    }



    @MethodSource("com.redolf.learn.ArgumentsProvider.ArgumentsProvider#subtract")
    @ParameterizedTest
    void subtract(int x, int y) {
        final int result = service.subtract(x, y);
        assertEquals(service.getResult(),result);
    }


    @ParameterizedTest
    @ArgumentsSource(MathsArgumentsProvider.class)
    void hypot(int x, int y) {
        final int result = (int) service.hypot(x, y);
        assertEquals(service.getResult(),result);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 5, 45, 90, 67, 54})
    void multiply(int x){
        final int result = service.multiply(x);
        assertEquals(service.getResult(),result);
    }

    @NullSource
    @ParameterizedTest
    void nullSource(String text) {
        assertNull(text);
    }

    @EmptySource
    @ParameterizedTest
    void emptySource(String text) {
        assertTrue(text.isEmpty());
    }
}