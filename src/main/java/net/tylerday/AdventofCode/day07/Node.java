package net.tylerday.AdventofCode.day07;

import java.util.Stack;


public class Node {
    String name;
    Node parent;
    int value;
    NodeType type;
    Stack<Node> children = new Stack<>();

    public Node() {
    }

    public Node(String name, int value, NodeType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public Node(String name, Node parent, int value, NodeType type) {
        this.name = name;
        this.parent = parent;
        this.value = value;
        this.type = type;
    }

    public void add(Node child) {
        children.add(child);
    }

    int getValue() {
        int total = this.value;
        for (Node child : this.children) {
            total += child.getValue();
        }
        return total;
    }

    boolean contains(String name){
        for(Node n : this.children){
            if(n.name.equals(name)){
                return true;
            }
        }
        return false;
    }
    boolean contains(Node n){
        for(Node c : this.children){
            if(n.equals(c)){
                return true;
            }
        }
        return false;
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

