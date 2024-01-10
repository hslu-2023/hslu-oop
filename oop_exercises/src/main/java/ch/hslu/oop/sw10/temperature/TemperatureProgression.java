package ch.hslu.oop.sw10.temperature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TemperatureProgression implements TemperatureProgressionInterface {
    private final Collection<Temperature> temperatureList;

    private final List<TemperatureChangeListener> changeListeners;

    private Temperature max;

    private Temperature min;

    public TemperatureProgression() {
        this.temperatureList = new ArrayList<>();
        this.changeListeners = new ArrayList<>();
    }

    public enum TemperaturExtrema {
        MAX, MIN
    }

    /**
     * Registers a PropertyChangeListener.
     *
     * @param listener PropertyChangeListener.
     */
    public void addPropertyChangeListener(
            final TemperatureChangeListener listener) {
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
            final TemperatureChangeListener listener) {
        if (listener != null) {
            this.changeListeners.remove(listener);
        }
    }

    /**
     * Informs all PropertyChangeListeners about a PropertyChangeEvent.
     *
     * @param pcEvent PropertyChangeEvent.
     */
    private void firePropertyChangeEvent(final TemperatureEvent pcEvent) {
        for (final TemperatureChangeListener listener : this.changeListeners) {
            listener.temperatureChange(pcEvent);
        }
    }

    @Override
    public void add(final Temperature t) {
        final TemperatureEvent pcEvent;
        if (this.getCount() == 0) {
            this.max = t;
            this.min = t;
        } else {
            if (t.compareTo(this.max) > 0) {
                pcEvent = new TemperatureEvent(
                        this, TemperaturExtrema.MAX, this.max, Temperature.createFromCelsius(t.getCelsius()));
                this.firePropertyChangeEvent(pcEvent);
                this.max = t;
            } else if (t.compareTo(this.min) < 0) {
                pcEvent = new TemperatureEvent(
                        this, TemperaturExtrema.MIN, this.min, Temperature.createFromCelsius(t.getCelsius()));
                this.firePropertyChangeEvent(pcEvent);
                this.min = t;
            }
        }
        this.temperatureList.add(t);
    }

    @Override
    public void clear() {
        this.temperatureList.clear();
    }

    @Override
    public int getCount() {
        return this.temperatureList.size();
    }

    @Override
    public Temperature getMax() {
        if (temperatureList.isEmpty()) {
            return Temperature.createFromCelsius(Float.NaN);
        }
        return Temperature.createFromCelsius(Collections.max(this.temperatureList).getCelsius());
    }

    @Override
    public Temperature getMin() {
        if (temperatureList.isEmpty()) {
            return Temperature.createFromCelsius(Float.NaN);
        }
        return Temperature.createFromCelsius(Collections.min(this.temperatureList).getCelsius());
    }

    @Override
    public Temperature getAverage() {
        if (temperatureList.isEmpty()) {
            return Temperature.createFromCelsius(Float.NaN);
        }

        float sum = 0;

        for (Temperature t : temperatureList) {
            sum += t.getCelsius();
        }

        return Temperature.createFromCelsius(sum / temperatureList.size());
    }

    @Override
    public String getList() {
        StringBuilder list = new StringBuilder("[ ");
        for (Temperature t : temperatureList) {
            list.append(t.getCelsius()).append(" ");
        }
        return list.append("]").toString();
    }

    @Override
    public String toString() {
        return "TemperatureProgression{" +
                " temperatureList=" + this.getList() +
                " count=" + this.getCount() +
                " max=" + this.getMax().toString() +
                " min=" + this.getMin().toString() +
                " average=" + this.getAverage().toString() +
                " }";
    }

}
