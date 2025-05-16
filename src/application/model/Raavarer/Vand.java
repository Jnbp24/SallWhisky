package application.model.Raavarer;

public class Vand implements IRaavarer {
    private String navn;
    private String lokation;
    private double mængde;

    public Vand(String navn, String lokation, double mængde) {
        this.navn = navn;
        this.lokation = lokation;
        this.mængde = mængde;
    }

    @Override
    public String getNavn() {
        return navn;
    }

    @Override
    public String getLokation() {
        return lokation;
    }

    @Override
    public double getMængde() {
        return mængde;
    }

    @Override
    public String toString() {
        return navn + "\nLokation: " + lokation + "\nMængde: " + mængde;
    }
}



