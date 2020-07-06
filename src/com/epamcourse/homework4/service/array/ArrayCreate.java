package com.epamcourse.homework4.service.array;

import com.epamcourse.homework4.entity.IntArray;
import com.epamcourse.homework4.exception.InvalidException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class IntArrayCreateService {
    public IntArray IntArrayByConsole() throws InvalidException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter new array length");
        int newLength = scanner.nextInt();
        int[] array = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            System.out.println("enter value of element with index " + i);
            array[i] = scanner.nextInt();
        }

        return new IntArray(array);
    }

    public IntArray IntArrayByFile(Path path) throws InvalidException {
        try {
            int[] array = getArrayFromFile(path);
            return new IntArray(array);
        } catch (IOException ex) {
            throw new InvalidException("reading from file error");
        } catch (NumberFormatException ex) {
            throw new InvalidException("not a number in file");
        }
    }

    private int[] getArrayFromFile(Path path)
            throws IOException, NumberFormatException {
        Stream<String> lines = Files.lines(path);
        int[] fileArray = lines.mapToInt(Integer::parseInt).toArray();
        lines.close();

        return fileArray;
    }

    public IntArray IntArrayWithRandom(int newLength)
            throws InvalidException {
        int[] array = new int[newLength];
        try {
            Random generator = SecureRandom.getInstanceStrong();
            for (int i = 0; i < newLength; i++) {
                array[i] = generator.nextInt() % 30;
            }
        } catch (NoSuchAlgorithmException ignored) {
            throw new InvalidException("generator error");
        }

        return new IntArray(array);
    }
}
