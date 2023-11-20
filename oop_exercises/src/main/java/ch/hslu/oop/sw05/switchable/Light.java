package ch.hslu.oop.sw05.switchable;

import ch.hslu.oop.sw05.switchable.CountingSwitchable;

/**
 * The {@code Light} class represents a car light. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Light implements CountingSwitchable {

    private int lumen = 0;

    private int switchCounter = 0;

    @Override
    public void switchOn() {
        this.lumen = 1500;
        this.switchCounter++;
    }

    @Override
    public void switchOff() {
        this.lumen = 0;
        this.switchCounter++;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.lumen > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.lumen == 0;
    }

    @Override
    public long getSwitchCount() {
        return this.switchCounter;
    }
}
