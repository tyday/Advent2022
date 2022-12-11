package net.tylerday.AdventofCode.day09;

import java.util.*;

public class Position {

    int x;
    int y;

    Position child;

    Set<Position> positionHistory = new HashSet<>();

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void updateHistory(){
        positionHistory.add(new Position(this.x, this.y));
    }

    public void moveN(){
        this.y += 1;
        updateHistory();
    }

    public void moveNE(){
        this.x += 1;
        this.y += 1;
        updateHistory();
    }

    public void moveE(){
        this.x += 1;
        updateHistory();
    }

    public void moveSE(){
        this.x += 1;
        this.y -= 1;
        updateHistory();
    }

    public void moveS(){
        this.y -= 1;
        updateHistory();
    }

    public void moveSW(){
        this.y -= 1;
        this.x -= 1;
        updateHistory();
    }

    public  void moveW(){
        this.x -= 1;
        updateHistory();
    }

    public void moveNW(){
        this.y += 1;
        this.x -= 1;
        updateHistory();
    }

    public Position difference(Position other){
        int diffX = other.x - this.x;
        int diffY = other.y - this.y;
        return new Position(diffX, diffY);
    }

    public float distance(Position other){
        int diffX = other.x - this.x;
        int diffY = other.y - this.y;
        double diff = Math.sqrt((diffY * diffY) + (diffX * diffX));
        return (float) Math.round(diff * 10) / 10.0f;
    }

    public void chase(Position other){
        float distance = distance(other);
        Position difference = difference(other);

        if(distance < 1.6f){
            return;
        }


        if(difference.x >= 1){
            if(difference.y == 0){
                moveE();
            } else if(difference.y > 0){
                moveNE();
            } else {
                moveSE();
            }
        } else if (difference.x <= -1) {
            if(difference.y == 0){
                moveW();
            } else if (difference.y > 0) {
                moveNW();
            } else {
                moveSW();
            }
        } else {
            if(difference.y == 2){
                moveN();
            } else if (difference.y == -2) {
                moveS();
            } else {
                throw new Error("What the fuck?");
            }
        }
        if(null != child){
            child.chase(this);
        }
    }

    public void go(String command){
        String dir = command.split(" ")[0];
        int frq = Integer.parseInt(command.split(" ")[1]);

        for (int i = 0; i < frq; i++) {
            switch (dir) {
                case "U" -> moveN();
                case "D" -> moveS();
                case "R" -> moveE();
                case "L" -> moveW();
            }
            if(null != child){
                child.chase(this);
                System.out.println("Head: " + this + "Dir: " + dir + " Tail: " + child);
            }
        }
    }

    public void go(String command, Position other){
        String dir = command.split(" ")[0];
        int frq = Integer.parseInt(command.split(" ")[1]);

        for (int i = 0; i < frq; i++) {
            switch (dir) {
                case "U" -> moveN();
                case "D" -> moveS();
                case "R" -> moveE();
                case "L" -> moveW();
            }
            other.chase(this);
            System.out.println("Head: " + this + "Dir: " + dir + " Tail: " + other);
        }
    }

    @Override
    public boolean equals(Object other){
        if(this.getClass() != other.getClass()){
            return false;
        }
        Position o = (Position) other;
        if(this.x == o.x && this.y == o.y){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int result = 17;

        result = 31 * result + x;
        result = 31 * result + y;
        return  result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
