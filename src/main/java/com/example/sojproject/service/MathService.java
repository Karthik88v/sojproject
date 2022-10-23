package com.example.sojproject.service;

import java.util.List;

public interface MathService {

    public List<Integer> getMinimumNumbers(List<Integer> numbers, Integer quantifier) throws Exception;

    List<Integer> getMaximumNumbers(List<Integer> numbers, Integer quantifier) throws Exception;

    Double calculateAverage(List<Integer> numbers) throws Exception;

    Double calculateMedian(List<Integer> numbers) throws Exception;

    Double calculatePercentile(List<Integer> numbers, Integer quantifier) throws Exception;
}
