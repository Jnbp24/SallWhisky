package application.model;

public class Vand extends Råvarer {
    public Vand(String navn, String lokation, double mængde) {
        super(navn, lokation, mængde);
    }


    @Override
    public String toString() {
        return super.getNavn();
    }
}
