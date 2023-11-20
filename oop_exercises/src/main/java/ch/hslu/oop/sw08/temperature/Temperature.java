package ch.hslu.oop.sw08.temperature;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {
    private float kelvin;
    private static final float KELVIN_OFFSET = 273.15f;

    public Temperature(float celsius) {
        this.kelvin = convertCelsiusToKelvin(celsius);
    }

    public Temperature(Temperature temperature) {
        this.kelvin = temperature.getKelvin();
    }

    public float getKelvin() {
        return this.kelvin;
    }

    public float getCelsius() {
        return convertKelvinToCelsius(this.kelvin);
    }

    public void setKelvin(float kelvin) {
        this.kelvin = kelvin;
    }

    public void setCelsius(float celsius) {
        this.kelvin = convertCelsiusToKelvin(celsius);
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

    public static float convertKelvinToCelsius(final float kelvin) {
        return kelvin - KELVIN_OFFSET;
    }
    public static float convertCelsiusToKelvin(final float celsius) {
        return celsius + KELVIN_OFFSET;
    }

}
