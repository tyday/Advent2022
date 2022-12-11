package net.tylerday.AdventofCode.day09;

import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.List;

class Day09Test {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> data = FileHelper.getData("src/test/java/net/tylerday/AdventofCode/day09/test.txt");

        Day09.partOne(data);

        data = FileHelper.getData("src/test/java/net/tylerday/AdventofCode/day09/test2.txt");
        Day09.partTwo(data);
    }
}