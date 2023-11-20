package ch.hslu.oop.sw05.shape;

import ch.hslu.oop.sw05.shape.Shape;

public class Square extends Shape {

    private int side;

    public Square(final int x, final int y, final int side) {
        super(x, y);
        this.side = side;
    }

    public int getSide() {
        return this.side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getPerimeter() {
        return 4 * side;
    }

    @Override
    public int getArea() {
        return (int) Math.pow(side, 2);
    }
}
