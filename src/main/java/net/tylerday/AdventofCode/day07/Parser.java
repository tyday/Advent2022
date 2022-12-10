package net.tylerday.AdventofCode.day07;

public class Parser {
    private State state = State.INPUT;
    private FileStructure fileStructure;

    private Node currentNode;

    public Parser(FileStructure fileStructure) {
        this.fileStructure = fileStructure;
    }

    public void runLine(String line){
        if(line.startsWith("$")){
            state = State.INPUT;
        }

        switch (state) {
            case INPUT -> executeInput(line);
            case OUTPUT -> System.out.println("output: " + line);
            case LS -> listContents(line);
        }
    }

    public void executeInput(String command){
        String[] commands = command.substring(1).trim().split(" ");
        String verb = commands[0];
        String noun = commands.length > 1 ? commands[1] : "";

        switch (verb) {
            case "cd" -> changeDirectory(noun);
            case "ls" -> state = State.LS;
        }
    }

    private void listContents(String line) {
        String part1 = line.split(" ")[0];
        String part2 = line.split(" ")[1];
        Node newNode = new Node();
        if(part1.equals("dir")){
            newNode.name = part2;
            newNode.value = 0;
            newNode.type = NodeType.DIRECTORY;
            newNode.parent = currentNode;
            currentNode.children.add(newNode);
            fileStructure.directories.add(newNode);
        } else {
            newNode.name = part2;
            newNode.value = Integer.parseInt(part1);
            newNode.type = NodeType.FILE;
            newNode.parent = currentNode;
            currentNode.children.add(newNode);
        }

    }

    private void changeDirectory(String noun) {
//        System.out.println("Change directory: " + noun);
        switch (noun) {
            case "/" -> currentNode = fileStructure.root;
            case ".." -> currentNode = currentNode.parent;
            default -> currentNode = currentNode.getChild(noun);
        }
    }
}

enum State{
    INPUT,
    OUTPUT,
    LS
}
