package mishamba.day4.service.task1;

import com.epamcourse.homework4.entity.CustomArray;
import com.epamcourse.homework4.exception.ProgramException;
import com.epamcourse.homework4.service.task1.CustomArrayCreateService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class CustomArrayCreateServiceTest {

    @Contract(" -> new")
    @DataProvider(name = "files are correct")
    private Object[] @NotNull [] validFiles() throws ProgramException {
        return new Object[][] {
                {Paths.get("valid_data/test"),
                        new CustomArray(new int[] {234, 1234, 653, 12324, 53, 134, 134})},
                {Paths.get("valid_data/test2"),
                        new CustomArray(new int[] {123, 42, 7654, 1345, 643, 234, 355})},
                {Paths.get("valid_data/test3"),
                        new CustomArray(new int[] {})},

        };
    }

    @Test(dataProvider = "files are correct")
    public void customArrayByFile_valid(Path filePath, CustomArray expectedArray) {
        CustomArrayCreateService service = new CustomArrayCreateService();
        try {
            CustomArray actualArray = service.customArrayByFile(filePath);
            assertEquals(actualArray, expectedArray);
        } catch (ProgramException ex) {
            fail("got exception");
        }
    }

    @Contract(" -> new")
    @DataProvider(name = "not existing or incorrect files")
    private Object[] @NotNull [] invalidFiles() {
        return new Object[][] {
                {"invalid_data/test"},
                {"invalid_data/test2"},
                {"invalid_data/test3"}
        };
    }

    @Test(dataProvider = "not existing or incorrect files",
            expectedExceptions = ProgramException.class)
    public void customArraybyFiles_invalid(String filePath)
            throws ProgramException {
        Path file = Paths.get(filePath);
        CustomArrayCreateService service = new CustomArrayCreateService();
        service.customArrayByFile(file);
    }
}