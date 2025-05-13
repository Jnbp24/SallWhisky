package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Fad {

    private int nummer;
    private String fadType;
    private double fadStørrelse;
    private int antalGangeBrugt;
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private ArrayList<String> påfyldninger = new ArrayList<String>();
    private ArrayList<String> historik = new ArrayList<>();
    private LocalDate påfyldningsDato;
    private double mængdePåfyldt;
    private String påfyldtAf;
    private LocalDate tapningsDato;
    private String tappetAf;

    public Fad(int nummer, String fadType, double fadStørrelse, int antalGangeBrugt) {
        this.nummer = nummer;
        this.fadType = fadType;
        this.fadStørrelse = fadStørrelse;
        this.antalGangeBrugt = antalGangeBrugt;
    }


    public void tilføjDestillat(Destillat destillat) {
        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
            this.påfyldningsDato = LocalDate.now();
        }
        else
            throw new IllegalArgumentException("Dette fad indeholder allerede dette destillat");
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

        //Overfører destillater hvis fadet ikke indeholder destillatet fra det tidligere fad endnu
        for (Destillat destillat : destillater) {
            if (!valgtFad.destillater.contains(destillat)) {
                valgtFad.tilføjDestillat(destillat);
                this.destillater.remove(destillat);
            }
        }

        String historikIndtastning = "Overført " + omhældningMængde + " L til " + valgtFad.getNummer() + " med størrelse " + valgtFad.getFadStørrelse();
        this.historik.add(historikIndtastning);
        valgtFad.historik.add("Modtaget " + omhældningMængde + " L fra " + this.getNummer() + " med størrelsen " + this.fadStørrelse);
    }


    public int getNummer() {
        return nummer;
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
        påfyldninger.add(this.påfyldtAf);
    }

    public ArrayList<String> getPåfyldninger() {
        return påfyldninger;
    }

    public void setTappetAf(String tappetAf) {
        this.tappetAf = tappetAf;
    }

    public void setTapningsDato(LocalDate tapningsDato) {
        this.tapningsDato = tapningsDato;
    }

    @Override
    public String toString() {
        if (destillater.isEmpty()) {
            return "Fadnummer: " + "F" + nummer + "\n" + "Fadtype: " + getType() + "\n" + "Tid på Lager: Ikke påfyldt endnu";
        }
        else {
            return "Fadnummer: " + "F" + nummer + "\n" + "Fadtype: " + getType() + "\n" + "Tid på Lager: " + ChronoUnit.YEARS.between(påfyldningsDato, LocalDate.now()) + " År";
        }
    }

}
