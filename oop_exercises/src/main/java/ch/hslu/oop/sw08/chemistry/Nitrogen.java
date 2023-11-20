package ch.hslu.oop.sw08.chemistry;

public class Nitrogen extends ChemicalElement {

    public Nitrogen(float temperatureCelsius) {
        super(temperatureCelsius, 883, 98);
    }

    @Override
    public String toString() {
        return super.toString() + " (POISONOUS)";
    }
}
