package net.tylerday.AdventofCode.day07;

import java.util.Stack;


public class Node {
    String name;
    Node parent;
    int value;
    Stack<Node> children = new Stack<>();

    public Node() {
    }

    public Node(String name, Node parent, int value) {
        this.name = name;
        this.parent = parent;
        this.value = value;
    }

    int getValue() {
        int total = this.value;
        for (Node child : this.children) {
            total += child.getValue();
        }
        return total;
    }

    public Node getChild(String noun) {
        for(Node c : children){
            if (c.name.equals(noun)){
                return c;
            }
        }
        return null;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "name='" + name + '\'' +
//                ", parent=" + parent +
//                ", value=" + value +
//                ", type=" + type +
//                ", children.size=" + children.size() +
//                '}';
//    }
    @Override
    public String toString(){
        return "Node: " + name + " " + value;
    }
}

enum NodeType {
    DIRECTORY,
    FILE
}

