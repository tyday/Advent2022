package net.tylerday.AdventofCode.day12;

/* Using A * algorithm. My first stop is https://www.geeksforgeeks.org/a-search-algorithm/#
*
*/

import net.tylerday.AdventofCode.helper.AStar.Grid;
import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.List;

public class Day12 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello");
        List<String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day12/test.txt");
        Grid grid = new Grid(data);
        System.out.println(grid);
    }
}
