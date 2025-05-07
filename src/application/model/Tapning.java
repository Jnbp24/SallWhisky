package application.model;

import java.util.ArrayList;

public class Tapning {
    private Fad fad;

    public Tapning(Fad fad) {
        this.fad = fad;
    }

    public double udregnFlaskeEstimat(double fortyndelsesLiter, double flaskeStørrelse) {
        return (fad.getMængdePåfyldt() + fortyndelsesLiter) / flaskeStørrelse;
    }

    public Batch opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter) {
        ArrayList<Råvarer> kornsorter = new ArrayList<>();
        for (Destillat destillat : fad.getDestillater()) {
            kornsorter.add(destillat.getKornsort());
        }
        return new Batch(kornsorter, fad.getFadType(), batchNummer, batchNavn, fortyndelsesLiter);

    }

    public Fad getFad() {
        return fad;
    }
}
