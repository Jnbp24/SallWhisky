package application.model;

public class Råvarer {
    private Kornsort kornsort;
    private Vand vand;
    private String navn;
    private String lokation;



    public Råvarer(String navn, String lokation) {
        this.navn = navn;
        this.lokation = lokation;
    }
}
