package net.tylerday.AdventofCode.day09;

import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Day09 {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day09/input.txt");

        partOne(data);
        partTwo(data);

    }

    public static void partOne(List<String> data) {
        Position head = new Position(0,0);
        Position tail = new Position(0,0);

        head.updateHistory();
        tail.updateHistory();

        for (String line :
                data) {
            head.go(line, tail);
        }

        System.out.println(tail.positionHistory.size());
    }

    public static void partTwo(List<String> data) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Position position = new Position(0,0);
            position.updateHistory();
            positions.add(position);
            if(i!=0){
                positions.get(i-1).child = position;
            }
        }

        for (String line :
                data) {
            positions.get(0).go(line);
        }
        System.out.println(positions.get(9).positionHistory.size());
    }
}
