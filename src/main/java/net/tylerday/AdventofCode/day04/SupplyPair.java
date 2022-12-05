package net.tylerday.AdventofCode.day04;

import java.util.ArrayList;
import java.util.List;

public class SupplyPair {
    List<Integer> pairOne = new ArrayList<>();
    List<Integer> pairTwo = new ArrayList<>();

    public SupplyPair() {
    }

    public SupplyPair(String data) {
        assignPairs(data);
    }

    public void assignPairs(String data) {
        String[] pairs = data.split(",");
        pairOne = assignPair(pairs[0]);
        pairTwo = assignPair(pairs[1]);
    }

    public List<Integer> assignPair(String pair) {
        String[] stringPair = pair.split("-");
        int p1 = Integer.parseInt(stringPair[0]);
        int p2 = Integer.parseInt(stringPair[1]);

        List<Integer> data = new ArrayList<>();
        for (int i = p1; i <= p2; i++) {
            data.add(i);
        }
        return data;
    }

    public boolean doPairsCompletelyOverlap(){
        int p1Min = pairOne.get(0);
        int p1Max = pairOne.get(pairOne.size() - 1);

        int p2Min = pairTwo.get(0);
        int p2Max = pairTwo.get(pairTwo.size() - 1);

        if(p1Min >= p2Min && p1Max <= p2Max){
            return true;
        } else if (p2Min >= p1Min && p2Max <= p1Max) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doPairsPartiallyOverlap(){
        boolean overlap = false;

        int p1Min = pairOne.get(0);
        int p1Max = pairOne.get(pairOne.size() - 1);

        int p2Min = pairTwo.get(0);
        int p2Max = pairTwo.get(pairTwo.size() - 1);

        if(p1Min >= p2Min && p1Min <= p2Max ){
            overlap = true;
        } else if (p1Max >= p2Min && p1Max <= p2Max) {
            overlap = true;
        } else if (p2Min >= p1Min && p2Min <= p1Max) {
            overlap = true;
        } else if (p2Max >= p1Min && p2Max <= p1Max) {
            overlap = true;
        }

        return overlap;
    }
}
