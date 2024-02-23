package com.redolf.learn.ArgumentsProvider;

import com.redolf.learn.Domain.Job;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class JobAggregator implements ArgumentsAggregator {
    public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return new Job(argumentsAccessor.getString(0),argumentsAccessor.getString(1),argumentsAccessor.getString(2));
    }
}
