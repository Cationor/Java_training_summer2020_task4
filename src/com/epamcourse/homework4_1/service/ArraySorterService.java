package com.epamcourse.homework4_1.service;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.exception.InvalidArrayDataException;

public class ArraySorterService {

    public void bubbleSort(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() < 2) {
            throw new InvalidArrayDataException("Invalid array data for Bubble sorting");
        }

        int arrayLength = array.getLength();

        for (int i = arrayLength - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array.getElement(j).getAsInt() > array.getElement(j + 1).getAsInt()) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void selectionSort(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() < 2) {
            throw new InvalidArrayDataException("Invalid array data for Select sorting");
        }

        int arrayLength = array.getLength();

        for (int i = 0; i < arrayLength; i++) {
            int minValue = array.getElement(i).getAsInt();
            int minIndex = i;

            for (int j = i + 1; j < arrayLength; j++) {
                if (minValue > array.getElement(j).getAsInt()) {
                    minValue = array.getElement(j).getAsInt();
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public void insertionSort(ArithmeticArray array) throws InvalidArrayDataException {
        if (array.getLength() < 2) {
            throw new InvalidArrayDataException("Invalid array data for Insertion sorting");
        }

        int arrayLength = array.getLength();

        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j >= 1; j--) {
                if (array.getElement(j).getAsInt() < array.getElement(j - 1).getAsInt()) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(ArithmeticArray array, int first, int second) throws InvalidArrayDataException {
        int buffer = array.getElement(first).getAsInt();
        array.setElement(array.getElement(second).getAsInt(), first);
        array.setElement(buffer, second);
    }
}
