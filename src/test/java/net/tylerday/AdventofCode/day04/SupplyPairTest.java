package net.tylerday.AdventofCode.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SupplyPairTest {

    @Test
    void assignPairTest() {
        SupplyPair supplyPair = new SupplyPair();
        List<Integer> pairs = supplyPair.assignPair("0-6");

        for (int i = 0; i <= 6; i++) {
            assertEquals(i, pairs.get(i));
        }
    }

    @Test
    void assignPairsTest() {
        SupplyPair supplyPair = new SupplyPair();
        supplyPair.assignPairs("2-6,4-9");

        assertEquals(5, supplyPair.pairOne.size());
        assertEquals(6, supplyPair.pairTwo.size());

        compare(supplyPair.pairOne, new int[] {2,3,4,5,6});
        compare(supplyPair.pairTwo, new int[] {4,5,6,7,8,9});
    }

    private void compare(List<Integer> list, int[] ints){
        assertEquals((long) list.size(), ints.length);

        for (int i = 0; i < ints.length; i++) {
            assertEquals(list.get(i), ints[i]);

        }
    }

    @Test
    void doPairsCompletelyOverlap() {
        SupplyPair supplyPair = new SupplyPair();
        supplyPair.assignPairs("2-6,4-9");

        assertFalse(supplyPair.doPairsCompletelyOverlap());

        supplyPair.assignPairs("6-6,4-6");
        assertTrue(supplyPair.doPairsCompletelyOverlap());

    }

    @Test
    void doPairsPartiallyOverlap() {
        SupplyPair supplyPair = new SupplyPair();
        supplyPair.assignPairs("2-4,6-8");
        assertFalse(supplyPair.doPairsPartiallyOverlap());

        supplyPair.assignPairs("2-3,4-5");
        assertFalse(supplyPair.doPairsPartiallyOverlap());

        supplyPair = new SupplyPair();
        supplyPair.assignPairs("5-7,7-9");
        assertTrue(supplyPair.doPairsPartiallyOverlap());

        supplyPair.assignPairs("2-8,3-7");
        assertTrue(supplyPair.doPairsPartiallyOverlap());

        supplyPair = new SupplyPair();
        supplyPair.assignPairs("6-6,4-6");
        assertTrue(supplyPair.doPairsPartiallyOverlap());

        supplyPair.assignPairs("2-6,4-8");
        assertTrue(supplyPair.doPairsPartiallyOverlap());
    }
}