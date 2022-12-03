package net.tylerday.AdventofCode.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/net/tylerday/AdventofCode/day03/input.txt");
        PartOne partOne = new PartOne(file);
        System.out.println("Part One");
        System.out.println(partOne.partOneTotal());
        System.out.println();
        System.out.println("Part Two");
        System.out.println(partOne.calculatePartTwo());

    }

}


class PartOne {
    List<Rucksack> rucksackList = new ArrayList<>();

    public PartOne(File file) throws FileNotFoundException {
        fillRucksackList(file);
    }

    private void fillRucksackList(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if("".equals(line)){
                break;
            }
            Rucksack rucksack = new Rucksack(line);
            rucksackList.add(rucksack);
        }
    }

    public int partOneTotal(){
        int total = 0;
        for (Rucksack r: rucksackList) {
            total += r.calculatePriority();
        }
        return total;
    }

    public char getBadge(int position){
        Set<Character> r1 = rucksackList.get(position).rucksackContents
                .chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());
        Set<Character> r2 = rucksackList.get(position + 1).rucksackContents
                .chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());
        Set<Character> r3 = rucksackList.get(position + 2).rucksackContents
                .chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());
        r1.retainAll(r2);
        r1.retainAll(r3);

        Character[] common = new Character[r1.size()];
        common =  r1.toArray(common);
        return common[0];
    }

    public int calculatePartTwo(){
        int totalVal = 0;
        for (int i = 0; i < rucksackList.size(); i+=3) {
            char commonLetter = getBadge(i);
            int val = commonLetter;
            if(commonLetter < 97){
                // it is a capital letter
                val = commonLetter + 32 + 26;
            }
            totalVal += val - 96;
        }

        return totalVal;
    }

}

class Rucksack {
    String rucksackContents;
    String compartmentOne;

    public String getCompartmentTwo() {
        return compartmentTwo;
    }

    String compartmentTwo;

    public Rucksack(String rucksackContents) {
        this.rucksackContents = rucksackContents;
        int half = rucksackContents.length() / 2;
        this.compartmentOne = rucksackContents.substring(0, half);
        this.compartmentTwo = rucksackContents.substring(half);
    }

    public int calculatePriority(){
        char commonLetter = '!';
        int val = 0;

        for (int i = 0; i < compartmentOne.length(); i++) {
            if(compartmentTwo.contains(compartmentOne.substring(i, i+1))){
                commonLetter = compartmentOne.charAt(i);
                val = commonLetter;
                break;
            }
        }
        if(commonLetter < 97){
            // it is a capital letter
            val = commonLetter + 32 +26;

        }
        return val - 96;
    }

    @Override
    public boolean equals(Object o){
        boolean equivalent = false;
        if(o.getClass().equals(this.getClass())){
            if(((Rucksack) o).compartmentOne.equals(this.compartmentOne) && ((Rucksack) o).getCompartmentTwo().equals(this.compartmentTwo)){
                equivalent = true;
            }
        }

        return equivalent;
    }
}
