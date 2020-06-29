package test.balashevich.arrayapp.creator;

import com.epamcourse.homework4_1.creator.ArrayCreator;
import com.epamcourse.homework4_1.entity.ArithmeticArray;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayCreatorTest {
    ArrayCreator arrayCreator;

    @BeforeTest
    public void setUp() {
        arrayCreator = new ArrayCreator();
    }

    @Test
    public void createRandomArrayTestObjectPresent() {
        ArithmeticArray actual = arrayCreator.createRandomArray();
        assertNotNull(actual);
    }

    @Test
    public void createRandomArrayTestArrayPresent() {
        ArithmeticArray actual = arrayCreator.createRandomArray();
        if (actual == null) {
            fail("Error while object creating");
        }
        assertTrue(actual.getLength() >= 0 && actual.getLength() <= ArrayCreator.MAX_RANDOM_CAPACITY);
    }

    @DataProvider(name = "arraysFromStringData")
    public Object[][] createArraysFromStringData() {
        List<String> stringData = new ArrayList<>();
        stringData.add("Arithmetic Array:[124, 135, 51343, 5345, 346]");
        stringData.add("Arithmetic Array:[-1585752552, 620979146, 840552184, -854500731]");
        stringData.add("Arithmetic Array:[]");
        stringData.add("Arithmetic Array:[1]");
        stringData.add("Arithmetic Array:[123g, 153]");
        stringData.add("Arithmetic Array:[, 153]");
        stringData.add("Arithmetic Array:[1, 2, 3, 4]");
        stringData.add("Arithmetic Array:[-1, -2, -3, -4]");
        stringData.add("Arithmetic Array:[0, 0, 0, 0]");

        List<ArithmeticArray> arrays = new ArrayList<>();
        arrays.add(new ArithmeticArray(new int[]{124, 135, 51343, 5345, 346}));
        arrays.add(new ArithmeticArray(new int[]{-1585752552, 620979146, 840552184, -854500731}));
        arrays.add(new ArithmeticArray(new int[0]));
        arrays.add(new ArithmeticArray(new int[]{1}));
        arrays.add(new ArithmeticArray(new int[]{1, 2, 3, 4}));
        arrays.add(new ArithmeticArray(new int[]{-1, -2, -3, -4}));
        arrays.add(new ArithmeticArray(new int[]{0, 0, 0, 0}));
        return new Object[][]{
                {stringData, arrays}
        };
    }

    @Test(dataProvider = "arraysFromStringData")
    public void createArraysFromStringTest(List<String> stringArraysData, List<ArithmeticArray> expected) {
        List<ArithmeticArray> actual = arrayCreator.createArraysFromString(stringArraysData);
        assertEquals(actual, expected);
    }
}