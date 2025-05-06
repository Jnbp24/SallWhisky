package application.model;

import java.util.ArrayList;

public class Påfyldning {
    private double resterendeVolume;
    private Fad fad;
    private ArrayList<Destillat> destillater = new ArrayList<>();

    public Påfyldning(Fad fad) {
        this.fad = fad;
        resterendeVolume = fad.getFadStørrelse();
    }

    public double tilføjDestillat(Destillat destillat, double mængdeFraDestillat) {
        if (mængdeFraDestillat <= destillat.getMængdeLiter()) {
            if (resterendeVolume - destillat.getVand().getMængde() >= 0) {
                destillater.add(destillat);
                resterendeVolume -= destillat.getVand().getMængde();
            } else {
                throw new IllegalArgumentException("Ikke nok plads i fadet");
            }
        }else {
            throw new IllegalArgumentException("Ikke nok væske i destillatet");
        }
        return mængdeFraDestillat;
    }

    public double fjernDestillat(Destillat destillat) {
        if (destillater.contains(destillat)) {
            destillater.remove(destillat);
            resterendeVolume += destillat.getVand().getMængde();
        } // måske også exeption her
        return resterendeVolume;
    }

    public void færdiggørPåfyldning() {
        if (!destillater.isEmpty()) {
            for (Destillat destillat : destillater) {
                fad.tilføjDestillat(destillat);
            }
        }
    }
}
