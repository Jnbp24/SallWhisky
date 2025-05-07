package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Fad implements Information{

    private int nummer;
    private String fadType;
    private double fadStørrelse;
    private int antalGangeBrugt;
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private LocalDate påfyldningsDato;
    private double mængdePåfyldt;
    private String påfyldtAf;

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

    public ArrayList<Destillat> getDestillater() {
        return destillater;
    }

    public String getFadType() {
        return fadType;
    }
    public double getFadStørrelse() {
        return fadStørrelse;
    }

    @Override
    public String getId() {
        return "F" + nummer;
    }

    @Override
    public String getDescription() {
        return "Fadtype: " + fadType;
    }

    public LocalDate getPåfyldningsDato() {
        return påfyldningsDato;
    }

    public int getAntalGangeBrugt() {
        return antalGangeBrugt;
    }

    @Override
    public String toString() {
        return "Fad: " + nummer;
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
}
