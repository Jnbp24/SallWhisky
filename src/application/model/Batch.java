package application.model;


import java.util.ArrayList;

public class Batch implements Information {
    private ArrayList<Råvarer> kornsorter;
    private String fadtype;
    private int batchNummer;
    private String batchNavn;
    private double fortyndelseLiter;
    private Tapning tapning;

    public Batch(ArrayList<Råvarer> kornsorter, String fadtype, int batchNummer, String batchNavn, double fortyndelseLiter) {
        this.kornsorter = kornsorter;
        this.fadtype = fadtype;
        this.batchNummer = batchNummer;
        this.batchNavn = batchNavn;
        this.fortyndelseLiter = fortyndelseLiter;
    }


    @Override
    public String getId() {
        return "Batch-" + batchNummer;
    }

    @Override
    public String getDescription() {
        return "Batch navn: " + batchNavn;
    }
}
