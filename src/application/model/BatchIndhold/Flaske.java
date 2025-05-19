package application.model.BatchIndhold;

public class Flaske {
    private double flaskeStørrelseILiter;
    private int flaskeID;
    private String batchNavn;
    private WhiskyTyper whiskyType;

    public Flaske(double flaskeStørrelseILiter,String batchNavn, int flaskeID, WhiskyTyper whiskyType) {
        this.flaskeStørrelseILiter = flaskeStørrelseILiter;
        this.flaskeID = flaskeID;
        this.batchNavn = batchNavn;
        this.whiskyType = whiskyType;
    }

    public double getFlaskeStørrelseILiter() {
        return flaskeStørrelseILiter;
    }

    @Override
    public String toString() {
        return "FlaskeId: " + flaskeID + " Flaskestørrelse: " + flaskeStørrelseILiter;
    }
}
