package ch.hslu.oop.sw03;

public class Main {
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Temperature temp1 = new Temperature(98);
        Point point1 = new Point(11, -2);

        temp1.changeTemperatureBy(4);
        System.out.println(temp1.getTemperatureCelsius());
        System.out.println(point1.getQuadrant());

        demo1.printBox(20,9);


    }
}