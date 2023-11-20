package ch.hslu.oop.sw07;

import java.util.Objects;

public class Temperature implements Comparable<Temperature> {
    private float temperatureCelsius;

    public Temperature(float temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public float convertCelsiusToKelvin() {
        return this.temperatureCelsius + 273.15f;
    }

    public float convertCelsiusToFahrenheit() {
        return this.temperatureCelsius * 1.8f + 32f;
    }

    public void changeTemperatureBy(float changeValue) {
        this.temperatureCelsius += changeValue;
    }

    public float getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public void setTemperatureCelsius(float temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature t)
                && Float.compare(t.temperatureCelsius, this.temperatureCelsius) == 0;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.temperatureCelsius);
    }

    @Override
    public int compareTo(final Temperature other) {
        if (this == other){
            return 0;
        }
        return Float.compare(this.temperatureCelsius, other.temperatureCelsius);
    }
}
