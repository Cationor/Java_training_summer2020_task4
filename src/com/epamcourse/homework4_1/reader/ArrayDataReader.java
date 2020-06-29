package com.epamcourse.homework4_1.reader;

import com.epamcourse.homework4_1.exception.InvalidArrayDataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayDataReader {
    private static final String DEFAULT_PATH = "input/arrayData.txt";

    public List<String> readFileData(String filename) {
        Path path = Paths.get(DEFAULT_PATH);
        List<String> dataLines;

        if (filename != null) {
            if (Files.exists(Paths.get(filename))) {
                path = Paths.get(filename);
            }
        }

        try (Stream<String> lineStream = Files.lines(path)) {
            dataLines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file", e);
        }

        return dataLines;
    }

    public String readConsoleData() throws InvalidArrayDataException {
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter array capacity:");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int arrayCapacity = Integer.parseInt(reader.readLine());
            if (arrayCapacity >= 0) {
                System.out.println("Fill array");
                sb.append("Arithmetic Array:[");

                for (int i = 0; i < arrayCapacity; i++) {
                    sb.append(reader.readLine());
                    if (i < arrayCapacity - 1) {
                        sb.append(", ");
                    }
                }

                sb.append("]");
            }
        } catch (IOException e) {
            throw new InvalidArrayDataException("Error while read data from console");
        }

        return sb.toString();
    }
}
