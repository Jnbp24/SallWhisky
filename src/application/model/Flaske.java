package application.model;

public class Flaske {
    private double flaskeStørrelseILiter;
    private int flaskeID;
    private String batchNavn;

    public Flaske(double flaskeStørrelseILiter,String batchNavn, int flaskeID) {
        this.flaskeStørrelseILiter = flaskeStørrelseILiter;
        this.flaskeID = flaskeID;
        this.batchNavn = batchNavn;
    }
}
