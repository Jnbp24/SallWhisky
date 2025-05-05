package application.model;

public class Vand extends Råvarer {
    public Vand(String navn, String lokation, int mængde) {
        super(navn, lokation, mængde);
    }

    @Override
    public String toString() {
        return "Navn: " + super.getNavn();
    }
}
