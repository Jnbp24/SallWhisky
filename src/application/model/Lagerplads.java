package application.model;

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
        if (fad == null){
            this.fad = fad;
        }
    }

    public void fjernFad(){
        if (fad != null){
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
}
