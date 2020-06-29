package test.balashevich.jaggedarray.action;

import com.epamcourse.homework4_2.action.JaggedArraySorter;
import com.epamcourse.homework4_2.enumeration.SortDirection;
import com.epamcourse.homework4_2.enumeration.SortKey;
import com.epamcourse.homework4_2.exception.InvalidArrayDataException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArraySorterTest {
    JaggedArraySorter jaggedArraySorter;
    int[][] sortingArray;

    @BeforeTest
    public void setUp() {
        jaggedArraySorter = new JaggedArraySorter();
        sortingArray = new int[10][];
    }

    @BeforeMethod
    public void fillArray() {
        sortingArray[0] = new int[]{1, 2, 3, 5};
        sortingArray[1] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        sortingArray[2] = new int[5];
        sortingArray[3] = new int[]{2, 4, 8};
        sortingArray[4] = new int[]{0, -1, 1};
        sortingArray[5] = new int[]{-15, 15};
        sortingArray[6] = new int[]{18, 6, 3};
        sortingArray[7] = new int[]{0};
        sortingArray[8] = new int[]{1, 2, 3, 4, 5, 6, 7};
        sortingArray[9] = new int[]{9, 7, 3, -9, -4};
    }

    @Test
    public void bubbleSortIncreasingMinimumTest() {
        try {
            int[][] expected = new int[10][];
            expected[0] = new int[]{-15, 15};
            expected[1] = new int[]{9, 7, 3, -9, -4};
            expected[2] = new int[]{0, -1, 1};
            expected[3] = new int[5];
            expected[4] = new int[]{0};
            expected[5] = new int[]{1, 2, 3, 5};
            expected[6] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            expected[7] = new int[]{1, 2, 3, 4, 5, 6, 7};
            expected[8] = new int[]{2, 4, 8};
            expected[9] = new int[]{18, 6, 3};
            jaggedArraySorter.bubbleSort(sortingArray, SortDirection.INCREASING, SortKey.MINIMUM);
            assertTrue(arraysEquals(sortingArray, expected));
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void bubbleSortDecreasingMinimumTest() {
        try {
            int[][] expected = new int[10][];
            expected[0] = new int[]{18, 6, 3};
            expected[1] = new int[]{2, 4, 8};
            expected[2] = new int[]{1, 2, 3, 5};
            expected[3] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            expected[4] = new int[]{1, 2, 3, 4, 5, 6, 7};
            expected[5] = new int[5];
            expected[6] = new int[]{0};
            expected[7] = new int[]{0, -1, 1};
            expected[8] = new int[]{9, 7, 3, -9, -4};
            expected[9] = new int[]{-15, 15};
            jaggedArraySorter.bubbleSort(sortingArray, SortDirection.DECREASING, SortKey.MINIMUM);
            assertTrue(arraysEquals(sortingArray, expected));
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void bubbleSortIncreasingMaximumTest() {
        try {
            int[][] expected = new int[10][];
            expected[0] = new int[5];
            expected[1] = new int[]{0};
            expected[2] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            expected[3] = new int[]{0, -1, 1};
            expected[4] = new int[]{1, 2, 3, 5};
            expected[5] = new int[]{1, 2, 3, 4, 5, 6, 7};
            expected[6] = new int[]{2, 4, 8};
            expected[7] = new int[]{9, 7, 3, -9, -4};
            expected[8] = new int[]{-15, 15};
            expected[9] = new int[]{18, 6, 3};
            jaggedArraySorter.bubbleSort(sortingArray, SortDirection.INCREASING, SortKey.MAXIMUM);
            assertTrue(arraysEquals(sortingArray, expected));
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void bubbleSortDecreasingMaximumTest() {
        try {
            int[][] expected = new int[10][];
            expected[0] = new int[]{18, 6, 3};
            expected[1] = new int[]{-15, 15};
            expected[2] = new int[]{9, 7, 3, -9, -4};
            expected[3] = new int[]{2, 4, 8};
            expected[4] = new int[]{1, 2, 3, 4, 5, 6, 7};
            expected[5] = new int[]{1, 2, 3, 5};
            expected[6] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            expected[7] = new int[]{0, -1, 1};
            expected[8] = new int[5];
            expected[9] = new int[]{0};
            jaggedArraySorter.bubbleSort(sortingArray, SortDirection.DECREASING, SortKey.MAXIMUM);
            assertTrue(arraysEquals(sortingArray, expected));
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void bubbleSortIncreasingSumTest() {
        try {
            int[][] expected = new int[10][];
            expected[0] = new int[5];
            expected[1] = new int[]{0, -1, 1};
            expected[2] = new int[]{-15, 15};
            expected[3] = new int[]{0};
            expected[4] = new int[]{9, 7, 3, -9, -4};
            expected[5] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            expected[6] = new int[]{1, 2, 3, 5};
            expected[7] = new int[]{2, 4, 8};
            expected[8] = new int[]{18, 6, 3};
            expected[9] = new int[]{1, 2, 3, 4, 5, 6, 7};
            jaggedArraySorter.bubbleSort(sortingArray, SortDirection.INCREASING, SortKey.SUM);
            assertTrue(arraysEquals(sortingArray, expected));
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void bubbleSortDecreasingSumTest() {
        try {
            int[][] expected = new int[10][];
            expected[0] = new int[]{1, 2, 3, 4, 5, 6, 7};
            expected[1] = new int[]{18, 6, 3};
            expected[2] = new int[]{2, 4, 8};
            expected[3] = new int[]{1, 2, 3, 5};
            expected[4] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
            expected[5] = new int[]{9, 7, 3, -9, -4};
            expected[6] = new int[5];
            expected[7] = new int[]{0, -1, 1};
            expected[8] = new int[]{-15, 15};
            expected[9] = new int[]{0};
            jaggedArraySorter.bubbleSort(sortingArray, SortDirection.DECREASING, SortKey.SUM);
            assertTrue(arraysEquals(sortingArray, expected));
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void bubbleSortTestException() throws InvalidArrayDataException {
        jaggedArraySorter.bubbleSort(new int[1][], SortDirection.INCREASING, SortKey.MINIMUM);
    }

    private boolean arraysEquals(int[][] firstArray, int[][] secondArray) {
        if (firstArray == secondArray) {
            return true;
        }
        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i].length != secondArray[i].length) {
                return false;
            }
            for (int j = 0; j < firstArray[i].length; j++) {
                if (firstArray[i][j] != secondArray[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}