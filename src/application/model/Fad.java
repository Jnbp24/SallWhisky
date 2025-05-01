package application.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Fad {
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private static ArrayList<Fad> tapklarFade = new ArrayList<>();
    private int nummer;
    private String fadType;
    private double fadStørrelse;
    private LocalDateTime påfyldningsDato;
    private int antalGangeBrugt;

    public Fad(int nummer, String fadType, int fadStørrelse, LocalDateTime påfyldningsDato, int antalGangeBrugt) {
        this.nummer = nummer;
        this.fadType = fadType;
        this.fadStørrelse = fadStørrelse;
        this.påfyldningsDato = påfyldningsDato;
        this.antalGangeBrugt = antalGangeBrugt;
    }

    private void tilføjDestillat(Destillat destillat) {
        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
        }
        else
            throw new IllegalArgumentException("Dette fad indeholder allerede dette destillat");
    }

    public boolean erTapKlar() {
        return ChronoUnit.YEARS.between(påfyldningsDato, LocalDateTime.now()) >= 3;
    }

    public static ArrayList<Fad> findTapKlarFad(ArrayList<Fad> fade) {
        for (Fad fad : fade) {
            if (fad.erTapKlar()) {
                tapklarFade.add(fad);
            }
        }
        return tapklarFade;
    }
}
