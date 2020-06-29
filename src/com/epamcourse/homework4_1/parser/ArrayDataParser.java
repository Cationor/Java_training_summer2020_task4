package com.epamcourse.homework4_1.parser;

import com.epamcourse.homework4_1.entity.ArithmeticArray;

import java.util.Optional;

public class ArrayDataParser {
    private static final String REGEX_FILLED_ARRAY = "Arithmetic Array:\\W(-?\\d+,\\s)*-?\\d*\\W";
    private static final String REGEX_SPLIT = "\\W\\s";

    public Optional<ArithmeticArray> parseArrayData(String arrayData) {
        ArithmeticArray array = null;

        if (arrayData.matches(REGEX_FILLED_ARRAY)) {
            int startIndex = arrayData.indexOf('[') + 1;
            int endIndex = arrayData.indexOf(']');
            String[] arrayElements = (endIndex - startIndex > 0) ?
                    arrayData.substring(startIndex, endIndex).split(REGEX_SPLIT) : new String[0];
            int[] parsedArray = new int[arrayElements.length];

            for (int i = 0; i < parsedArray.length; i++) {
                parsedArray[i] = Integer.parseInt(arrayElements[i]);
            }

            array = new ArithmeticArray(parsedArray);
        }

        return Optional.ofNullable(array);
    }
}
