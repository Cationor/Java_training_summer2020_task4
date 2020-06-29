package test.balashevich.jaggedarray.validator;

import com.epamcourse.homework4_2.validator.ArrayValidator;
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

    @DataProvider(name = "jaggedArrayData")
    public Object[][] createJaggedArrayData() {
        int[][] nullElement = new int[2][];
        nullElement[0] = new int[4];
        nullElement[1] = null;
        int[][] zeroLengthElement = new int[2][];
        zeroLengthElement[0] = new int[0];
        zeroLengthElement[1] = new int[5];
        return new Object[][]{
                {null, false},
                {new int[1][], false},
                {nullElement, false},
                {zeroLengthElement, false},
        };
    }

    @Test(dataProvider = "jaggedArrayData")
    public void testValidateJaggedArray(int[][] array, boolean expected) {
        boolean actual = arrayValidator.validateJaggedArray(array);
        assertEquals(actual, expected);
    }
}