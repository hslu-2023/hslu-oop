package ch.hslu.oop.exam;

public enum MWST {

    Normal(8.1f), Reduziert(2.6f), Beherbergung(3.8f);

    private final float prozentSatz;

    private MWST(final float prozentSatz) {
        this.prozentSatz = prozentSatz;
    }

    public float getValue() {
        return this.prozentSatz;
    }

}
