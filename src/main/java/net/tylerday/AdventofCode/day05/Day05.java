package net.tylerday.AdventofCode.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day05 {

    List<String> data;
    List<String> instructions = new ArrayList<>();
    Map<Integer, Stack<Character>> stack = new HashMap<>();
    Map<Integer, Integer> stackPositions = new HashMap<>();


    public static void main(String[] args) throws FileNotFoundException {
        Day05 day05 = new Day05();
        day05.data = day05.getData("src/main/java/net/tylerday/AdventofCode/day05/input.txt");
        day05.assignStacks();
        day05.assignInstructions();
        day05.workInstructions();

        day05.partOne();

        day05 = new Day05();
        day05.data = day05.getData("src/main/java/net/tylerday/AdventofCode/day05/input.txt");
        day05.assignStacks();
        day05.assignInstructions();
        day05.workInstructionsPartTwo();

        day05.partOne();

//        System.out.println(day05.stack);
    }

    public void partOne(){
        String answer = "";

        for (int key :
                this.stackPositions.keySet()) {
            answer += this.stack.get(key).peek();
        }
        System.out.println(answer);
    }

    public void workInstructionsPartTwo(){
        for (String i : this.instructions ) {
//            System.out.println(i);
            String[] instructionParts = i.split(" from ");
            String[] stackNumbers = instructionParts[1].split(" to ");
            int quantity = Integer.parseInt(instructionParts[0].substring(5));
            int fromBin = Integer.parseInt(stackNumbers[0]);
            int toBin = Integer.parseInt(stackNumbers[1]);

            Stack<Character> fromStack = this.stack.get(fromBin);
            Stack<Character> toStack = this.stack.get(toBin);
            Stack<Character> intermediateStack = new Stack<>();
            for (int j = 0; j < quantity; j++) {
                char item = fromStack.pop();
                intermediateStack.add(item);
            }
            for (int j = 0; j < quantity; j++) {
                char item = intermediateStack.pop();
                toStack.add(item);
            }
        }
    }

    public void workInstructions(){
        for (String i : this.instructions ) {
//            System.out.println(i);
            String[] instructionParts = i.split(" from ");
            String[] stackNumbers = instructionParts[1].split(" to ");
            int quantity = Integer.parseInt(instructionParts[0].substring(5));
            int fromBin = Integer.parseInt(stackNumbers[0]);
            int toBin = Integer.parseInt(stackNumbers[1]);

            Stack<Character> fromStack = this.stack.get(fromBin);
            Stack<Character> toStack = this.stack.get(toBin);
            for (int j = 0; j < quantity; j++) {
                char item = fromStack.pop();
                toStack.add(item);
            }
        }
    }

    public void assignInstructions(){
        int labelPosition = getLabelPosition();

        for (int i = labelPosition + 1; i < data.size(); i++) {
            instructions.add(data.get(i));
        }
//        System.out.println(instructions);
    }
    public void assignStacks(){
        int labelPosition = getLabelPosition();
        for (int key : stackPositions.keySet()) {
            this.stack.put(key, new Stack<Character>());
        }


        for (int i = labelPosition -1; i >= 0 ; i--) {
            for (int j = 1; j <= stackPositions.size(); j++) {
                String line = data.get(i);
                int pos = stackPositions.get(j);
                if(line.length() > pos){
//                    Stack<Character> s = this.stack.get(j);
                    char c = line.substring(pos, pos + 1).toCharArray()[0];
                    if (c !=' '){
                        this.stack.get(j).push(c);
//                        s.push(c);
                    }
//                    this.stack.put(j, line.substring(j, j+1).toCharArray()[0])
                }
            }
        }
//        System.out.println(stack);
    }

    private int getLabelPosition() {
        int labelPosition = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).startsWith(" 1")){
                // This is the label line
                labelPosition = i;
                String[] labelNumber = data.get(i).trim().split("  ");

                // Create stacks for each number
                for(String s : labelNumber){
//                    this.stack.put(Integer.parseInt(s.trim()), new Stack<Character>());
                    int internalLabelPosition = data.get(i).indexOf(s.trim());
                    this.stackPositions.put(Integer.parseInt(s.trim()), internalLabelPosition);
                }
                break;
            }
        }
        return labelPosition;
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
