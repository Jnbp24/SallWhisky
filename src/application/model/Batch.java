package application.model;


import java.util.ArrayList;

public class Batch implements Information {
    private ArrayList<Råvarer> kornsorter;
    private String fadtype;
    private int batchNummer;
    private String batchNavn;
    private double fortyndelseLiter;
    private Tapning tapning;
    private ArrayList<Flaske> flasker = new ArrayList<>();

    public Batch(ArrayList<Råvarer> kornsorter, String fadtype, int batchNummer, String batchNavn, double fortyndelseLiter) {
        this.kornsorter = kornsorter;
        this.fadtype = fadtype;
        this.batchNummer = batchNummer;
        this.batchNavn = batchNavn;
        this.fortyndelseLiter = fortyndelseLiter;
    }

    public int getBatchNummer() {
        return batchNummer;
    }

    public String getBatchNavn() {
        return batchNavn;
    }

    @Override
    public String getId() {
        return "Batch-" + batchNummer;
    }

    @Override
    public String getBeskrivelse() {
        return "Batch navn: " + batchNavn;
    }

    public void tilføjFlaske(Flaske flaske){
        if (!flasker.contains(flaske)){
            flasker.add(flaske);
        }
    }
}
