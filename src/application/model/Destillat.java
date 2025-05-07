package application.model;

public class Destillat implements Information {
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

    @Override
    public String getId() {
        return nmNummer;
    }

    @Override
    public String getDescription() {
        return "Alkohol Procent: " + alkoholProcent + "%";
    }
}
