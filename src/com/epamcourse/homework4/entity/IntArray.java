package com.epamcourse.homework4.entity;

import com.epamcourse.homework4.exception.InvalidException;


public class IntArray {
    private final int[] array;

    public IntArray(IntArray sourceArray) throws InvalidException {
        if (sourceArray == null) {
            throw new InvalidException("array is null");
        }
        this.array = new int[sourceArray.getLength()];
        for (int i = 0; i < sourceArray.getLength(); i++) {
            this.array[i] = sourceArray.getByIndex(i);
        }
    }

    public IntArray(int [] array) throws InvalidException {
        if (array == null) {
            throw new InvalidException("array is null");
        }
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public int getByIndex(int index) {
        return array[index];
    }

    public int getLength() {
        return array.length;
    }

    public IntArray getPartOfArray(int left, int right) throws InvalidException {
        int[] newArray = new int[right - left + 1];
        for (int i = left; i < right + 1; i++) {
            newArray[i - left] = array[i];
        }

        return new IntArray(newArray);
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public void setElementByIndex(int data, int index) {
        if ((index < 0) || (index >= array.length)) {
            return;
        }

        array[index] = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntArray)) {
            return false;
        }

        IntArray array1 = (IntArray) o;
        if (array1.getLength() != this.getLength()) {
            return false;
        }

        int mark = 0;
        for (int i = 0; i < this.getLength(); i++) {
            mark += (array1.getByIndex(i) == this.getByIndex(i)) ? 0 : 1;
        }

        return (mark == 0);
    }

    @Override
    public int hashCode() {
        int prime = 52;
        int hash = 1;
        for (int elem : array) {
            hash += (prime * hash) + elem;
        }

        return hash;
    }
}
