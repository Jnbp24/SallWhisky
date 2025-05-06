package application.model;

public abstract class Råvarer {

    private String navn;
    private String lokation;
    private double mængde;

    public Råvarer(String navn, String lokation, double mængde) {
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

    public double getMængde() {
        return mængde;
    }
}
