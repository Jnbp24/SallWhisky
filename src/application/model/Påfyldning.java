package application.model;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;

public class Påfyldning {
    private double resterendeVolume;
    private Fad fad;
    private ArrayList<Destillat> destillater = new ArrayList<>();

    public Påfyldning(Fad fad) {
        this.fad = fad;
        resterendeVolume = fad.getFadStørrelse();
    }

    public double tilføjDestillat(Destillat destillat){
        if (resterendeVolume - destillat.getVand().getMængde() >= 0){
            destillater.add(destillat);
            resterendeVolume -= destillat.getVand().getMængde();
        } else {
            throw new IllegalArgumentException("");
        }
        return resterendeVolume;
    }

    public double fjernDestillat(Destillat destillat){
        if (destillater.contains(destillat)){
            destillater.remove(destillat);
            resterendeVolume += destillat.getVand().getMængde();
        } // måske også exeption her
        return resterendeVolume;
    }

    public void færdiggørPåfyldning(){
        if (!destillater.isEmpty()){
            for (Destillat destillat : destillater) {
                fad.tilføjDestillat(destillat);
            }
        }
    }
}
