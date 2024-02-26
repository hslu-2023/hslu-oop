package ch.hslu.oop.exam;

import java.util.Objects;

public final class Artikel {

    private final String bezeichnung;

    /**
     * Float should never be used as a datatype for money values.
     * The reason is, say we want to store 0.1 euros, any floating-point data type can not store it as is, it get's stored as an approximation (0.10000000149….)
     * The max value to be saved with a float would be 3.40282347E+38
     */
    private final float preis;

    private final MWST mwst;

    public Artikel(final String bezeichnung, final float preis) {
        if (bezeichnung == null || bezeichnung.isEmpty()) {
            throw new NullPointerException("NullPointerException caught! Please enter a valid description value.");
        }
        if (bezeichnung.length() < 2) {
            throw new IllegalArgumentException("IllegalArgumentException caught! Please enter a bezeichnung value with more than 2 characters.");
        }
        if (preis <= 0.0f) {
            throw new IllegalArgumentException("IllegalArgumentException caught! Please enter a positive price value higher than 0.0f");
        }
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.mwst = MWST.Normal;
    }

    public Artikel(final String bezeichnung, final float preis, final MWST mwst) {
        if (bezeichnung == null || bezeichnung.isEmpty()) {
            throw new NullPointerException("NullPointerException caught! Please enter a valid description value.");
        }
        if (bezeichnung.length() < 2) {
            throw new IllegalArgumentException("IllegalArgumentException caught! Please enter a bezeichnung value with more than 2 characters.");
        }
        if (preis <= 0.0f) {
            throw new IllegalArgumentException("IllegalArgumentException caught! Please enter a positive price value higher than 0.0f");
        }
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.mwst = mwst;
    }

    public final float calculateArtikelNettoPreis(){
        return this.preis;
    }

    public final float calculateArtikelBruttoPreis(){
        return this.preis * this.getMwst().getValue();
    }

    public final String getBezeichnung() {
        return this.bezeichnung;
    }

    public final float getPreis() {
        return this.preis;
    }

    public final MWST getMwst() {
        return this.mwst;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Artikel a)
                && (Objects.equals(a.bezeichnung, this.bezeichnung));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bezeichnung);
    }
}
