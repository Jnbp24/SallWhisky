package application.model;

public class Kornsort extends Råvarer {
    private Ristethed ristethed;


    public Kornsort(String navn, String lokation, double mængde, Ristethed ristethed) {
        super(navn, lokation, mængde);
        this.ristethed = ristethed;
    }

    public Ristethed getRistethed() {
        return ristethed;
    }

    @Override
    public String toString() {
        return super.getNavn();
    }
}
