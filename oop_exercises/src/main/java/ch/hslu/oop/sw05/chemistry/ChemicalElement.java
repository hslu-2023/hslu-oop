package ch.hslu.oop.sw05.chemistry;

public abstract class ChemicalElement {

    private final float temperatureCelsius;
    private final float boilingPoint;
    private final  float meltingPoint;

    public ChemicalElement( float temperatureCelsius, float boilingPoint, float meltingPoint){
        this.temperatureCelsius = temperatureCelsius;
        this.boilingPoint = boilingPoint;
        this.meltingPoint = meltingPoint;
    }

    public final String getPhysicalState(){
        if (temperatureCelsius <= meltingPoint) {
            return "solid";
        } else if (temperatureCelsius >= boilingPoint) {
            return "gaseous";
        } else {
            return "liquid";
        }
    };

    public float getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public float getBoilingPoint() {
        return this.boilingPoint;
    }

    public float getMeltingPoint() {
        return this.meltingPoint;
    }
}
