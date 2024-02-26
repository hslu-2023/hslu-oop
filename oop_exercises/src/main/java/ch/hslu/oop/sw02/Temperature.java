package ch.hslu.oop.sw02;

public class Temperature {
    private float temperatureCelsius = 20f;

    /*
    public Temperature(float temperatureCelsius){
        this.temperatureCelsius = temperatureCelsius;
    }*/

    public float convertCelsiusToKelvin() {
        return this.temperatureCelsius + 273.15f;
    }

    public float convertCelsiusToFahrenheit() {
        return this.temperatureCelsius * 1.8f + 32f;
    }

    public void changeTemperatureBy(final float changeValue) {
        this.temperatureCelsius += changeValue;
    }

    public float getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public void setTemperatureCelsius(final float temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

}
