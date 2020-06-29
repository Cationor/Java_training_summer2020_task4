package com.epamcourse.homework4_1.entity;

import java.util.OptionalInt;

public class ArithmeticArray {
    private final int DEFAULT_CAPACITY = 10;

    private int[] array;

    public ArithmeticArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public ArithmeticArray(int capacity) {
        this.array = (capacity < 0) ? new int[DEFAULT_CAPACITY] : new int[capacity];
    }

    public ArithmeticArray(int[] array) {
        this.array = (array == null) ? new int[DEFAULT_CAPACITY] : array;
    }

    public OptionalInt getElement(int index) {
        if (index >= 0 && index < array.length) {
            return OptionalInt.of(array[index]);
        } else {
            return OptionalInt.empty();
        }
    }

    public boolean setElement(int number, int index) {
        if (index < 0 || index >= array.length) {
            return false;
        }

        array[index] = number;

        return true;
    }

    public int getLength() {
        return array.length;
    }

    public void setArray(int[] array) {
        this.array = (array == null) ? new int[DEFAULT_CAPACITY] : array;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = true;

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArithmeticArray arithmeticArray = (ArithmeticArray) o;
        if (array.length != arithmeticArray.array.length) {
            return false;
        }

        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != arithmeticArray.array[i]) {
                result = false;
            }
        }

        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;

        for (int element : array) {
            result = 17 * result + element;
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "Arithmetic Array:";
        if (array.length == 0) {
            return String.format("%s is Zero array", result);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        sb.append("[");

        for (int number : array) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.lastIndexOf(", "), sb.length());
        sb.append("]");

        return sb.toString();
    }
}
