package application.model.BatchIndhold;


import application.model.Raavarer.Kornsort;
import application.model.FadVæskeKontrol.Tapning;

import java.util.ArrayList;

public class Batch {
    private ArrayList<Kornsort> kornsorter;
    private ArrayList<String> fadtyper = new ArrayList<>();
    private int batchNummer;
    private String batchNavn;
    private double fortyndelseLiter;
    private Tapning tapning;
    private ArrayList<Flaske> flasker = new ArrayList<>();
    private boolean fåetKvalitetsStempel;
    private WhiskyTyper whiskyType;

    public Batch(ArrayList<Kornsort> kornsorter, int batchNummer, String batchNavn, double fortyndelseLiter, Tapning tapning) {
        this.kornsorter = kornsorter;
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

    public ArrayList<String> getFadtyper() {
        return fadtyper;
    }

    public void tilføjFadtype(String fadtype){
        if (!fadtyper.contains(fadtype)){
            fadtyper.add(fadtype);
        }
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

    public void setFåetKvalitetsStempel(boolean fåetKvalitetsStempel) {
        this.fåetKvalitetsStempel = fåetKvalitetsStempel;
    }

    public boolean harFåetKvalitetsStempel() {
        return fåetKvalitetsStempel;
    }

    public ArrayList<Flaske> getFlasker() {
        return flasker;
    }

    public void setWhiskyType(WhiskyTyper whiskyType) {
        this.whiskyType = whiskyType;
    }

    public WhiskyTyper getWhiskyType() {
        return whiskyType;
    }

    @Override
    public String toString() {
        return "Batchnummer: " + "B" + batchNummer + "\n" + "Batchnavn: " + batchNavn + "\n" + whiskyType.getDisplay() + "\n______________________________________________";
    }
}
