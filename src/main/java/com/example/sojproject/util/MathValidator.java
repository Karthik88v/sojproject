package com.example.sojproject.util;

import java.util.List;

public class MathValidator {

    public static boolean isEmptyList(List<Integer> numbers) {
        return (numbers == null || numbers.size() == 0);
    }

    public static boolean isEmptyNumber(Integer number) {
        return (number == null || number <= 0);
    }
}
