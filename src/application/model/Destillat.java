package application.model;

public class Destillat {
    private String nmNummer;
    private double alkoholProcent;
    private Råvarer kornsort;
    private Råvarer vand;
    private boolean brugtTørv;

    public Destillat(String nmNummer, double alkoholProcent, Råvarer kornsort, Råvarer vand, boolean brugtTørv) {
        this.nmNummer = nmNummer;
        this.alkoholProcent = alkoholProcent;
        this.kornsort = kornsort;
        this.vand = vand;
        this.brugtTørv = brugtTørv;
    }

    public Råvarer getKornsort() {
        return kornsort;
    }

    public Råvarer getVand() {
        return vand;
    }
}
