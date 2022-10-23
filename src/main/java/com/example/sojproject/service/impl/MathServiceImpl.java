package com.example.sojproject.service.impl;

import com.example.sojproject.service.MathService;
import com.example.sojproject.util.MathValidator;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MathServiceImpl implements MathService {
    /**
     * Method to get minimum numbers
     * @param numbers
     * @param quantifier
     * @return
     */
    @Override
    public List<Integer> getMinimumNumbers(List<Integer> numbers, Integer quantifier) throws Exception {
        validateInputs(numbers, quantifier);
        Collections.sort(numbers);
        List<Integer> minList = numbers.subList(0, quantifier);
        return minList;
    }

    /**
     * Method to get maximum numbers
     * @param numbers
     * @param quantifier
     * @return
     */
    @Override
    public List<Integer> getMaximumNumbers(List<Integer> numbers, Integer quantifier) throws Exception {
        validateInputs(numbers, quantifier);
        Collections.sort(numbers, Collections.reverseOrder());
        List<Integer> maxList = numbers.subList(0, quantifier);
        return maxList;
    }

    /**
     * Method to calculate average
     * @param numbers
     * @return
     */
    @Override
    public Double calculateAverage(List<Integer> numbers) throws Exception {
        validateInputs(numbers);
        Double average = numbers.stream().mapToDouble(Double::valueOf).average().getAsDouble();
        return average;
    }

    /**
     * Method to calculate median
     * @param numbers
     * @return
     */
    @Override
    public Double calculateMedian(List<Integer> numbers) throws Exception {
        validateInputs(numbers);
        Collections.sort(numbers);
        if(numbers.size() % 2 == 0) {
            return ((double)(numbers.get(numbers.size() / 2) + numbers.get((numbers.size() / 2) - 1))) / 2;
        } else {
            return (double) numbers.get(numbers.size()/2);
        }
    }

    /**
     * Method to calculate percentile
     * @param numbers
     * @param quantifier
     * @return
     */
    @Override
    public Double calculatePercentile(List<Integer> numbers, Integer quantifier) throws Exception {
        validateInputs(numbers, quantifier);
        return ((double) quantifier/100) * numbers.size();
    }

    private static void validateInputs(List<Integer> numbers) throws Exception {
        if(MathValidator.isEmptyList(numbers)) {
            throw new Exception("List should not be empty or null");
        }
    }

    private static void validateInputs(List<Integer> numbers, int quantifier) throws Exception {
        if(MathValidator.isEmptyList(numbers)) {
            throw new Exception("List should not be empty or null");
        }
        if(MathValidator.isEmptyNumber(quantifier)) {
            throw new Exception("Quantifier must be greater than 0");
        }
    }
}
