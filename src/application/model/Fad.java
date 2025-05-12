package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fad {

    private int nummer;
    private String fadType;
    private double fadStørrelse;
    private int antalGangeBrugt;
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private ArrayList<String> påfyldninger = new ArrayList<String>();
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

    public String getTappetAf() {
        return tappetAf;
    }

    public void setTappetAf(String tappetAf) {
        this.tappetAf = tappetAf;
    }

    public void setTapningsDato(LocalDate tapningsDato) {
        this.tapningsDato = tapningsDato;
    }

    @Override
    public String toString() {
        return "Fadnummer: " + "F" + nummer + "\n" + "Fadtype: " + getType();
    }

}
