package com.epamcourse.homework4.service.array;

import com.epamcourse.homework4.entity.IntArray;
import com.epamcourse.homework4.exception.InvalidException;

public class IntArrayFindService {
    public int findElemIndex(int elem, IntArray array)
            throws InvalidException {
        if (array == null) {
            throw new InvalidException("Null array error");
        }
        if (!array.isSorted()) {
            throw new InvalidException("sort array before find elem");
        }
        int right = array.getLength();
        int left = 0;
        int mid = (right + left) / 2;

        while (mid != left && mid != right) {
            if (array.getByIndex(mid) == elem) {
                return mid;
            } else if (array.getByIndex(mid) > elem) {
                right = mid;
                mid = (right + left) / 2;
            } else {
                left = mid;
                mid = (right + left) / 2;
            }
        }

        throw new InvalidException("no such elem");
    }

    public int[] findPrimeNumbers(IntArray array)
            throws InvalidException {
        Reporter prime = this::prime;
        return findElements(prime, array);
    }

    public int[] findFibonacciNumbers(IntArray array)
            throws InvalidException {
        Reporter fibonacci = this::fibonacci;
        return findElements(fibonacci, array);
    }

    public int[] findNumbersWithNoSameLetters(IntArray array)
            throws InvalidException {
        Reporter noSameLetters = this::noSameLetters;
        return findElements(noSameLetters, array);
    }

    private boolean prime(int elem) {
        if (elem < 0) {
            return false;
        }

        int mark = 0;
        for (int j = elem - 1; j > 1; j--) {
            double tmp = ((double) elem)/j;
            if (tmp == (int) tmp) {
                mark++;
            }
        }

        return (mark == 0);
    }

    private boolean fibonacci(int elem) {
        int MAX_FIBONACCI_NUMBER = 47;
        for (int i = 0; i < MAX_FIBONACCI_NUMBER; i++) {
            if (elem == calculateFibonacci(i)) {
                return true;
            }
        }

        return false;
    }

    private int calculateFibonacci(int n) {
        double phi = (Math.sqrt(5) + 1) / 2;
        return (int) (Math.pow(phi, n) / Math.sqrt(5) + 0.5);
    }

    private boolean noSameLetters(int elem) {
        int unity = elem % 10;
        int ten = (elem % 100 - unity) / 10;
        int century = (elem - ten * 10 - unity) / 100;
        return (ten == century) && (unity == century);
    }

    private int [] findElements(Reporter func,
                                         IntArray array) throws InvalidException {
        if (array == null) {
            throw new InvalidException("array is null!!!");
        }
        int quantity = 0;
        for (int i = 0; i< array.getLength();i++) {
            quantity += (func.appear(array.getByIndex(i))) ? 1 : 0;
        }

        int[] numbers = new int[quantity];
        int j = 0;
        for (int i = 0;i<array.getLength();i++) {
            if (func.appear(array.getByIndex(i))) {
                numbers[j] = array.getByIndex(i);
                j++;
            }
        }

        return numbers;
    }
}

interface Reporter {
    boolean appear(int elem);
}
