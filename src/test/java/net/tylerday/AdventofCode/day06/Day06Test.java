package net.tylerday.AdventofCode.day06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day06Test {

    @Test
    void partOne() {
        List<String> testData = new ArrayList<>(List.of(
                "mjqjpqmgbljsphdztnvjfqwrcgsmlb",
                "bvwbjplbgvbhsrlpgdmjqwftvncz",
                "nppdvjthqldpwncqszvftbrmjlhg",
                "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
                "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
        ));
        int[] testAnswers = {7, 5, 6, 10, 11};

        for (int i = 0; i < testData.size(); i++) {
            assertEquals(testAnswers[i], Day06.partOne(testData.get(i), 4));
        }
    }

    @Test
    void partTwo() {
        List<String> testData = new ArrayList<>(List.of(
                "mjqjpqmgbljsphdztnvjfqwrcgsmlb",
                "bvwbjplbgvbhsrlpgdmjqwftvncz",
                "nppdvjthqldpwncqszvftbrmjlhg",
                "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",
                "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"
        ));
        int[] testAnswers = {19, 23, 23, 29, 26};

        for (int i = 0; i < testData.size(); i++) {
            assertEquals(testAnswers[i], Day06.partOne(testData.get(i), 14));
        }
    }
}