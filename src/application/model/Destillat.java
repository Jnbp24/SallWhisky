package application.model;

public class Destillat {
    private String nmNummer;
    private double alkoholProcent;
    private Råvarer kornsort;
    private Råvarer vand;
    private boolean brugtTørv;
    private double mængdeLiter;

    public Destillat(String nmNummer, double alkoholProcent, Råvarer kornsort, Råvarer vand, boolean brugtTørv) {
        this.nmNummer = nmNummer;
        this.alkoholProcent = alkoholProcent;
        this.kornsort = kornsort;
        this.vand = vand;
        this.brugtTørv = brugtTørv;
        mængdeLiter = vand.getMængde();
    }


    public Råvarer getKornsort() {
        return kornsort;
    }

    public Råvarer getVand() {
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
        return "Destillat: " + nmNummer + "\n" + "Kornsort: " + kornsort + "\n" + "Vand: " + getVand() + "\n" + "Alkohol procent: " + getAlkoholProcent() + "%" + "\n" + "Tørv: " + getTørv() + "\n" + vand.getMængde();
    }
}
