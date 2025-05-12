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

    public Lagerplads findFad(int fadNummer) {
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getFad().getNummer() == fadNummer) {
                return lagerplads;
            }
        }
        return null;
    }

    public ArrayList<Fad> findTapklar() {
        ArrayList<Fad> fade = new ArrayList<>();
        for (Lagerplads lagerplads : pladser) {
            if (ChronoUnit.YEARS.between(lagerplads.getFad().getPåfyldningsDato(), LocalDate.now()) >= 3) {
                fade.add(lagerplads.getFad());
            }
        }
        return fade;
    }

    public ArrayList<Lagerplads> getPladser() {
        return pladser;
    }

    @Override
    public String toString() {
        return id;
    }
}
