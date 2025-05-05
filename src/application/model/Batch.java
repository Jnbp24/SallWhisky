package application.model;


public class Batch {
    private Råvarer kornsort;
    private String fadtype;
    private int batchNummer;
    private String batchNavn;
    private double fortyndelseLiter;

    public Batch(Råvarer kornsort, String fadtype, int batchNummer, String batchNavn, double fortyndelseLiter) {
        this.kornsort = kornsort;
        this.fadtype = fadtype;
        this.batchNummer = batchNummer;
        this.batchNavn = batchNavn;
        this.fortyndelseLiter = fortyndelseLiter;
    }
}
