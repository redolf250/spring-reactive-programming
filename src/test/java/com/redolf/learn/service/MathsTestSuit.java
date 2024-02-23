package com.redolf.learn.service;


import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteDisplayName("Maths Test suite")
@SuiteClasses({MathServiceTest.class})
public final class MathsTestSuit {
    private MathsTestSuit() {
    }

    public static MathsTestSuit createMathsTestSuit() {
        return new MathsTestSuit();
    }
}
