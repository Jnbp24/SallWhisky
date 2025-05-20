package application.model.Lager;

import application.model.FadIndhold.Destillat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Lager {
    private String id;
    private ArrayList<Lagerplads> pladser = new ArrayList<>();

    public Lager(String id) {
        this.id = id;
    }

    public void opretLagerplads(String reol, int hylde) {
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getReol().equals(reol)) {
                if (lagerplads.getHylde() == hylde) {
                    throw new IllegalArgumentException("Plads findes allerede");
                }
            }
        }
        pladser.add(new Lagerplads(reol, hylde, this));
    }

    public Lagerplads findFadPåFadNummer(int fadNummer) {
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getFad().getFadnummer() == fadNummer) {
                return lagerplads;
            }
        }
        return null;
    }

    public ArrayList<Lagerplads> findFadPåNmNummer(String newMakeNummer){
        ArrayList<Lagerplads> pladserTilRetur = new ArrayList<>();
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getFad() != null){
                for (Destillat destillat : lagerplads.getFad().getDestillater()) {
                    if (destillat.getNmNummer().equals(newMakeNummer)){
                        pladserTilRetur.add(lagerplads);
                    }
                }
            }
        }
        return pladserTilRetur;
    }

    public ArrayList<Lagerplads> findTapklar() {
        ArrayList<Lagerplads> lagerpladser = new ArrayList<>();
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getFad() != null && lagerplads.getFad().getPåfyldningsDato()!=null && ChronoUnit.YEARS.between(lagerplads.getFad().getPåfyldningsDato(), LocalDate.now()) >= 3) {
                lagerpladser.add(lagerplads);
            }
        }
        return lagerpladser;
    }

    public ArrayList<Lagerplads> getPladser() {
        return pladser;
    }

    @Override
    public String toString() {
        return id;
    }
}
