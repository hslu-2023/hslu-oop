package ch.hslu.oop.sw12.temperature;

/**
 * The {@code TemperatureChangeListener} interface represents an object that listens to TemperatureChangeEvents.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public interface TemperatureChangeListener {

    /**
     * This method is called when a temperature change event occurs.
     *
     * @param evt a TemperatureEvent object
     */
    void temperatureChange(TemperatureEvent evt);
}
