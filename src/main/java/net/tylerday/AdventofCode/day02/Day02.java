package net.tylerday.AdventofCode.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day02 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:\\LocalProgramming\\Advent2022\\src\\main\\java\\net\\tylerday\\AdventofCode\\day02\\input.txt");
        Scanner sc = new Scanner(file);

        List<String> colLeft = new ArrayList<>();
        List<String> colRight = new ArrayList<>();

        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] data = line.split(" ");
            colLeft.add(data[0]);
            colRight.add(data[1]);
        }
        int firstPartScore = 0;
        for (int i = 0; i < colLeft.size(); i++) {
            String play = colLeft.get(i) + colRight.get(i);
            int round = Data.ptOneChoiceValue.get(colRight.get(i));
            round += Data.ptOnePlayValue.get(play);
            firstPartScore += round;
        }
        System.out.println("Part One: " + firstPartScore);

        int secondPartScore = 0;
        for (int i = 0; i < colLeft.size(); i++) {
            String play = colLeft.get(i) + colRight.get(i);
            String selection = Data.conversion.get(play);
            String completePlay = colLeft.get(i) + selection;

            int round = Data.ptOneChoiceValue.get(selection);
            round += Data.ptOnePlayValue.get(completePlay);
            secondPartScore += round;
        }

        System.out.println("Part Two: " + secondPartScore);
    }

    private static int score(String left, String right) {
        return 0;
    }
}

class Data{
    static final HashMap<String, Integer> ptOneChoiceValue;
    static final HashMap<String, Integer> ptOnePlayValue;
    static final HashMap<String, String> conversion;
    static {
        ptOneChoiceValue = new HashMap<>(){{
            put("X", 1);
            put("Y", 2);
            put("Z", 3);
        }};
        ptOnePlayValue = new HashMap<>(){{
            put("AX", 3);
            put("AY", 6);
            put("AZ", 0);
            put("BX", 0);
            put("BY", 3);
            put("BZ", 6);
            put("CX", 6);
            put("CY", 0);
            put("CZ", 3);
        }};

        conversion = new HashMap<>(){{
            put("AX", "Z");
            put("AY", "X");
            put("AZ", "Y");
            put("BX", "X");
            put("BY", "Y");
            put("BZ", "Z");
            put("CX", "Y");
            put("CY", "Z");
            put("CZ", "X");
        }};
    }

}