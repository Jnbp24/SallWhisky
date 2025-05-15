package application.model.Lager;

import application.model.FadIndhold.Fad;

public class Lagerplads {
    private String reol;
    private int hylde;
    private Fad fad;
    private Lager lager;

    public Lagerplads(String reol, int hylde, Lager lager) {
        this.reol = reol;
        this.hylde = hylde;
        this.lager = lager;
    }

    public void placerFad(Fad fad){
        if (this.fad == null){
            this.fad = fad;
        }
        fad.setPåLager(true);
    }

    public void fjernFad(){
        if (fad != null){
            fad.setPåLager(false);
            fad = null;
        }
    }

    public String getReol() {
        return reol;
    }

    public int getHylde() {
        return hylde;
    }

    public Fad getFad() {
        return fad;
    }

    public Lager getLager() {
        return lager;
    }

    @Override
    public String toString() {
        if (fad == null){
            return lager + "\nReol : " + reol + "\nHylde: " + hylde + "\n -Ledig-";
        }
        else{
            return lager + "\nReol : " + reol + "\nHylde: " + hylde + "\n" + fad;
        }
    }
}
