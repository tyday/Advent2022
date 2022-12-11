package net.tylerday.AdventofCode.day11;

import net.tylerday.AdventofCode.helper.FileHelper;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day11Test {

    @Test
    void partOne() throws FileNotFoundException {
        List<String> data = FileHelper.getData("src/test/java/net/tylerday/AdventofCode/day11/test.txt");
        List<Monkey> monkeys = new ArrayList<>();

        for (int i = 0; i < data.size(); i+=6) {
            List<String> monkeyData = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                monkeyData.add(data.get(i + j));
            }
            monkeys.add(new Monkey(monkeyData));
        }
        System.out.println(monkeys);
    }
}