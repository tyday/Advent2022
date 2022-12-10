package net.tylerday.AdventofCode.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CPU {
    int registerX = 0;
    int clockCycle = 0;
    int c1 = 0;
    int c2 = 0;
    int total = 0;
    int pointer = 0;
    List<String> data;

    Stack<String> cpuStack = new Stack<>();

    public CPU(List <String> data) {
        this.data = data;
    }

    public void run(){
        while(pointer < data.size()) {
            if (this.cpuStack.empty()) {
                getCommand();
            }
            runCommand(cpuStack.pop());

            if(clockCycle%20==0){

            }
        }
    }

    private void getCommand() {
        String command = data.get(pointer);
        pointer++;
        if(!command.startsWith("noop")){
            cpuStack.add("noop");
        }
        cpuStack.add(command);
    }


    public void runCommand(String c){
        if(!c.startsWith("noop")){
            String[] command = c.split(" ");
            total += Integer.parseInt(command[1]);
        }
        clockCycle ++;
    }
}
