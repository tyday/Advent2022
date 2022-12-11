package net.tylerday.AdventofCode.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {
    int number;
    List<Item> itemList = new ArrayList<>();
    MonkeyOperation operation;
    MonkeyTest test;

    public Monkey(List<String> data) {
        createMonkey(data);
    }

    public void createMonkey(List<String> data) {
        for (String line :
                data) {
            if(line.startsWith("Monkey")){
                this.number = Integer.parseInt(line.split(" ")[1].split(":")[0]);
            } else {
                String[] lineArray = line.split(": ");
                String noun = lineArray[0].trim();
                String verb = lineArray[1];

                switch (noun){
                    case("Starting items") -> addItems(verb);
                    case("Operation") -> addOperation(verb);
                    case("Test") -> addTest(verb);
                    case("If true") -> modifyTest(true, verb);
                    case("If false") -> modifyTest(false, verb);
                }
            }
        }
    }

    public Item inspectItem(Item toInspect){
        int oldVal = toInspect.val;
        int newVal = this.operation.apply(oldVal);
        toInspect.val = newVal;
        return  toInspect;
    }

    public Item growBored(Item toInspect){
        toInspect.val = toInspect.val / 3;
    }

    private void modifyTest(boolean b, String verb) {
        int val = Integer.parseInt(verb.split(" ")[3].trim());
        if(b){
            this.test.throwToIfTrue = val;
        } else{
            this.test.throwToIfFalse = val;
        }
    }

    private void addTest(String verb) {
        this.test = new MonkeyTest(verb);
    }

    private void addOperation(String verb) {
        this.operation = new MonkeyOperation(verb);
    }

    private void addItems(String verb) {
        for(String item: verb.split(", ")){
            this.itemList.add(new Item(item.trim()));
        }
    }
}
