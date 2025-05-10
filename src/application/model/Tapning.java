package application.model;

import javafx.geometry.Orientation;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tapning {
    private Fad fad;
    private Medarbejder medarbejder;

    public Tapning(Fad fad, Medarbejder medarbejder) {
        this.fad = fad;
        this.medarbejder = medarbejder;
    }

    public double udregnFlaskeEstimat(double fortyndelsesLiter, double flaskeStørrelse) {
        return (fad.getMængdePåfyldt() + fortyndelsesLiter) / flaskeStørrelse;
    }

    public Batch opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter, double flaskeStørrelse) {
        fad.setTapningsDato(LocalDate.now());
        fad.setTappetAf(medarbejder.getNavn());

        ArrayList<Råvarer> kornsorter = new ArrayList<>();
        for (Destillat destillat : fad.getDestillater()) {
            kornsorter.add(destillat.getKornsort());
        }
        int antalFlasker = (int) udregnFlaskeEstimat(fortyndelsesLiter, flaskeStørrelse);
        Batch batch = new Batch(kornsorter, fad.getType(), batchNummer, batchNavn, fortyndelsesLiter);

        for (int i = 0; i < antalFlasker; i++) {
            Flaske flaske = new Flaske(flaskeStørrelse, batchNavn, i + 1);
            batch.tilføjFlaske(flaske);
        }
        return batch;
    }


    public Fad getFad() {
        return fad;
    }
}
