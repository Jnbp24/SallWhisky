package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Fad {

    private int nummer;
    private String fadType;
    private double fadStørrelse;
    private int antalGangeBrugt;
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private LocalDate påfyldningsdato;

    public Fad(int nummer, String fadType, int fadStørrelse, int antalGangeBrugt) {
        this.nummer = nummer;
        this.fadType = fadType;
        this.fadStørrelse = fadStørrelse;
        this.antalGangeBrugt = antalGangeBrugt;
    }

    public void tilføjDestillat(Destillat destillat){
        if(!destillater.contains(destillat)){
            destillater.add(destillat);
            this.påfyldningsdato = LocalDate.now();
        }
        else{
            throw new IllegalArgumentException("Dette fad indeholder allerede dette destillat");
        }
    }

    public ArrayList<Destillat> getDestillater(){
        return destillater;
    }
    public LocalDate getPåfyldningsdato(){
        return påfyldningsdato;
    }

    public String getFadType() {
        return fadType;
    }



}
