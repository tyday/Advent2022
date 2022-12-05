package net.tylerday.AdventofCode.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04 {

    public static void main(String[] args) throws FileNotFoundException {
        Day04 day04 = new Day04("src/main/java/net/tylerday/AdventofCode/day04/input.txt");
        day04.data.forEach(line -> day04.pairs.add(new SupplyPair(line)));

        int partOneCountOfFullyContained = 0;
        int partTwoCountOfPartiallyContained = 0;
        for (SupplyPair pair:
             day04.pairs) {
            if (pair.doPairsCompletelyOverlap()){
                partOneCountOfFullyContained ++;
            }
            if(pair.doPairsPartiallyOverlap()){
                partTwoCountOfPartiallyContained ++;
            }
        }

        System.out.println("Part one: " + partOneCountOfFullyContained);
        System.out.println("Part two: " + partTwoCountOfPartiallyContained);
    }

    List<String> data;
    List<SupplyPair> pairs = new ArrayList<>();

    public Day04() {
    }

    public Day04(String filename) throws FileNotFoundException {
        this.data = this.getData(filename);

    }

    List<String> getData(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        List<String> data = new ArrayList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(!"".equals(line)){
                data.add(line);
            }
        }
        return data;
    }
}

