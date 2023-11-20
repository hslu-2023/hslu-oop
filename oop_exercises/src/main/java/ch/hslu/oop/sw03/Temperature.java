package ch.hslu.oop.sw03;

public class Temperature {
    private float temperatureCelsius;
    public Temperature(float temperatureCelsius){
        this.temperatureCelsius = temperatureCelsius;
    }

    /*
    public String getPhysicalState(String chemicalElement) {
        float boilingPoint;
        float meltingPoint;
        switch (chemicalElement) {
            case "N":
                boilingPoint = -195.8f;
                meltingPoint = 210f;
                return comparePoints(temperatureCelsius, meltingPoint, boilingPoint);
            case "Hg":
                boilingPoint = 356.7f;
                meltingPoint = 38.83f;
                return comparePoints(temperatureCelsius, meltingPoint, boilingPoint);
            case "Pb":
                boilingPoint = 1.749f;
                meltingPoint = 327.5f;
                return comparePoints(temperatureCelsius, meltingPoint, boilingPoint);
            default:
                return "Unknown";
        }
    }

    private String comparePoints(float temperatureCelsius, float meltingPoint, float boilingPoint){
        if (temperatureCelsius >= meltingPoint) {
            return "liquid";
        } else if (temperatureCelsius <= boilingPoint) {
            return "gaseous";
        } else {
            return "solid";
        }
    }

     */

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

}
