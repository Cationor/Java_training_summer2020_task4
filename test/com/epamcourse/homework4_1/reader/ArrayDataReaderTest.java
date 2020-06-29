package test.balashevich.arrayapp.reader;

import com.epamcourse.homework4_1.exception.InvalidArrayDataException;
import com.epamcourse.homework4_1.reader.ArrayDataReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayDataReaderTest {
    ArrayDataReader arrayDataReader;

    @BeforeTest
    public void setUp() {
        arrayDataReader = new ArrayDataReader();
    }

    @DataProvider(name = "readFileData")
    public Object[][] createReadFileData() {
        String filename1 = "input/testData.txt";
        List<String> fileData1 = new ArrayList<>();
        fileData1.add("Arithmetic Array:[124, 135, 51343, 5345, 346]");
        fileData1.add("Arithmetic Array:[-1585752552, 620979146, 840552184, -854500731]");
        fileData1.add("Arithmetic Array:[]");
        fileData1.add("Arithmetic Array:[1]");
        fileData1.add("Arithmetic Array:[123g, 153]");
        fileData1.add("Arithmetic Array:[, 153]");
        fileData1.add("Arithmetic Array:[1, 2, 3, 4]");
        fileData1.add("Arithmetic Array:[-1, -2, -3, -4]");
        fileData1.add("Arithmetic Array:[0, 0, 0, 0]");

        String filename2 = "input/wrongFilenameData.txt";
        List<String> fileData2 = new ArrayList<>();
        fileData2.add("Arithmetic Array:[23526326, 3, 5, 12340, 461, -2347, 28657, 4, 2457, 9227465, 952]");
        fileData2.add("Arithmetic Array:[599, 2671, -23517, 952, 773, 3, 5235, 100]");
        return new Object[][]{
                {filename1, fileData1},
                {filename2, fileData2}
        };
    }

    @Test(dataProvider = "readFileData")
    public void readFileDataTest(String filename, List<String> expected) {
        List<String> actual = arrayDataReader.readFileData(filename);
        assertEquals(actual, expected);
    }

    @Test
    public void readConsoleDataTest() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("5").append('\n');
            sb.append("1").append('\n');
            sb.append("2").append('\n');
            sb.append("3").append('\n');
            sb.append("4").append('\n');
            sb.append("5").append('\n');
            InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
            InputStream defaultInputStream = System.in;
            System.setIn(inputStream);

            String expected = "Arithmetic Array:[1, 2, 3, 4, 5]";
            String actual = arrayDataReader.readConsoleData();
            assertEquals(actual, expected);

            System.setIn(defaultInputStream);
            inputStream.close();
        } catch (InvalidArrayDataException | IOException e) {
            fail("Exception occurred");
        }
    }
}