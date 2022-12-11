package net.tylerday.AdventofCode.day09;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void moveN() {
        Position pos = new Position(1,1);
        pos.moveN();
        assertEquals(2, pos.y);
        assertEquals(1, pos.x);
    }

    @Test
    void moveNE() {
        Position pos = new Position(1,1);
        pos.moveNE();
        assertEquals(2, pos.x);
        assertEquals(2, pos.y);
    }

    @Test
    void moveE() {
        Position pos = new Position(1,1);
        pos.moveE();
        assertEquals(2, pos.x);
        assertEquals(1, pos.y);
    }

    @Test
    void moveSE() {
        Position pos = new Position(1,1);
        pos.moveSE();
        assertEquals(2, pos.x);
        assertEquals(0, pos.y);
    }

    @Test
    void moveS() {
        Position pos = new Position(1,1);
        pos.moveS();
        assertEquals(1, pos.x);
        assertEquals(0, pos.y);
    }

    @Test
    void moveSW() {
        Position pos = new Position(1,1);
        pos.moveSW();
        assertEquals(0, pos.x);
        assertEquals(0, pos.y);
    }

    @Test
    void moveW() {
        Position pos = new Position(1,1);
        pos.moveW();
        assertEquals(0, pos.x);
        assertEquals(1, pos.y);
    }

    @Test
    void moveNW() {
        Position pos = new Position(1,1);
        pos.moveNW();
        assertEquals(0, pos.x);
        assertEquals(2, pos.y);
    }

    @Test
    void testEquals() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(1, 1);
        Position pos3 = new Position(2, 1);
        Position pos4 = new Position(1, 2);

        assertEquals(pos1, pos2);
        assertNotEquals(pos1, pos3);
        assertNotEquals(pos1, pos4);
    }

    @Test
    void updateHistory() {
        Position pos1 = new Position(1, 1);
        Position pos2 = new Position(1, 1);
        Position pos3 = new Position(2, 1);
        Position pos4 = new Position(1, 2);

        Set<Position> positionSet = new HashSet<>();
        positionSet.add(pos1);
        positionSet.add(pos2);
        positionSet.add(pos3);
        positionSet.add(pos4);
        assertEquals(3, positionSet.size());
    }

    @Test
    void positionHistory(){
        Position pos1 = new Position(1,1);
        pos1.updateHistory();

        assertEquals(1,pos1.positionHistory.size());

        pos1.moveNE();
        pos1.moveW();
        assertEquals(3, pos1.positionHistory.size());

        pos1.moveS();
        assertEquals(3, pos1.positionHistory.size());
    }

    @Test
    void distance() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(1, 0);
        assertEquals(1.0f, pos1.distance(pos2));
        pos2.moveE();
        assertEquals(2.0f,pos1.distance(pos2));
        pos2.moveN();
        assertEquals(2.2f,pos1.distance(pos2));
        pos2.moveN();
        assertEquals(2.8f,pos1.distance(pos2));
        pos2.moveW();
        assertEquals(2.2f,pos1.distance(pos2));
        pos2.moveW();
        assertEquals(2.0f,pos1.distance(pos2));
        pos2.moveW();
        pos2.moveW();
        assertEquals(2.8f,pos1.distance(pos2));
        pos2.moveS();
        pos2.moveS();
        assertEquals(2.0f,pos1.distance(pos2));
        pos2.moveS();
        pos2.moveS();
        assertEquals(2.8f,pos1.distance(pos2));
        pos2.moveE();
        assertEquals(2.2f, pos1.distance(pos2));
        pos2.moveE();
        pos2.moveE();
        assertEquals(2.2f, pos1.distance(pos2));
        pos2.moveNE();
        assertEquals(2.2f, pos1.distance(pos2));
    }

    @Test
    void setPosition() {
        Position pos1 = new Position(0,0);
        pos1.setPosition(1,3);
        assertEquals(1, pos1.x);
        assertEquals(3, pos1.y);
    }

    @Test
    void chase() {
        Position tail = new Position(0,0);
        Position head = new Position(0, 2);
        Position target = new Position(0, 1);

        tail.chase(head);
        assertEquals(tail, target);

        tail.setPosition(0,0);
        head.setPosition(2, 1);
        target.setPosition(1,1);
        tail.chase(head);
        assertEquals(tail, target);

        tail.setPosition(0,0);
        head.setPosition(1, 2);
        target.setPosition(1,1);
        tail.chase(head);
        assertEquals(tail, target);
    }
}