package application.model;


import java.util.ArrayList;

public class Batch {
    private ArrayList<Råvarer> kornsorter;
    private String fadtype;
    private int batchNummer;
    private String batchNavn;
    private double fortyndelseLiter;

    public Batch(ArrayList<Råvarer> kornsorter, String fadtype, int batchNummer, String batchNavn, double fortyndelseLiter) {
        this.kornsorter = kornsorter;
        this.fadtype = fadtype;
        this.batchNummer = batchNummer;
        this.batchNavn = batchNavn;
        this.fortyndelseLiter = fortyndelseLiter;
    }
}
