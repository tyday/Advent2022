package net.tylerday.AdventofCode.day07;

import java.util.ArrayList;
import java.util.List;

public class FileStructure {
    Node root;
    List<Node> directories;

    public FileStructure() {
        root = new Node("/", null, 0);
        directories = new ArrayList<>();
        directories.add(root);
    }
}
