package application.model.FadIndhold;

import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Vand;

public class Destillat {
    private String nmNummer;
    private double alkoholProcent;
    private Kornsort kornsort;
    private Vand vand;
    private boolean brugtTørv;
    private double mængdeLiter;

    public Destillat(String nmNummer, double alkoholProcent, Kornsort kornsort, Vand vand, boolean brugtTørv) {
        this.nmNummer = nmNummer.toUpperCase();
        this.alkoholProcent = alkoholProcent;
        this.kornsort = kornsort;
        this.vand = vand;
        this.brugtTørv = brugtTørv;
        setMængdeLiter(vand.getMængde());
    }


    public Kornsort getKornsort() {
        return kornsort;
    }

    public Vand getVand() {
        return vand;
    }

    public double getMængdeLiter() {
        return mængdeLiter;
    }

    public void setMængdeLiter(double mængdeLiter) {
        this.mængdeLiter = mængdeLiter;
    }

    public String getTørv() {
        if (brugtTørv) {
            return "Ja";
        }
        return "Nej";
    }

    public String getNmNummer() {
        return nmNummer;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public boolean isBrugtTørv() {
        return brugtTørv;
    }

    @Override
    public String toString() {
        return "Destillat: " + nmNummer + "\n\n" + "Kornsort: " + kornsort + "\n\n" + "Vand: " + getVand() + "\n\n" + "Alkohol procent: " + getAlkoholProcent() + "%" + "\n\n" + "Tørv: " + getTørv() + "\n\n" + "Mængde i liter: " + mængdeLiter + "\n___________________________________________";
    }
}
