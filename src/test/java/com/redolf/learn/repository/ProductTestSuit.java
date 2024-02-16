package com.redolf.learn.repository;

import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@SuiteDisplayName("Test suite")
@org.junit.runners.Suite.SuiteClasses({ProductRepositoryTest.class})
public class ProductTestSuit {
}
