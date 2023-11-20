package ch.hslu.oop.sw03;

public class Point {

    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getQuadrant() {
        if (xCoordinate == 0 || yCoordinate == 0) {
            return 0;
        } else if (xCoordinate > 0) {
            return (yCoordinate > 0) ? 1 : 4;
        } else {
            return (yCoordinate > 0) ? 2 : 3;
        }
    }
}
