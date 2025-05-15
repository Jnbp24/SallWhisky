package application.model.BatchIndhold;


import application.model.Raavarer.Kornsort;
import application.model.FadVæskeKontrol.Tapning;

import java.util.ArrayList;

public class Batch {
    private ArrayList<Kornsort> kornsorter;

    private String fadtype;
    private int batchNummer;
    private String batchNavn;
    private double fortyndelseLiter;
    private Tapning tapning;
    private ArrayList<Flaske> flasker = new ArrayList<>();

    public Batch(ArrayList<Kornsort> kornsorter, String fadtype, int batchNummer, String batchNavn, double fortyndelseLiter, Tapning tapning) {
        this.kornsorter = kornsorter;
        this.fadtype = fadtype;
        this.batchNummer = batchNummer;
        this.batchNavn = batchNavn;
        this.fortyndelseLiter = fortyndelseLiter;
        this.tapning = tapning;
    }

    public int getBatchNummer() {
        return batchNummer;
    }

    public String getBatchNavn() {
        return batchNavn;
    }

    public ArrayList<Kornsort> getKornsorter() {
        return kornsorter;
    }

    public String getFadtype() {
        return fadtype;
    }

    public double getFortyndelseLiter() {
        return fortyndelseLiter;
    }

    public Tapning getTapning() {
        return tapning;
    }

    public void tilføjFlaske(Flaske flaske) {
        if (!flasker.contains(flaske)) {
            flasker.add(flaske);
        }
    }

    public ArrayList<Flaske> getFlasker() {
        return flasker;
    }

    @Override
    public String toString() {
        return "Batchnummer: " + "B" + batchNummer + "\n " + " Batchnavn: " + batchNavn;
    }
}
