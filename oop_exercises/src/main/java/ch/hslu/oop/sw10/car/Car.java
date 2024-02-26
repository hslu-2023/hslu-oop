package ch.hslu.oop.sw10.car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The {@code Car} class represents a car. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 2.0
 */
public class Car implements Switchable, PropertyChangeListener {

    private final Engine engine;
    private final Light frontLight;
    private final Light backLight;
    private final Wiper wiper;

    public Car() {
        this.engine = new Engine();
        this.frontLight = new Light();
        this.backLight = new Light();
        this.wiper = new Wiper();

        this.engine.addPropertyChangeListener(
                e -> handleEngineEvent("Event from Motor", e));
    }

    private void handleEngineEvent(String engine, PropertyChangeEvent event) {
        if (event.getNewValue() == Engine.EngineState.ON) {
            this.frontLight.switchOn();
            backLight.switchOn();
        } else if (event.getNewValue() == Engine.EngineState.OFF) {
            frontLight.switchOff();
            backLight.switchOff();
            wiper.switchOff();
        }

    }

    public Engine getEngine() {
        return engine;
    }

    public Light getFrontLight() {
        return frontLight;
    }

    public Light getBackLight() {
        return backLight;
    }

    public Wiper getWiper() {
        return wiper;
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
        this.frontLight.switchOff();
        this.backLight.switchOff();
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

    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        if (event.getSource() == this.engine) {
            this.handleEngineEvent("Engine", event);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine.toString() +
                ", frontLight=" + frontLight.toString() +
                ", backLight=" + backLight.toString() +
                ", wiper=" + wiper.toString() +
                '}';
    }
}
