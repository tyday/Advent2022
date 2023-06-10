package net.tylerday.AdventofCode.helper.AStar;

public class AStar {
    private int ROW;
    private int COL;

    public boolean isValid(int row, int col){
        return (row >= 0) && (col>= 0) && (row <= ROW) && (col <= COL);
    }

    public boolean isUnBlocked(Grid grid, int row, int col) {
        int val = grid.getCell(row, col);
        return val != 1;
    }
}
