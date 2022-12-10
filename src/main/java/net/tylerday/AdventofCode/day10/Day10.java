package net.tylerday.AdventofCode.day10;

import net.tylerday.AdventofCode.helper.FileHelper;

import java.io.FileNotFoundException;
import java.util.List;

public class Day10 {

    public static void main(String[] args) throws FileNotFoundException {
        List <String> data = FileHelper.getData("src/main/java/net/tylerday/AdventofCode/day10/test.txt");
        CPU cpu = new CPU(data);
    }
}
