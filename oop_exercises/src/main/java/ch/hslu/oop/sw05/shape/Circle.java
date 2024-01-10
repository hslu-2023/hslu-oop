package ch.hslu.oop.sw05.shape;

public class Circle extends Shape {

    private int diameter;

    public Circle(final int x, final int y, final int diameter){
        super(x,y);
        this.diameter = diameter;
    }

    public void setDiameter(final int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return this.diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) (Math.PI * this.diameter);
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * Math.pow((double) diameter /2, 2));
    }
}
