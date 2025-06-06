package application.model.FadIndhold;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;

public class Fad {

    private int fadnummer;
    private String fadType;
    private double fadStørrelse;
    private int antalGangeBrugt;
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private LocalDate påfyldningsDato;
    private double mængdePåfyldt;
    private String påfyldtAf;
    private LocalDate tapningsDato;
    private String tappetAf;
    private boolean påLager;
    private HashMap<Fad, Double> omhældninger = new HashMap<>();

    public Fad(int nummer, String fadType, double fadStørrelse, int antalGangeBrugt) {
        this.fadnummer = nummer;
        this.fadType = fadType;
        this.fadStørrelse = fadStørrelse;
        this.antalGangeBrugt = antalGangeBrugt;
        this.påLager = false;
    }


    public void tilføjDestillat(Destillat destillat) {
        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
            this.påfyldningsDato = LocalDate.now();
        }
    }

    public void omhæld(Fad valgtFad, double omhældningMængde) {
        if (omhældningMængde > mængdePåfyldt) {
            throw new IllegalArgumentException("Ikke nok væske til at overføre fra fadet");
        }
        if (valgtFad.fadStørrelse - valgtFad.mængdePåfyldt < omhældningMængde) {
            throw new IllegalArgumentException("Ikke nok plads i det valgte fad");
        }

        //Trække mængden fra det tidligere fad fra og tilføjer det til det valgte fad
        valgtFad.mængdePåfyldt += omhældningMængde;
        this.mængdePåfyldt -= omhældningMængde;
        valgtFad.tilføjOmhældning(this, omhældningMængde);

        //Overfører destillater hvis fadet ikke indeholder destillatet fra det tidligere fad endnu
        for (Destillat destillat : destillater) {
            if (!valgtFad.destillater.contains(destillat)) {
                valgtFad.tilføjDestillat(destillat);
            }
        }
        if (mængdePåfyldt == 0){
            this.påfyldtAf = null;
            this.påfyldningsDato = null;
            destillater.clear();
        }
    }


    public int getFadnummer() {
        return fadnummer;
    }

    public ArrayList<Destillat> getDestillater() {
        return destillater;
    }

    public double getFadStørrelse() {
        return fadStørrelse;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public int getAntalGangeBrugt() {
        return antalGangeBrugt;
    }

    public String getType() {
        return fadType;
    }

    public double getMængdePåfyldt() {
        return mængdePåfyldt;
    }

    public void setMængdePåfyldt(double mængdePåfyldt) {
        this.mængdePåfyldt = mængdePåfyldt;
    }

    public void setPåfyldtAf(String påfyldtAf) {
        this.påfyldtAf = påfyldtAf;
    }

    public String getPåfyldtAf() {
        return påfyldtAf;
    }

    public void setTappetAf(String tappetAf) {
        this.tappetAf = tappetAf;
    }

    public String getTappetAf() {
        return tappetAf;
    }

    public LocalDate getTapningsDato() {
        return tapningsDato;
    }

    public void setTapningsDato(LocalDate tapningsDato) {
        this.tapningsDato = tapningsDato;
    }

    public void setPåfyldningsDato(LocalDate påfyldningsDato) {
        this.påfyldningsDato = påfyldningsDato;
    }

    public void setDestillater(ArrayList<Destillat> destillater) {
        this.destillater = destillater;
    }

    public void setPåLager(boolean påLager) {
        this.påLager = påLager;
    }

    public boolean isPåLager() {
        return påLager;
    }

    public void tilføjOmhældning(Fad fad, double mængde) {
        omhældninger.put(fad, mængde);
    }

    public HashMap<Fad, Double> getOmhældninger() {
        return omhældninger;
    }



    @Override
    public String toString() {
        if (destillater.isEmpty()) {
            return "Fadnummer: " + "F" + fadnummer + "\n" + "Fadtype: " + getType() + "\nFadstørrelse: " + fadStørrelse + " L" + "\nFadet er tomt" + "\n_________________________________________________________________________________";
        }
        else {
            return "Fadnummer: " + "F" + fadnummer + "\n" + "Fadtype: " + getType() + "\nVæske i fad: " + mængdePåfyldt + " L" + "\nFadstørrelse: " + fadStørrelse + " L" + "\nTid på Lager: " + ChronoUnit.YEARS.between(påfyldningsDato, LocalDate.now()) + " År" + "\n_________________________________________________________________________________";
        }
    }
}
