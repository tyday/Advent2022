package net.tylerday.AdventofCode.day11;

public class MonkeyOperation {
    String descriptor;

    public MonkeyOperation(String descriptor) {
        this.descriptor = descriptor;
    }

    public int apply(int oldVal) {
        int val = 0;
        switch (descriptor){
            case ("new = old * 19") -> val =  oldVal * 19;
            case ("new = old + 6") -> val = oldVal + 6;
            case ("new = old * old") -> val = oldVal * oldVal;
            case ("new = old + 3") -> val = oldVal +3;
            case ("new = old * 3") -> val = oldVal * 3;
            case ("new = old + 7") -> val = oldVal + 7;
            case ("new = old + 5") -> val = oldVal + 5;
            case ("new = old + 8") -> val = oldVal + 8;
            case ("new = old + 4") -> val = oldVal + 4;
            case ("new = old * 2") -> val = oldVal * 2;
//            case ("new = old + 6") -> val = oldVal + 6;
//            case ("new = old * old") -> val = oldVal * oldVal;
        }
        return val;
    }
}
