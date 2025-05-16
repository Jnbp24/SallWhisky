package application.model.BatchIndhold;

public class Flaske {
    private double flaskeStørrelseILiter;
    private int flaskeID;
    private String batchNavn;

    public Flaske(double flaskeStørrelseILiter,String batchNavn, int flaskeID) {
        this.flaskeStørrelseILiter = flaskeStørrelseILiter;
        this.flaskeID = flaskeID;
        this.batchNavn = batchNavn;
    }

    public double getFlaskeStørrelseILiter() {
        return flaskeStørrelseILiter;
    }

    @Override
    public String toString() {
        return "FlaskeId: " + flaskeID + " Flaskestørrelse: " + flaskeStørrelseILiter;
    }
}
