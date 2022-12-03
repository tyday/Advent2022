package net.tylerday.AdventofCode.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RucksackTest {
    private Rucksack r;

    @Test
    public void constructorTest(){
        r = new Rucksack("abcdABCD");
        assertEquals("abcd", r.compartmentOne);
        assertEquals("ABCD", r.compartmentTwo);
    }

    @Test
    void calculatePriority() {
        r = new Rucksack("abcdABCd");
        assertEquals(4, r.calculatePriority());

        r = new Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp");
        assertEquals(16, r.calculatePriority());

        r = new Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        assertEquals(38, r.calculatePriority());
    }
}