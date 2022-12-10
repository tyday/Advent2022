package net.tylerday.AdventofCode.helper;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHelperTest {

    @Test
    void getData() throws FileNotFoundException {
        String dataString = """
                $ cd /
                $ ls
                dir a
                14848514 b.txt
                8504156 c.dat
                dir d
                $ cd a
                $ ls
                dir e
                29116 f
                2557 g
                62596 h.lst
                $ cd e
                $ ls
                584 i
                $ cd ..
                $ cd ..
                $ cd d
                $ ls
                4060174 j
                8033020 d.log
                5626152 d.ext
                7214296 k
                """;
        List<String> data = Arrays.stream(dataString.split("\n")).toList();
        List<String> testData = FileHelper.getData("src/test/java/net/tylerday/AdventofCode/helper/testInput.txt");

        assertEquals(data.size(), testData.size());
        for (int i = 0; i < data.size(); i++) {
            assertEquals(data.get(i), testData.get(i));
        }

    }
}