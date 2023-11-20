package ch.hslu.oop.sw08.chemistry;

import java.util.Objects;

public abstract class ChemicalElement implements Comparable<ChemicalElement> {

    private final float temperatureCelsius;
    private final float boilingPoint;
    private final float meltingPoint;

    public ChemicalElement(float temperatureCelsius, float boilingPoint, float meltingPoint) {
        this.temperatureCelsius = temperatureCelsius;
        this.boilingPoint = boilingPoint;
        this.meltingPoint = meltingPoint;
    }

    public final String getPhysicalState() {
        if (temperatureCelsius <= meltingPoint) {
            return PhysicalState.SOLID.getResult(this, temperatureCelsius);
        } else if (temperatureCelsius >= boilingPoint) {
            return PhysicalState.SOLID.getResult(this, temperatureCelsius);
        } else {
            return PhysicalState.SOLID.getResult(this, temperatureCelsius);
        }
    }

    public float getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public float getBoilingPoint() {
        return this.boilingPoint;
    }

    public float getMeltingPoint() {
        return this.meltingPoint;
    }

    @Override
    public String toString() {
        return "ChemicalElement{" +
                "temperatureCelsius=" + temperatureCelsius +
                ", boilingPoint=" + boilingPoint +
                ", meltingPoint=" + meltingPoint +
                '}';
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        return object.getClass() == this.getClass();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public int compareTo(final ChemicalElement other) {
        if (this == other) {
            return 0;
        }
        return Float.compare(this.temperatureCelsius, other.temperatureCelsius);
    }
}
