package net.tylerday.AdventofCode.day04;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day04Test {

    @Test
    void getDataTest() throws FileNotFoundException {
        List<String> testData = new ArrayList<>();
        testData.add("2-4,6-8");
        testData.add("2-3,4-5");
        testData.add("5-7,7-9");
        testData.add("2-8,3-7");
        testData.add("6-6,4-6");
        testData.add("2-6,4-8");

        Day04 day04 = new Day04();
        List<String> fileData = day04.getData("src/test/java/net/tylerday/AdventofCode/day04/test.txt");

        assertEquals(testData.size(), fileData.size());

        for (int i = 0; i < testData.size(); i++) {
            assertEquals(testData.get(i), fileData.get(i));
        }
    }
}