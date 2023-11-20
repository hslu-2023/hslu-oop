package ch.hslu.oop.sw04;

/**
 * The {@code Engine} class represents a car engine. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Engine implements Switchable {

    private int rpm = 0;

    @Override
    public void switchOn() {
        this.rpm = 5600;
    }

    @Override
    public void switchOff() {
        this.rpm = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.rpm > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn();
    }
}
