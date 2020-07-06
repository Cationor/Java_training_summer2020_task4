package com.epamcourse.homework4.service.jaggedarray;

import com.epamcourse.homework4.exception.InvalidException;

public class SortOptions {
    public static int largerSum(int [] array) throws InvalidException {
        if (array == null) {
            throw new InvalidException("Null array error");
        }
        int sum = 0;
        for (int elem : array) {
            sum += elem;
        }

        return sum;
    }

    public static int maxElement(int [] array) throws InvalidException {
        if (array == null) {
            throw new InvalidException("Null array error");
        }
        int maxElement = 0;
        for (int elem : array) {
            if (maxElement < elem) {
                maxElement = elem;
            }
        }

        return maxElement;
    }

    public static int minElement(int [] array) throws InvalidException {
        if (array == null) {
            throw new InvalidException("Null array error");
        }
        int minElement = Integer.MAX_VALUE;
        for (int elem : array) {
            if (minElement > elem) {
                minElement = elem;
            }
        }

        return minElement;
    }
}
