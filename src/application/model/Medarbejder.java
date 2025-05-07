package application.model;

public class Medarbejder {
    private int medarbejderNr;
    private String navn;

    public Medarbejder(int medarbejderNr, String navn) {
        this.medarbejderNr = medarbejderNr;
        this.navn = navn;
    }

    public int getMedarbejderNr() {
        return medarbejderNr;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Nr: " + medarbejderNr + " Navn: " + navn;
    }
}
