package ch.hslu.oop.sw12.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TemperatureProgression implements TemperatureProgressionInterface {

    private static final Logger LOG =
            LoggerFactory.getLogger(TemperatureProgression.class);

    private final Collection<Measurement> measurementList;

    private final List<TemperatureChangeListener> changeListeners;

    private Temperature maxTemperature;

    private Temperature minTemperature;

    public TemperatureProgression() {
        this.measurementList = new ArrayList<>();
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
    public void add(final Measurement m) {
        final TemperatureEvent pcEvent;
        if (this.getCount() == 0) {
            this.maxTemperature = m.getTemperature();
            this.minTemperature = m.getTemperature();
        } else {
            if (m.getTemperature().compareTo(this.maxTemperature) > 0) {
                pcEvent = new TemperatureEvent(
                        this, TemperaturExtrema.MAX, this.maxTemperature, Temperature.createFromCelsius(m.temperature.getCelsius()));
                this.firePropertyChangeEvent(pcEvent);
                this.maxTemperature = m.getTemperature();
            } else if (m.getTemperature().compareTo(this.minTemperature) < 0) {
                pcEvent = new TemperatureEvent(
                        this, TemperaturExtrema.MIN, this.minTemperature, Temperature.createFromCelsius(m.temperature.getCelsius()));
                this.firePropertyChangeEvent(pcEvent);
                this.minTemperature = m.getTemperature();
            }
        }
        this.measurementList.add(m);
    }

    @Override
    public void clear() {
        this.measurementList.clear();
    }

    @Override
    public int getCount() {
        return this.measurementList.size();
    }

    @Override
    public Measurement getMaxMeasurement() {
        return measurementList.stream()
                .max(Comparator.comparing(Measurement::getTemperature))
                .orElseThrow(() -> new NoSuchElementException("No max temperature found in the measurement list"));
    }

    @Override
    public Measurement getMinMeasurement() {
        return measurementList.stream()
                .min(Comparator.comparing(Measurement::getTemperature))
                .orElseThrow(() -> new NoSuchElementException("No max temperature found in the measurement list"));
    }

    @Override
    public Temperature getTemperatureAverage() {
        if (this.measurementList.isEmpty()) {
            return Temperature.createFromCelsius(Float.NaN);
        }

        float sum = 0;

        for (Measurement m : this.measurementList) {
            sum += m.getTemperature().getCelsius();
        }

        return Temperature.createFromCelsius(sum / this.measurementList.size());
    }

    @Override
    public ArrayList<Measurement> getMeasurementList() {
        return new ArrayList<>(this.measurementList);
    }

    public void loadListFromFile(final String filePath) {
        this.measurementList.clear();

        if (new File(filePath).exists()) {
            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(
                                 new FileInputStream(filePath), StandardCharsets.UTF_8))
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] valuesArray = line.split(";");
                    try {
                        float temperatureValue = Float.parseFloat(valuesArray[2]);
                        LocalDateTime timestampValue =
                                LocalDateTime.parse(valuesArray[1],
                                        DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
                        this.measurementList.add(new Measurement(Temperature.createFromCelsius(temperatureValue), timestampValue));
                    } catch (NumberFormatException | DateTimeParseException e) {
                        LOG.error("Error occurred when converting value: " + e.getMessage(), e);
                    }
                }
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
    }

    @Override
    public String toString() {
        return "TemperatureProgression{" +
                "temperatureList=" + this.measurementList +
                ", changeListeners=" + this.changeListeners +
                ", max=" + this.maxTemperature +
                ", min=" + this.minTemperature +
                '}';
    }
}
