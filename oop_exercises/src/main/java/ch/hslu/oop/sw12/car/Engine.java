package ch.hslu.oop.sw12.car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Engine} class represents a car engine. It implements the {@code Switchable} interface
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Engine implements Switchable {

    private int rpm;
    private EngineState state;

    private final List<PropertyChangeListener> changeListeners =
            new ArrayList<>();

    public Engine() {
        this.rpm = 0;
        this.state = EngineState.OFF;
    }

    public enum EngineState {
        ON, OFF, FAILURE
    }

    /**
     * Registers a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(
            final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        }
    }

    /**
     * Removes a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void removePropertyChangeListener(
            final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.remove(listener);
        }
    }

    /**
     * Informs all PropertyChangeListeners about a PropertyChangeEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void firePropertyChangeEvent(
            final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }

    public int getRpm() {
        return rpm;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.rpm = 5600;
            this.state = EngineState.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(
                    this, "state", EngineState.OFF, EngineState.ON);
            this.firePropertyChangeEvent(pcEvent);
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.rpm = 0;
            this.state = EngineState.OFF;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(
                    this, "state", EngineState.ON, EngineState.OFF);
            this.firePropertyChangeEvent(pcEvent);
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.rpm > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn();
    }

    @Override
    public String toString() {
        return "Engine{" +
                "rpm=" + rpm +
                ", state=" + state +
                ", changeListeners=" + changeListeners +
                '}';
    }
}
