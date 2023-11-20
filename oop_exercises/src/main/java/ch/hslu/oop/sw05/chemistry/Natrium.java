package ch.hslu.oop.sw05.chemistry;

import ch.hslu.oop.sw05.chemistry.ChemicalElement;

public class Natrium extends ChemicalElement {

    public Natrium(float temperatureCelsius) {
        // Natrium-specific boiling point and melting point values
        super(temperatureCelsius, 883, 98);
    }

}
