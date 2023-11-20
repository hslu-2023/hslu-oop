package ch.hslu.oop.sw04;

/**
 * The {@code Light} class represents a car light. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Light implements Switchable {

    private int lumen = 0;

    @Override
    public void switchOn() {
        this.lumen = 1500;
    }

    @Override
    public void switchOff() {
        this.lumen = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.lumen > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.lumen == 0;
    }

}
