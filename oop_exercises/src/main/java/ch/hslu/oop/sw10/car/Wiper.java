package ch.hslu.oop.sw10.car;

/**
 * The {@code Wiper} class represents a windshield car wiper. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Wiper implements Switchable {

    private int rpm = 0;

    public int getRpm() {
        return this.rpm;
    }

    @Override
    public void switchOn() {
        this.rpm = 60;
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
        return this.rpm == 0;
    }

    @Override
    public String toString() {
        return "Wiper{" +
                "rpm=" + rpm +
                '}';
    }
}
