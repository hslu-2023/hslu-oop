package ch.hslu.oop.sw05;

import ch.hslu.oop.sw05.chemistry.ChemicalElement;
import ch.hslu.oop.sw05.chemistry.Natrium;
import ch.hslu.oop.sw05.shape.Circle;
import ch.hslu.oop.sw05.shape.Rectangle;
import ch.hslu.oop.sw05.shape.Shape;
import ch.hslu.oop.sw05.shape.Square;
import ch.hslu.oop.sw05.switchable.CountingSwitchable;
import ch.hslu.oop.sw05.switchable.Light;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3, 5, 7);
        Shape rectangle = new Rectangle(3, 6, 4, 8);
        Shape square = new Square(3,8,3);

        //test shape
        System.out.println(circle.getX());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());
        System.out.println(rectangle.getX());
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(square.getX());
        System.out.println(square.getPerimeter());
        System.out.println(square.getArea());

        //test chemical element
        ChemicalElement natrium = new Natrium(90);
        System.out.println(natrium.getPhysicalState());

        //test counting switchable
        CountingSwitchable light = new Light();
        System.out.println(light.getSwitchCount());
        light.switchOn();
        light.switchOff();
        System.out.println(light.getSwitchCount());





    }
}