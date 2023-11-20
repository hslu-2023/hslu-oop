package ch.hslu.oop.sw04;

/**
 * The {@code Car} class represents a car. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Car implements Switchable {

    final Engine engine;
    final Light frontLight;
    final Light backLight;
    final Wiper wiper;

    public Car(){
        this.engine = new Engine();
        this.frontLight = new Light();
        this.backLight = new Light();
        this.wiper = new Wiper();
    }

    @Override
    public void switchOn() {
        this.engine.switchOn();
        this.frontLight.switchOn();
        this.backLight.switchOn();
    }

    @Override
    public void switchOff() {
        this.engine.switchOff();
        this.frontLight.switchOn();
        this.backLight.switchOn();
        this.wiper.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return this.engine.isSwitchedOn();
    }

    @Override
    public boolean isSwitchedOff() {
        return this.engine.isSwitchedOff();
    }
}
