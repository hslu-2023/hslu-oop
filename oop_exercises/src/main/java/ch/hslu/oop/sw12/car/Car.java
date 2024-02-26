package ch.hslu.oop.sw12.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;

/**
 * The {@code Car} class represents a car. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 3.0
 */
public class Car implements Switchable {

    private static final Logger LOG =
            LoggerFactory.getLogger(Car.class);

    private final Engine engine;
    private final Light frontLight;
    private final Light backLight;
    private final Wiper wiper;

    /**
     * Public Constructor which creates a Car object.
     */
    public Car() {
        this.engine = new Engine();
        this.frontLight = new Light();
        this.backLight = new Light();
        this.wiper = new Wiper();

        this.engine.addPropertyChangeListener(this::handleEngineEvent);
    }

    /**
     * Handles Events coming from Engine. When Engine is turns on, the front and backlight are switched on.
     * Otherwise, the wiper, front and backlight are turned off.
     *
     * @param event
     */
    private void handleEngineEvent(PropertyChangeEvent event) {
        if (event.getNewValue() == Engine.EngineState.ON) {
            LOG.info("Engine switched on");
            this.frontLight.switchOn();
            backLight.switchOn();
        } else if (event.getNewValue() == Engine.EngineState.OFF) {
            LOG.info("Engine switched off");
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
    public String toString() {
        return "Car{" +
                "engine=" + engine.toString() +
                ", frontLight=" + frontLight.toString() +
                ", backLight=" + backLight.toString() +
                ", wiper=" + wiper.toString() +
                '}';
    }
}
