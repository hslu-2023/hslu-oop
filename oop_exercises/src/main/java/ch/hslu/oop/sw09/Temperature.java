package ch.hslu.oop.sw09;

import java.util.Objects;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * The {@code Temperature} class represents a temperature value and provides methods for conversion between Celsius and Kelvin units.
 *
 * @author Raquel Lima
 * @version 5.0
 */
public final class Temperature implements Comparable<Temperature> {
    private static final Logger LOG =
            LoggerFactory.getLogger(Temperature.class);

    private static final float KELVIN_OFFSET = 273.15f;

    private final float kelvin;

    /**
     * Private constructor to create a Temperature object from a Celsius value.
     *
     * @param celsius The temperature value in Celsius.
     */
    private Temperature(final float celsius) {
        checkTemperature(celsius);
        this.kelvin = convertCelsiusToKelvin(celsius);
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
                this.kelvin = convertCelsiusToKelvin(temperature);
                break;
            case KELVIN:
                checkTemperature(convertKelvinToCelsius(temperature));
                this.kelvin = temperature;
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
     * Checks if the given temperature value is within a valid range.
     *
     * @param temperature The temperature value to check.
     * @throws IllegalArgumentException If the temperature is below the valid range.
     */
    private void checkTemperature(final float temperature) {
        LOG.debug("Method: Begin");
        if (temperature < -KELVIN_OFFSET) {
            LOG.error("IllegalArgumentException caught! Please enter a valid temperature value.");
            throw new IllegalArgumentException("Invalid temperature value: " + temperature + " Celsius. Temperature should be greater than or equal to " + -KELVIN_OFFSET + " Celsius.");
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
        return kelvin - KELVIN_OFFSET;
    }

    /**
     * Converts a temperature value from Celsius to Kelvin.
     *
     * @param celsius The temperature value to convert in Celsius.
     * @return The temperature value converted in Kelvin.
     */
    public static float convertCelsiusToKelvin(final float celsius) {
        return celsius + KELVIN_OFFSET;
    }

    public float getKelvin() {
        return this.kelvin;
    }

    public float getCelsius() {
        return convertKelvinToCelsius(this.kelvin);
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature t)
                && Float.compare(t.kelvin, this.kelvin) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.kelvin);
    }

    @Override
    public int compareTo(final Temperature other) {
        if (this == other) {
            return 0;
        }
        return Float.compare(this.kelvin, other.kelvin);
    }
}
