package ch.hslu.oop.sw11.temperature;

import java.util.EventObject;

public class TemperatureEvent extends EventObject {

    private final TemperatureProgression.TemperaturExtrema extrema;

    private final Object newValue;

    private final Object oldValue;

    /**
     * Constructs a new {@code TemperatureEvent}.
     *
     * @param source        the bean that fired the event
     * @param extrema       the programmatic name of the property that was changed
     * @param oldValue      the old value of the property
     * @param newValue      the new value of the property
     *
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public TemperatureEvent(Object source, TemperatureProgression.TemperaturExtrema extrema,
                               Object oldValue, Object newValue) {
        super(source);
        this.extrema = extrema;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public TemperatureProgression.TemperaturExtrema getExtrema() {
        return extrema;
    }

    /**
     * Gets the new value for the property, expressed as an Object.
     *
     * @return  The new value for the property, expressed as an Object.
     *          May be null if multiple properties have changed.
     */
    public Object getNewValue() {
        return newValue;
    }

    /**
     * Gets the old value for the property, expressed as an Object.
     *
     * @return  The old value for the property, expressed as an Object.
     *          May be null if multiple properties have changed.
     */
    public Object getOldValue() {
        return oldValue;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getName());
        appendTo(sb);
        sb.append("; oldValue=").append(getOldValue());
        sb.append("; newValue=").append(getNewValue());
        sb.append("; source=").append(getSource());
        return sb.append("]").toString();
    }

    void appendTo(StringBuilder sb) {
    }
}
