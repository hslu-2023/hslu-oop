package ch.hslu.oop.sw06;

import ch.hslu.oop.sw06.chemistry.ChemicalElement;
import ch.hslu.oop.sw06.chemistry.Nitrogen;
import ch.hslu.oop.sw06.point.Point;
import ch.hslu.oop.sw06.shape.Circle;
import ch.hslu.oop.sw06.shape.Rectangle;
import ch.hslu.oop.sw06.shape.Shape;

public class Main {
    public static void main(String[] args) {
        Point originalPoint = new Point(3, 4);
        Point copiedPoint = new Point(originalPoint);
        ChemicalElement element = new Nitrogen(800);
        System.out.println(element);

        //test shape
        Circle shape1 = new Circle(2,3,6);
        Shape shape2 = new Rectangle(4,5,9,4);
    }
}