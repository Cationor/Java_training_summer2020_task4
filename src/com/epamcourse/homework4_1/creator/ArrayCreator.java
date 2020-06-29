package com.epamcourse.homework4_1.creator;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.parser.ArrayDataParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayCreator {
    public static final int MAX_RANDOM_CAPACITY = 100;

    public ArithmeticArray createRandomArray() {
        int randomCapacity = (int) (Math.random() * MAX_RANDOM_CAPACITY);
        long valuesRange = Integer.MAX_VALUE * 2L;
        ArithmeticArray randomArray = new ArithmeticArray(randomCapacity);

        for (int i = 0; i < randomCapacity; i++) {
            int randomElement = (int) (Math.random() * valuesRange - Integer.MAX_VALUE);
            randomArray.setElement(randomElement, i);
        }

        return randomArray;
    }

    public List<ArithmeticArray> createArraysFromString(List<String> arrayData) {
        ArrayDataParser arrayDataParser = new ArrayDataParser();
        List<ArithmeticArray> arithmeticArrays = new ArrayList<>();

        for (String arrayElement : arrayData) {
            Optional<ArithmeticArray> array = arrayDataParser.parseArrayData(arrayElement);
            array.ifPresent(arithmeticArrays::add);
        }

        return arithmeticArrays;
    }

}
