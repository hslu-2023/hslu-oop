package ch.hslu.oop.sw12.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The {@code Temperature} class represents a temperature value and provides methods for conversion between Celsius and Kelvin units.
 *
 * @author Raquel Lima
 * @version 5.0
 */
public final class Temperature implements Comparable<Temperature> {
    private static final Logger LOG =
            LoggerFactory.getLogger(Temperature.class);

    private static final float CELSIUS_OFFSET = 273.15f;

    private final float celsius;

    /**
     * Private constructor to create a Temperature object from a Celsius value.
     *
     * @param celsius The temperature value in Celsius.
     */
    private Temperature(final float celsius) {
        checkTemperature(celsius);
        this.celsius = celsius;
    }

    /**
     * Private constructor to create a Temperature object from a given temperature and unit.
     *
     * @param temperature The temperature value.
     * @param unit        The unit of the temperature (CELSIUS or KELVIN).
     */
    private Temperature(final float temperature, final TemperatureUnit unit) {
        switch (unit) {
            case CELSIUS:
                checkTemperature(temperature);
                this.celsius = temperature;
                break;
            case KELVIN:
                checkTemperature(convertKelvinToCelsius(temperature));
                this.celsius = temperature;
                break;
            default:
                throw new IllegalArgumentException("Unsupported temperature unit: " + unit + ". Supported units are CELSIUS and KELVIN.");
        }
    }

    /**
     * Factory method to create a Temperature object from a Celsius value.
     *
     * @param celsius The temperature value in Celsius.
     * @return A Temperature object.
     */
    public static Temperature createFromCelsius(final float celsius) {
        return new Temperature(celsius);
    }

    /**
     * Factory method to create a Temperature object from a Kelvin value.
     *
     * @param kelvin The temperature value in Kelvin.
     * @return A Temperature object.
     */
    public static Temperature createFromKelvin(final float kelvin) {
        return new Temperature(convertKelvinToCelsius(kelvin));
    }

    /**
     * Checks if the given temperature value in Celsius is within a valid range.
     *
     * @param temperatureCelsius The temperature value to check in Celsius.
     * @throws IllegalArgumentException If the temperature is below the valid range.
     */
    private void checkTemperature(final float temperatureCelsius) {
        LOG.debug("Method: Begin");
        if (temperatureCelsius < -CELSIUS_OFFSET) {
            LOG.error("IllegalArgumentException caught! Please enter a valid temperature value.");
            throw new IllegalArgumentException("Invalid temperature value: " + temperatureCelsius + " Celsius. Temperature should be greater than or equal to " + -CELSIUS_OFFSET + " Celsius.");
        }
        LOG.debug("Method: End");
    }

    /**
     * Converts a temperature value from Kelvin to Celsius.
     *
     * @param kelvin The temperature value to convert in Kelvin.
     * @return The temperature value converted in Celsius.
     */
    public static float convertKelvinToCelsius(final float kelvin) {
        return kelvin - CELSIUS_OFFSET;
    }

    /**
     * Converts a temperature value from Celsius to Kelvin.
     *
     * @param celsius The temperature value to convert in Celsius.
     * @return The temperature value converted in Kelvin.
     */
    public static float convertCelsiusToKelvin(final float celsius) {
        return celsius + CELSIUS_OFFSET;
    }

    public float getKelvin() {
        return convertCelsiusToKelvin(this.celsius);
    }

    public float getCelsius() {
        return this.celsius;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature t)
                && Float.compare(t.celsius, this.celsius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.celsius);
    }

    @Override
    public int compareTo(final Temperature other) {
        if (this == other) {
            return 0;
        }
        return Float.compare(this.celsius, other.celsius);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "celsius=" + celsius +
                '}';
    }
}
