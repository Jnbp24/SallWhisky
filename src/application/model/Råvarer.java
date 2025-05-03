package application.model;

public abstract class Råvarer {

    private String navn;
    private String lokation;
    private int mængde;

    public Råvarer(String navn, String lokation, int mængde) {
        this.navn = navn;
        this.lokation = lokation;
        this.mængde = mængde;
    }

    public String getNavn() {
        return navn;
    }

    public String getLokation() {
        return lokation;
    }

    public int getMængde() {
        return mængde;
    }
}
