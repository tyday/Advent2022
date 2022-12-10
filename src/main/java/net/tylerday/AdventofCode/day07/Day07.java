package net.tylerday.AdventofCode.day07;

import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day07 {

    public static void main(String[] args) throws FileNotFoundException {
//        List<String> data = FileHelper.getData("src/test/java/net/tylerday/AdventofCode/day07/test.txt");
        List<String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day07/input.txt");

        FileStructure fileStructure = new FileStructure();
        Parser parser = new Parser(fileStructure);
        for (String line: data ) {
            parser.runLine(line);
        }

        List<Node> smallDirectories = new ArrayList<>();
        fileStructure.directories.forEach(d ->{
            if(d.getValue() <= 100000){
                smallDirectories.add(d);
            }
        });
        int smallDirectoryTotal = 0;
        for (Node d :
                smallDirectories) {
            smallDirectoryTotal += d.getValue();
        }
        System.out.println("Part one: " + smallDirectoryTotal);

        // Part Two
        int spaceAvailable = 70000000;
        int minimumFreeSpace = 30000000;
        int currentFreeSpace = spaceAvailable - fileStructure.root.getValue();
        int minimumNodeSize = minimumFreeSpace - currentFreeSpace;
        System.out.printf("Current free space: %,8d%n", currentFreeSpace);
        System.out.printf("Needed space: %,8d%n", minimumNodeSize);

        List<Node> usableDirectories = new ArrayList<>();
        List<Integer> usableDirectoryValues = new ArrayList<>();

        for (Node d :
                fileStructure.directories) {
            if(d.getValue() > minimumNodeSize){
                usableDirectories.add(d);
                usableDirectoryValues.add(d.getValue());
            }
        }

        int minVal = usableDirectoryValues.get(0);
        Node minNode = usableDirectories.get(0);

        for (int i = 0; i < usableDirectories.size(); i++) {
            int val = usableDirectoryValues.get(i);
            Node n = usableDirectories.get(i);
            if(val< minVal){
                minVal = val;
                minNode = n;
            }
        }

        System.out.println("Min value: " + minVal);
        System.out.println("Node: " + minNode);


    }
}
