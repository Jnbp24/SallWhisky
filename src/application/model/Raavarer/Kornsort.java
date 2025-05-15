package application.model.Raavarer;

public class Kornsort implements IRaavarer {
    private String navn;
    private String lokation;
    private double mængde;
    private Ristethed ristethed;


    public Kornsort(String navn, String lokation, double mængde, Ristethed ristethed) {
        this.navn = navn;
        this.lokation = lokation;
        this.mængde = mængde;
        this.ristethed = ristethed;
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

    public String getRistethed() {
        this.ristethed = ristethed;
    }
}

