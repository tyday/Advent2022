package net.tylerday.AdventofCode.helper.AStar;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    ArrayList<ArrayList<Character>> grid = new ArrayList<>();
    static int HEIGHT;
    static int WIDTH;

    public Grid(List<String> input){
        HEIGHT = input.size();
        WIDTH = input.get(0).length();
        int j = 0;
        for (String s: input) {
            ArrayList<Character> row = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                row.add(s.charAt(i));
            }
            grid.add(row);
        }
    }

    @Override
    public String toString() {
        String retString = "";
        for (ArrayList<Character> characters: grid) {
            retString += characters.toString() + "\n";
        }
        return retString;
    }

    public int getCell(int row, int col) {
        return grid.get(row).get(col);
    }
}
