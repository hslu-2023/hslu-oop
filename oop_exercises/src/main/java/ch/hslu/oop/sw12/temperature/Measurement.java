package ch.hslu.oop.sw12.temperature;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The {@code Measurement} class represents a measurement object that contains a temperature and timestamp.
 *
 * @author Raquel Lima
 * @version 1.0
 */
public class Measurement implements Comparable<Measurement> {

    Temperature temperature;

    LocalDateTime timestamp;

    public Measurement(Temperature temperature, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    public Measurement(Temperature temperature) {
        this.temperature = temperature;
        this.timestamp = LocalDateTime.now();
    }

    public Temperature getTemperature() {
        return Temperature.createFromCelsius(this.temperature.getCelsius());
    }

    public void setTemperature(final Temperature temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Measurement m)
                && Float.compare(m.temperature.getCelsius(), this.temperature.getCelsius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.temperature.getCelsius());
    }

    @Override
    public int compareTo(final Measurement other) {
        if (this == other) {
            return 0;
        }
        return Float.compare(this.temperature.getCelsius(), other.temperature.getCelsius());
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "temperature=" + temperature.getCelsius() +
                ", timestamp=" + timestamp +
                '}';
    }

}
