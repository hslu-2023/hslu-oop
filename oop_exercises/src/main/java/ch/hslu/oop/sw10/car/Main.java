package ch.hslu.oop.sw10.car;

/**
 * The {@code Main} class serves as the entry point for the application.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Main {
    /**
     * The main method is the entry point of the program.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Car car = new Car();
        car.switchOn();
        System.out.println(car.getEngine().isSwitchedOn());
        System.out.println(car.getFrontLight().isSwitchedOn());
        car.getEngine().switchOff();
        System.out.println(car.getFrontLight().isSwitchedOn());
        car.getEngine().switchOn();
        System.out.println(car.getFrontLight().isSwitchedOn());

    }
}