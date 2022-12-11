package net.tylerday.AdventofCode.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CPU {
    int registerX = 1;
    int clockCycle = 0;
    int totalSignalStrength = 0;
//    List<Integer> interestingCycles = new ArrayList<>(Arrays.asList(20, 60, 100, 140, 180, 220));
    List<Integer> interestingCycles = new ArrayList<>(Arrays.asList(40,80,120,160,200,240));
    int pointer = 0;
    List<String> data;

    Stack<String> cpuStack = new Stack<>();

    char[][] display = new char[6][41];
    int currentRow = 0;

    public CPU(List <String> data) {
        this.data = data;
    }

    public void run(){
        while(pointer < data.size() || !this.cpuStack.isEmpty()) {
            clockCycle ++;

            if(interestingCycles.contains(clockCycle)){
                this.totalSignalStrength += this.clockCycle * this.registerX;
                System.out.printf("Cycle: %d * registerX: %d = %d\n", this.clockCycle, this.registerX, this.totalSignalStrength);
                currentRow ++;

            }

            if (this.cpuStack.empty()) {
                getCommand();
            }
            runCommand(cpuStack.pop());

            addPixel();

        }
        System.out.printf("Cycle: %d registerX: %d\n", this.clockCycle, this.registerX);
        System.out.println();
        printDisplay();
    }

    private void printDisplay() {
        for (char[] row :
                display) {
            for (int i = 0; i < row.length; i++) {
                if(row[i] == '#'){
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private void addPixel() {
        int horizontalPlacement = clockCycle % 40;
        if((registerX - 1 <= horizontalPlacement) && (horizontalPlacement <= registerX + 1)){
//            if((registerX > -1) && (registerX < 41)) {
                display[currentRow][horizontalPlacement] = '#';
//            }
        }
    }

    private void getCommand() {
        String command = data.get(pointer);
        pointer++;
        if(!command.startsWith("noop")){
            cpuStack.add(command);
            cpuStack.add("noop");
        } else {
            cpuStack.add(command);
        }
    }


    public void runCommand(String c){
        if(!c.startsWith("noop")){
            String[] command = c.split(" ");
            registerX += Integer.parseInt(command[1]);
            System.out.printf("    %s | %s\n", this.clockCycle, c);
        }
    }
}
