package com.epamcourse.homework4.service.array;

import com.epamcourse.homework4.entity.IntArray;
import com.epamcourse.homework4.exception.InvalidException;

public class IntArraySortService {
    public IntArray sortByQuicksort(IntArray array) throws InvalidException {
        IntArray IntArray = new IntArray(array);
        intervalQuicksort(0, array.getLength() - 1, IntArray);
        return IntArray;
    }

    private void intervalQuicksort(int left, int right, IntArray array) {
        int tmp;
        int i = left;
        int j = right;

        if (left > right) {
            return;
        }

        int mid = (right + left) / 2;

        while (i <= j) {
            while (array.getByIndex(i) < array.getByIndex(mid)) {
                i++;
            }

            while (array.getByIndex(j) > array.getByIndex(mid)) {
                j--;
            }

            if (i <= j) {
                tmp = array.getByIndex(i);
                array.setElementByIndex(array.getByIndex(j), i);
                array.setElementByIndex(tmp, j);
                i++;
                j--;
            }
        }

        mid = (i + j) / 2;

        if (left < j) {
            intervalQuicksort(mid + 1, right, array);
        }
        if (right > i) {
            intervalQuicksort(left, mid, array);
        }
    }

    public IntArray sortByMergeSort(IntArray array) throws InvalidException {
        IntArray sortedArray = new IntArray(array);
        return sort(sortedArray);
    }

    private IntArray sort(IntArray givenArray) throws InvalidException {
        if (givenArray.getLength() == 1) {
            return givenArray;
        }

        int middle = givenArray.getLength() / 2;

        IntArray leftArray = givenArray.getPartOfArray(0, middle - 1);
        IntArray rightArray = givenArray.getPartOfArray(middle,
                givenArray.getLength() - 1);

        leftArray = sort(leftArray);
        rightArray = sort(rightArray);

        return merge(leftArray, rightArray);
    }

    private IntArray merge(IntArray leftArray,
                              IntArray rightArray) throws InvalidException {
        int[] mergedArray = new int[leftArray.getLength() +
                rightArray.getLength()];
        int positionLeft = 0;
        int positionRight = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (positionRight == rightArray.getLength() ||
                    secureElementsCompare(
                            positionLeft, leftArray,
                            positionRight, rightArray)) {
                mergedArray[i] = leftArray.getByIndex(positionLeft);
                positionLeft++;
            } else {
                mergedArray[i] = rightArray.getByIndex(positionRight);
                positionRight++;
            }
        }

        return new IntArray(mergedArray);
    }

    private boolean secureElementsCompare(int leftIndex, IntArray leftArray,
                                          int rightIndex, IntArray rightArray) {
        boolean less = false;
        if ((leftArray.getLength() > leftIndex) &&
                (rightArray.getLength() > rightIndex)) {
            less = (leftArray.getByIndex(leftIndex) <
                    rightArray.getByIndex(rightIndex));
        }

        return less;
    }

    public IntArray sortByInsert(IntArray inputArray) throws InvalidException {
        IntArray array = new IntArray(inputArray);
        int key;
        for (int i = 1; i < array.getLength(); i++) {
            key = array.getByIndex(i);
            int j = i - 1;

            while (j >= 0 && key < array.getByIndex(j)) {
                int tmp = array.getByIndex(j);
                array.setElementByIndex(array.getByIndex(j + 1), j);
                array.setElementByIndex(tmp, j + 1);
                j--;
            }

            array.setElementByIndex(key, j + 1);
        }

        return array;
    }
}
