package ch.hslu.oop.sw04;

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
        Engine engine = new Engine();
        System.out.println("state 1: " + engine.isSwitchedOn());
        engine.switchOn();
        System.out.println("state 2: " + engine.isSwitchedOn());
        engine.switchOff();
        System.out.println("state 3: " + engine.isSwitchedOn());

        Point startPoint = new Point(4,10);
        Point endPoint = new Point(2,20);

        Line line = new Line(startPoint,endPoint);
        Point p = line.getNewStartPoint();
        p.setXCoordinate(5);
        System.out.println(line.getStartPoint().getXCoordinate());

    }
}