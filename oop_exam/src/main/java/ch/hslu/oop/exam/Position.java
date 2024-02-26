package ch.hslu.oop.exam;

final public class Position {
    private final Artikel artikel;
    private final int menge;

    public Position(Artikel artikel, int menge) {
        this.artikel = artikel;
        this.menge = menge;
    }

    public Position(Artikel artikel) {
        this.artikel = artikel;
        this.menge = 1;
    }

    public final Artikel getArtikel() {
        return this.artikel;
    }

    public final int getMenge() {
        return this.menge;
    }
}
