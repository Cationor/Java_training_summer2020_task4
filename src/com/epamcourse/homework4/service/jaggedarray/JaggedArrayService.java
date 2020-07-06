package com.epamcourse.homework4.service.jaggedarray;

import com.epamcourse.homework4.exception.InvalidException;

public class JaggedArrayService {
    public int[][] sort(int[][] array, Flag larger) throws InvalidException {
        if (array == null) {
            throw new InvalidException("Null array error");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (compare(array[i], array[j], larger)) {
                    int[] tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }

    private boolean compare(int[] firstArray, int[] secondArray,
                            Flag expression) throws InvalidException {
        int firstMark = expression.calculate(firstArray);
        int secondMark = expression.calculate(secondArray);

        return (firstMark > secondMark);
    }
}
