package com.epamcourse.homework4_1.service;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.exception.InvalidArrayDataException;
import com.epamcourse.homework4_1.validator.ArrayValidator;

public class ArraySearcherService {
    private static final int[] PRIME_DIVIDERS = {2, 3, 5, 7};

    public int binarySearch(ArithmeticArray array, int value) throws InvalidArrayDataException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.validateArrayBinarySearch(array)) {
            throw new InvalidArrayDataException("Invalid array data for binary search");
        }

        int maxIndex = array.getLength();
        int minIndex = 0;
        int midIndex = maxIndex / 2;

        while (midIndex >= 0 && midIndex < array.getLength()) {
            if (value > array.getElement(midIndex).getAsInt()) {
                minIndex = midIndex;
                midIndex = maxIndex - ((maxIndex - midIndex) / 2);
            } else if (value < array.getElement(midIndex).getAsInt()) {
                maxIndex = midIndex;
                midIndex = (midIndex == 0) ? -1 : minIndex + ((midIndex - minIndex) / 2);
            } else {
                return midIndex;
            }
        }

        return -1;
    }

    public int maxElement(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid array data for find Max element");
        }

        int arrayLength = array.getLength();
        int max = array.getElement(0).getAsInt();

        for (int i = 0; i < arrayLength; i++) {
            if (max < array.getElement(i).getAsInt()) {
                max = array.getElement(i).getAsInt();
            }
        }

        return max;
    }

    public int minElement(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid array data for find Min element");
        }

        int arrayLength = array.getLength();
        int min = array.getElement(0).getAsInt();

        for (int i = 0; i < arrayLength; i++) {
            if (min > array.getElement(i).getAsInt()) {
                min = array.getElement(i).getAsInt();
            }
        }

        return min;
    }

    public ArithmeticArray primeNumbers(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid array data for find Prime numbers");
        }

        int arrayLength = array.getLength();
        int[] resultArray = new int[arrayLength];
        int resultArrayIndex = 0;
        ArithmeticArray primeNumbers;

        for (int i = 0; i < arrayLength; i++) {
            int countDivisions = 0;

            for (int primeDivider : PRIME_DIVIDERS) {
                if (array.getElement(i).getAsInt() > 0) {
                    if (array.getElement(i).getAsInt() % primeDivider != 0 ||
                            array.getElement(i).getAsInt() == primeDivider) {
                        countDivisions++;
                    }
                }
            }

            if (countDivisions == PRIME_DIVIDERS.length) {
                resultArray[resultArrayIndex] = array.getElement(i).getAsInt();
                resultArrayIndex++;
            }
        }

        primeNumbers = new ArithmeticArray(resultArrayIndex);

        for (int i = 0; i < resultArrayIndex; i++) {
            primeNumbers.setElement(resultArray[i], i);
        }

        return primeNumbers;
    }

    public ArithmeticArray searchFibonacci(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid array data for find Fibonacci numbers");
        }

        int arrayLength = array.getLength();
        int[] resultArray = new int[arrayLength];
        int resultArrayIndex = 0;
        ArithmeticArray fibonacciNumbers;

        for (int i = 0; i < arrayLength; i++) {
            int nextNumber = 1;
            int previousNumber = 0;
            int sum;

            if (array.getElement(i).getAsInt() == 0 || array.getElement(i).getAsInt() == 1) {
                resultArray[resultArrayIndex] = array.getElement(i).getAsInt();
                resultArrayIndex++;
            }

            while (nextNumber < array.getElement(i).getAsInt()) {
                sum = previousNumber + nextNumber;
                previousNumber = nextNumber;
                nextNumber = sum;
                if (sum == array.getElement(i).getAsInt()) {
                    resultArray[resultArrayIndex] = array.getElement(i).getAsInt();
                    resultArrayIndex++;
                }
            }
        }

        fibonacciNumbers = new ArithmeticArray(resultArrayIndex);

        for (int i = 0; i < resultArrayIndex; i++) {
            fibonacciNumbers.setElement(resultArray[i], i);
        }

        return fibonacciNumbers;
    }

    public ArithmeticArray searchThreeFigures(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() == 0) {
            throw new InvalidArrayDataException("Invalid array data for find Three figures numbers");
        }

        int arrayLength = array.getLength();
        int[] resultArray = new int[arrayLength];
        int resultArrayIndex = 0;
        ArithmeticArray threeFiguresNumbers;

        for (int i = 0; i < arrayLength; i++) {
            String stringNumber = String.valueOf(Math.abs(array.getElement(i).getAsInt()));

            if (stringNumber.length() == 3) {
                char[] numbers = stringNumber.toCharArray();
                if (numbers[0] != numbers[1] && numbers[1] != numbers[2] && numbers[0] != numbers[2]) {
                    resultArray[resultArrayIndex] = array.getElement(i).getAsInt();
                    resultArrayIndex++;
                }
            }
        }

        threeFiguresNumbers = new ArithmeticArray(resultArrayIndex);

        for (int i = 0; i < resultArrayIndex; i++) {
            threeFiguresNumbers.setElement(resultArray[i], i);
        }

        return threeFiguresNumbers;
    }
}
