package test.balashevich.arrayapp.parser;

import com.epamcourse.homework4_1.entity.ArithmeticArray;
import com.epamcourse.homework4_1.parser.ArrayDataParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class ArrayDataParserTest {
    ArrayDataParser arrayDataParser;

    @BeforeTest
    public void setUp() {
        arrayDataParser = new ArrayDataParser();
    }

    @DataProvider(name = "parseDataPositive")
    public Object[][] createParseDataPositive() {
        String arrayData1 = "Arithmetic Array:[1, 0, -5, 198263, 0, 15]";
        Optional<ArithmeticArray> array1 = Optional.of(new ArithmeticArray(new int[]{1, 0, -5, 198263, 0, 15}));
        String arrayData2 = "Arithmetic Array:[]";
        Optional<ArithmeticArray> array2 = Optional.of(new ArithmeticArray(new int[0]));
        String arrayData3 = "Array";
        Optional<ArithmeticArray> array3 = Optional.empty();
        return new Object[][]{
                {arrayData1, array1},
                {arrayData2, array2},
                {arrayData3, array3}
        };
    }

    @Test(dataProvider = "parseDataPositive")
    public void parseArrayDataTestPositive(String arrayData, Optional<ArithmeticArray> expected) {
        Optional<ArithmeticArray> actual = arrayDataParser.parseArrayData(arrayData);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "parseDataNegative")
    public Object[][] createParseDataNegative() {
        String arrayData1 = "Arithmetic Array:[1, 0, -5, -198263, 0, -15]";
        Optional<ArithmeticArray> array1 = Optional.of(new ArithmeticArray(new int[]{1, 0, 5, 198263, 0, 15}));
        String arrayData2 = "Arithmetic Array:[]";
        Optional<ArithmeticArray> array2 = Optional.empty();
        String arrayData3 = "Array";
        Optional<ArithmeticArray> array3 = Optional.of(new ArithmeticArray(new int[0]));
        return new Object[][]{
                {arrayData1, array1},
                {arrayData2, array2},
                {arrayData3, array3}
        };
    }

    @Test(dataProvider = "parseDataNegative")
    public void parseArrayDataTestNegative(String arrayData, Optional<ArithmeticArray> expected) {
        Optional<ArithmeticArray> actual = arrayDataParser.parseArrayData(arrayData);
        assertNotEquals(actual, expected);
    }
}