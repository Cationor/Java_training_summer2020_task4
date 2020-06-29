package test.balashevich.arrayapp.service;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.exception.InvalidArrayDataException;
import com.epamcourse.homework4_1.service.ArraySorterService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySorterServiceTest {
    ArraySorterService arraySorterService;
    ArithmeticArray unsortedArray;
    ArithmeticArray sortedArrayPositive;
    ArithmeticArray sortedArrayNegative;
    ArithmeticArray unsortedArrayException;

    int[] unsorted;
    int[] sortedPositive;
    int[] sortedNegative;
    int[] unsortedException;

    @BeforeTest
    public void setUp() {
        arraySorterService = new ArraySorterService();

        unsorted = new int[]{2452, 0, -1, 1, Integer.MAX_VALUE, 931, -412, Integer.MIN_VALUE};
        unsortedArray = new ArithmeticArray(unsorted);

        sortedPositive = new int[]{Integer.MIN_VALUE, -412, -1, 0, 1, 931, 2452, Integer.MAX_VALUE};
        sortedArrayPositive = new ArithmeticArray(sortedPositive);

        sortedNegative = new int[]{Integer.MAX_VALUE, 2452, 931, 1, 0, -1, -412, Integer.MIN_VALUE};
        sortedArrayNegative = new ArithmeticArray(sortedNegative);

        unsortedException = new int[]{1};
        unsortedArrayException = new ArithmeticArray(unsorted);
    }

    @BeforeMethod
    public void setUnsortedArrayValues() {
        unsortedArray.setArray(unsorted);
        unsortedArrayException.setArray(unsortedException);
    }

    @Test
    public void bubbleSortTestPositive() {
        try {
            arraySorterService.bubbleSort(unsortedArray);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }

        assertEquals(unsortedArray, sortedArrayPositive);
    }

    @Test
    public void bubbleSortTestNegative() {
        try {
            arraySorterService.bubbleSort(unsortedArray);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }

        assertNotEquals(unsortedArray, sortedArrayNegative);
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void bubbleSortTestException() throws InvalidArrayDataException {
        arraySorterService.bubbleSort(unsortedArrayException);
    }

    @Test
    public void selectionSortTestPositive() {
        try {
            arraySorterService.selectionSort(unsortedArray);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }

        assertEquals(unsortedArray, sortedArrayPositive);
    }

    @Test
    public void selectionSortTestNegative() {
        try {
            arraySorterService.selectionSort(unsortedArray);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }

        assertNotEquals(unsortedArray, sortedArrayNegative);
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void selectionSortTestException() throws InvalidArrayDataException {
        arraySorterService.insertionSort(unsortedArrayException);
    }

    @Test
    public void insertionSortTestPositive() {
        try {
            arraySorterService.insertionSort(unsortedArray);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }

        assertEquals(unsortedArray, sortedArrayPositive);
    }

    @Test
    public void insertionSortTestNegative() {
        try {
            arraySorterService.insertionSort(unsortedArray);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }

        assertNotEquals(unsortedArray, sortedArrayNegative);
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void insertionSortTestException() throws InvalidArrayDataException {
        arraySorterService.insertionSort(unsortedArrayException);
    }
}