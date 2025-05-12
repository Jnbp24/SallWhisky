package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

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
            if (lagerplads.getFad().getNummer() == fadNummer) {
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
            if (lagerplads.getFad() != null && ChronoUnit.YEARS.between(lagerplads.getFad().getPåfyldningsDato(), LocalDate.now()) >= 3) {
                lagerpladser.add(lagerplads);
            }
        }
        return lagerpladser;
    }

    public ArrayList<Lagerplads> getPladser() {
        return new ArrayList<>(pladser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lager lager = (Lager) obj;
        return Objects.equals(id, lager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return id;
    }
}
