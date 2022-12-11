package net.tylerday.AdventofCode.day11;

public class MonkeyTest {

    String descriptor;
    int divisibleBy;
    int throwToIfTrue;
    int throwToIfFalse;

    public MonkeyTest(String verb) {
        this.descriptor = verb;
        this.divisibleBy = Integer.parseInt(verb.split(" ")[2]);
    }
}
