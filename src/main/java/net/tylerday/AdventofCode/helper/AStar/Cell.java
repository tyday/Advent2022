package net.tylerday.AdventofCode.helper.AStar;

class Cell {
    int parentI;
    int parentJ;
    int f;
    int g;
    int h;

    Cell() {
        this.parentI = 0;
        this.parentJ = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }
}
