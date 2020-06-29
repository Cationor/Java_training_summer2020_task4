package test.balashevich.arrayapp.service;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.exception.InvalidArrayDataException;
import com.epamcourse.homework4_1.service.ArraySearcherService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySearcherServiceTest {
    ArraySearcherService arraySearcherService;

    @BeforeTest
    public void setUp() {
        arraySearcherService = new ArraySearcherService();
    }

    @DataProvider(name = "binaryDataPositive")
    public Object[][] createBinaryDataPositive() {
        return new Object[][]{
                {new ArithmeticArray(new int[]{-5, -4, 0, 2, 8, 10}), 8, 4},
                {new ArithmeticArray(new int[]{-5, -4, 0, 2, 8, 10}), 15, -1}
        };
    }

    @Test(dataProvider = "binaryDataPositive")
    public void binarySearchTestPositive(ArithmeticArray array, int searchingValue, int expected) {
        try {
            int actual = arraySearcherService.binarySearch(array, searchingValue);
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @DataProvider(name = "binaryDataNegative")
    public Object[][] createBinaryDataNegative() {
        return new Object[][]{
                {new ArithmeticArray(new int[]{-3, -2, -1, 0, 3, 5, 8}), 0, 4},
                {new ArithmeticArray(new int[]{-15, -4, 0, 2, 8, 10}), 15, 0}
        };
    }

    @Test(dataProvider = "binaryDataNegative")
    public void binarySearchTestNegative(ArithmeticArray array, int searchingValue, int expected) {
        try {
            int actual = arraySearcherService.binarySearch(array, searchingValue);
            assertNotEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void binarySearchTestException() throws InvalidArrayDataException {
        arraySearcherService.binarySearch(new ArithmeticArray(new int[]{5, 3, -10, 8, 9}), 3);
    }

    @Test
    public void maxElementTestPositive() {
        try {
            int actual = arraySearcherService.maxElement(new ArithmeticArray(new int[]{-29323, 0, 0, 1, 1232, 98989}));
            int expected = 98989;
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void maxElementTestNegative() {
        try {
            int actual = arraySearcherService.maxElement(new ArithmeticArray(new int[]{-29323, 0, 0, 1, 1232, 98989}));
            int expected = Integer.MAX_VALUE;
            assertNotEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void maxElementTestException() throws InvalidArrayDataException {
        arraySearcherService.maxElement(new ArithmeticArray(new int[0]));
    }

    @Test
    public void minElementTestPositive() {
        try {
            int actual = arraySearcherService.minElement(new ArithmeticArray(new int[]{-5, 1917, 30, -9, 1989}));
            int expected = -9;
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test
    public void minElementTestNegative() {
        try {
            int actual = arraySearcherService.minElement(new ArithmeticArray(new int[]{-5, 1917, 0, 30, -9, 1989}));
            int expected = 0;
            assertNotEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void minElementTestException() throws InvalidArrayDataException {
        arraySearcherService.minElement(new ArithmeticArray(new int[0]));
    }

    @DataProvider(name = "primeNumbersDataPositive")
    public Object[][] createPrimeNumbersDataPositive() {
        ArithmeticArray arrayToSearch1 = new ArithmeticArray(new int[]{6967, -6967, 2020, 701, 2, 8, 229, 146, 3315});
        ArithmeticArray primeNumbers1 = new ArithmeticArray(new int[]{6967, 701, 2, 229});
        ArithmeticArray arrayToSearch2 = new ArithmeticArray(new int[]{1988, 5967, 7217});
        ArithmeticArray primeNumbers2 = new ArithmeticArray(new int[0]);
        ArithmeticArray arrayToSearch3 = new ArithmeticArray(new int[]{9973});
        ArithmeticArray primeNumbers3 = new ArithmeticArray(new int[]{9973});
        return new Object[][]{
                {arrayToSearch1, primeNumbers1},
                {arrayToSearch2, primeNumbers2},
                {arrayToSearch3, primeNumbers3},
        };
    }

    @Test(dataProvider = "primeNumbersDataPositive")
    public void primeNumbersTestPositive(ArithmeticArray array, ArithmeticArray expected) {
        try {
            ArithmeticArray actual = arraySearcherService.primeNumbers(array);
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @DataProvider(name = "primeNumbersDataNegative")
    public Object[][] createPrimeNumbersDataNegative() {
        ArithmeticArray arrayToSearch1 = new ArithmeticArray(new int[]{0, 2, 1});
        ArithmeticArray primeNumbers1 = new ArithmeticArray(new int[]{0, 1});
        ArithmeticArray arrayToSearch2 = new ArithmeticArray(new int[]{739, 571, 107});
        ArithmeticArray primeNumbers2 = new ArithmeticArray(new int[]{107, 571, 739});
        ArithmeticArray arrayToSearch3 = new ArithmeticArray(new int[]{9974});
        ArithmeticArray primeNumbers3 = new ArithmeticArray(new int[]{9974});
        return new Object[][]{
                {arrayToSearch1, primeNumbers1},
                {arrayToSearch2, primeNumbers2},
                {arrayToSearch3, primeNumbers3},
        };
    }

    @Test(dataProvider = "primeNumbersDataNegative")
    public void primeNumbersTestNegative(ArithmeticArray array, ArithmeticArray expected) {
        try {
            ArithmeticArray actual = arraySearcherService.primeNumbers(array);
            assertNotEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void primeNumbersTestException() throws InvalidArrayDataException {
        arraySearcherService.primeNumbers(new ArithmeticArray(new int[0]));
    }

    @DataProvider(name = "fibonacciDataPositive")
    public Object[][] createFibonacciDataPositive() {
        ArithmeticArray arrayToSearch1 = new ArithmeticArray(new int[]{0, 1, 2020346, 2, 1, Integer.MAX_VALUE, 106244, 28657});
        ArithmeticArray fibonacciNumbers1 = new ArithmeticArray(new int[]{0, 1, 2, 1, Integer.MAX_VALUE, 28657});
        ArithmeticArray arrayToSearch2 = new ArithmeticArray(new int[]{739, 571, 107});
        ArithmeticArray fibonacciNumbers2 = new ArithmeticArray(new int[0]);
        return new Object[][]{
                {arrayToSearch1, fibonacciNumbers1},
                {arrayToSearch2, fibonacciNumbers2}
        };
    }

    @Test(dataProvider = "fibonacciDataPositive")
    public void searchFibonacciTestPositive(ArithmeticArray array, ArithmeticArray expected) {
        try {
            ArithmeticArray actual = arraySearcherService.searchFibonacci(array);
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e) {
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void searchFibonacciException() throws InvalidArrayDataException {
        arraySearcherService.searchFibonacci(new ArithmeticArray(new int[0]));
    }

    @DataProvider(name = "threeFiguresDataPositive")
    public Object[][] createThreeFiguresDataPositive() {
        ArithmeticArray arrayToSearch1 = new ArithmeticArray(new int[]{0, -5, 123, 444, 989, 987, 7654, -345});
        ArithmeticArray threeFiguresNumbers1 = new ArithmeticArray(new int[]{123, 987, -345});
        ArithmeticArray arrayToSearch2 = new ArithmeticArray(new int[]{777, 888, 33});
        ArithmeticArray threeFiguresNumbers2 = new ArithmeticArray(new int[0]);
        return new Object[][]{
                {arrayToSearch1, threeFiguresNumbers1},
                {arrayToSearch2, threeFiguresNumbers2}
        };
    }

    @Test (dataProvider = "threeFiguresDataPositive")
    public void searchThreeFiguresTestPositive(ArithmeticArray array, ArithmeticArray expected) {
        try {
            ArithmeticArray actual = arraySearcherService.searchThreeFigures(array);
            assertEquals(actual, expected);
        } catch (InvalidArrayDataException e){
            fail("Exception occurred");
        }
    }

    @DataProvider(name = "threeFiguresDataNegative")
    public Object[][] createThreeFiguresDataNegative() {
        ArithmeticArray arrayToSearch1 = new ArithmeticArray(new int[]{444, 9878, 343, 0});
        ArithmeticArray threeFiguresNumbers1 = new ArithmeticArray(new int[]{444, 9878, 343, 0});
        ArithmeticArray arrayToSearch2 = new ArithmeticArray(new int[]{777});
        ArithmeticArray threeFiguresNumbers2 = new ArithmeticArray(new int[]{777});
        return new Object[][]{
                {arrayToSearch1, threeFiguresNumbers1},
                {arrayToSearch2, threeFiguresNumbers2}
        };
    }

    @Test (dataProvider = "threeFiguresDataNegative")
    public void searchThreeFiguresTestNegative(ArithmeticArray array, ArithmeticArray expected) {
        try {
            ArithmeticArray actual = arraySearcherService.searchThreeFigures(array);
            assertNotEquals(actual, expected);
        } catch (InvalidArrayDataException e){
            fail("Exception occurred");
        }
    }

    @Test(expectedExceptions = InvalidArrayDataException.class)
    public void searchThreeFiguresException() throws InvalidArrayDataException {
        arraySearcherService.searchThreeFigures(new ArithmeticArray(new int[0]));
    }
}