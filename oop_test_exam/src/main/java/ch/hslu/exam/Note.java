package ch.hslu.exam;

public enum Note {

    A(6.0f), B(5.5f), C(5.0f), D(4.5f), E(4.0f), F(3.0f);

    private final float gradeValue;

    private Note(final float gradeValue) {
        this.gradeValue = gradeValue;
    }

    public final float getGradValue() {
        return this.gradeValue;
    }

}
