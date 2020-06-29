package test.balashevich.arrayapp.validator;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.validator.ArrayValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {
    ArrayValidator arrayValidator;

    @BeforeTest
    public void setUp() {
        arrayValidator = new ArrayValidator();
    }

    @DataProvider(name = "arrayDataPositive")
    public Object[][] createArrayDataPositive() {
        return new Object[][]{
                {new ArithmeticArray(new int[1]), false},
                {new ArithmeticArray(new int[]{-1, 0, 2, 3, 4, 5}), true},
                {new ArithmeticArray(new int[]{-1, 0, 145, 3, 4, 5}), false},
        };
    }

    @Test(dataProvider = "arrayDataPositive")
    public void validateArrayBinarySearchTestPositive(ArithmeticArray arithmeticArray, boolean expected) {
        boolean actual = arrayValidator.validateArrayBinarySearch(arithmeticArray);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "arrayDataNegative")
    public Object[][] createArrayDataNegative() {
        return new Object[][]{
                {new ArithmeticArray(new int[0]), true},
                {new ArithmeticArray(new int[]{1, 2, 2, 3, 4, 5}), false},
                {new ArithmeticArray(new int[]{2, 1, 0, -1, -2, -3}), true},
        };
    }

    @Test(dataProvider = "arrayDataNegative")
    public void validateArrayBinarySearchTestNegative(ArithmeticArray arithmeticArray, boolean expected) {
        boolean actual = arrayValidator.validateArrayBinarySearch(arithmeticArray);
        assertNotEquals(actual, expected);
    }
}