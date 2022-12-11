package net.tylerday.AdventofCode.day11;

import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day11 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Day 11");
//        List<String> data = FileHelper.getData("src/test/java/net/tylerday/AdventofCode/day11/test.txt");
        List<String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day11/input.txt");
        partOne(data);

        partTwo(data);
    }

    public static void partOne(List<String> data) {

        List<Monkey> monkeys = new ArrayList<>();

        for (int i = 0; i < data.size(); i+=6) {
            List<String> monkeyData = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                monkeyData.add(data.get(i + j));
            }
            monkeys.add(new Monkey(monkeyData));
        }
        System.out.println(monkeys);

        for (int round = 1; round <= 20; round++) {
            for (Monkey monkey :
                    monkeys) {
                monkey.doRound(monkeys, true);
            }
        }
        int total = 0;
        List<Integer> inspections = new ArrayList<>();
        for (Monkey monkey :
                monkeys) {
            System.out.println("Monkey: " + monkey.number + " inspections: " + monkey.inspections);
            inspections.add(monkey.inspections);
        }
        inspections = inspections.stream().sorted().collect(Collectors.toList());
        Collections.reverse(inspections);
        System.out.println(inspections);
        System.out.println(inspections.get(0) * inspections.get(1));
    }

    public static void partTwo(List<String> data) {

        List<Monkey> monkeys = new ArrayList<>();

        for (int i = 0; i < data.size(); i+=6) {
            List<String> monkeyData = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                monkeyData.add(data.get(i + j));
            }
            monkeys.add(new Monkey(monkeyData));
        }
        System.out.println(monkeys);

        for (int round = 1; round <= 10000; round++) {
            for (Monkey monkey :
                    monkeys) {
                monkey.doRound(monkeys, false);
            }
        }

        List<Integer> inspections = new ArrayList<>();
        for (Monkey monkey :
                monkeys) {
            System.out.println("Monkey: " + monkey.number + " inspections: " + monkey.inspections);
            inspections.add(monkey.inspections);
        }
        inspections = inspections.stream().sorted().collect(Collectors.toList());
        Collections.reverse(inspections);
        System.out.println(inspections);
        System.out.println(inspections.get(0) * inspections.get(1));
    }
}
