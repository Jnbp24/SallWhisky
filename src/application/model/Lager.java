package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Lager {
    private String id;
    private ArrayList<Lagerplads> pladser = new ArrayList<>();

    public Lager(String id) {
        this.id = id;
//        for (int i = 0; i < antalPladser/3; i++) {
//            char c = 'a';
//            c +=i;
//            for (int j = 0; j < 3; j++) {
//                opretLagerplads(String.valueOf(c), j);
//            }
//
//        }
    }
    
    public void opretLagerplads(String reol, int hylde){
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getReol().equals(reol)){
                if (lagerplads.getHylde() == hylde){
                    throw new IllegalArgumentException("Plads findes allerede");
                }
            }
        }
        pladser.add(new Lagerplads(reol, hylde, this));
    }

    public Lagerplads findFad(int fadNummer){
        for (Lagerplads lagerplads : pladser) {
            if (lagerplads.getFad().getNummer() == fadNummer){
                return lagerplads;
            }
        }
        return null;
    }

    public ArrayList<Fad> findTapklar(){
        ArrayList<Fad> fade = new ArrayList<>();
        for (Lagerplads lagerplads : pladser) {
            if (ChronoUnit.YEARS.between(lagerplads.getFad().getPåfyldningsDato(), LocalDate.now()) >= 3){
                fade.add(lagerplads.getFad());
            }
        }
        return fade;
    }

    @Override
    public String toString() {
        return id;
    }
}
