package net.tylerday.AdventofCode.day08;

import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.List;

public class Day08 {
    public static void main(String[] args) throws FileNotFoundException {
//        List<String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day08/test.txt");
        List<String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day08/input.txt");
        int width = data.get(0).length();
        int height = data.size();

        int[][] grid = new int[height][width];
        boolean[][] visible = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                visible[y][x] = false;
                grid[y][x] = data.get(y).charAt(x) - 48;
            }

        }

        checkWestVisibility(grid, visible, width, height);
        checkEastVisibility(grid, visible, width, height);
        checkNorthVisibility(grid, visible, width, height);
        checkSouthVisibility(grid, visible, width, height);

        int count = countVisibleTrees(visible);
        System.out.println("Visible trees: " + count);

        int bestView = getBestTrees(grid);
        System.out.println("Best view: " + bestView);
    }

    private static int getBestTrees(int[][] grid) {
        int bestView = 0;
        for (int row = 1; row < grid.length - 1; row++) {
            for (int col = 1; col < grid[0].length - 1; col++) {

                int viewN = lookNorth(row, col, grid);
                int viewE = lookEast(row, col, grid);
                int viewS = lookSouth(row, col, grid);
                int viewW = lookWest(row, col, grid);
                int view = viewW * viewN * viewE * viewS;
                if(view>bestView){
                    bestView = view;
                }

            }
        }
        return bestView;
    }

    private static int lookEast(int row, int col, int[][] grid) {
        int count = 0;
        int current = grid[row][col];
        for (int i = col + 1; i < grid[0].length; i++) {
            if(grid[row][i] < current){
                count ++;
            } else {
                count ++;
                break;
            }
        }
        return count;
    }
    private static int lookWest(int row, int col, int[][] grid) {
        int count = 0;
        int current = grid[row][col];
        for (int i = col - 1; i >= 0; i--) {
            if(grid[row][i] < current){
                count ++;
            } else  {
                count ++;
                break;
            }
        }
        return count;
    }

    private static int lookSouth(int row, int col, int[][] grid) {
        int count = 0;
        int current = grid[row][col];
        for (int i = row + 1; i < grid.length; i++) {
            if(grid[i][col] < current){
                count ++;
            } else {
                count ++;
                break;
            }
        }
        return count;
    }

    private static int lookNorth(int row, int col, int[][] grid) {
        int count = 0;
        int current = grid[row][col];
        for (int i = row -1; i >= 0; i--) {
            if(grid[i][col] < current){
                count ++;
            } else {
                count ++;
                break;
            }
        }
        return count;
    }

    private static int countVisibleTrees(boolean[][] visible) {
        int i = 0;
        for (boolean[] row: visible) {
            for (boolean col :
                    row) {
                if (col) {
                    i++;
                }
                }

        }

        return i;
    }

    private static void checkNorthVisibility(int[][] grid, boolean[][] visible, int width, int height) {

        for (int x = 0; x < height; x++) {
            int highest = -1;
            for (int y = 0; y < width; y++) {
                if(grid[y][x] > highest){
                    highest = grid[y][x];
                    visible[y][x] = true;
                }
            }
        }
    }

    private static void checkSouthVisibility(int[][] grid, boolean[][] visible, int width, int height) {

        for (int x = height - 1; x >= 0; x--) {
            int highest = -1;
            for (int y = width - 1; y >= 0; y--) {
                if(grid[y][x] > highest){
                    highest = grid[y][x];
                    visible[y][x] = true;
                }
            }
        }
    }

    private static void checkEastVisibility(int[][] grid, boolean[][] visible, int width, int height) {

        for (int y = height - 1; y >= 0; y--) {
            int highest = -1;
            for (int x = width - 1; x >= 0; x--) {
                if(grid[y][x] > highest){
                    highest = grid[y][x];
                    visible[y][x] = true;
                }
            }
        }
    }

    private static void checkWestVisibility(int[][] grid, boolean[][] visible, int width, int height) {

        for (int y = 0; y < height; y++) {
            int highest = -1;
            for (int x = 0; x < width; x++) {
                if(grid[y][x] > highest){
                    highest = grid[y][x];
                    visible[y][x] = true;
                }
            }
        }
    }
}
