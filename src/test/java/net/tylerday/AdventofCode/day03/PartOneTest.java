package net.tylerday.AdventofCode.day03;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartOneTest {
    private PartOne partOne;

    @Test
    public void constructorTest() throws FileNotFoundException {
        File file = new File("src/test/java/net/tylerday/AdventofCode/day03/test.txt");
        partOne = new PartOne(file);

        List<Rucksack> rucksackList = new ArrayList<>();
        rucksackList.add(new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp"));
        rucksackList.add(new Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"));
        rucksackList.add(new Rucksack("PmmdzqPrVvPwwTWBwg"));
        rucksackList.add(new Rucksack("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"));
        rucksackList.add(new Rucksack("ttgJtRGJQctTZtZT"));
        rucksackList.add(new Rucksack("CrZsJsPPZsGzwwsLwLmpwMDw"));

        for (int i = 0; i < partOne.rucksackList.size(); i++) {
            assertEquals(rucksackList.get(i), partOne.rucksackList.get(i));
        }
    }

    @Test
    void partOneTotal() throws FileNotFoundException {
        File file = new File("src/test/java/net/tylerday/AdventofCode/day03/test.txt");
        partOne = new PartOne(file);

        assertEquals(157, partOne.partOneTotal());
    }

    @Test
    void getBadge() throws FileNotFoundException {
        File file = new File("src/test/java/net/tylerday/AdventofCode/day03/test.txt");
        partOne = new PartOne(file);

        char badge = partOne.getBadge(0);
        assertEquals(badge,'r');

        badge = partOne.getBadge(3);
        assertEquals(badge,'Z');
    }

    @Test
    void calculatePartTwo() throws FileNotFoundException {
        File file = new File("src/test/java/net/tylerday/AdventofCode/day03/test.txt");
        partOne = new PartOne(file);
        int answer = partOne.calculatePartTwo();
        assertEquals(70, answer);
    }
}