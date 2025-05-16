package application.model.FadVæskeKontrol;

import application.model.BatchIndhold.Batch;
import application.model.BatchIndhold.Flaske;
import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.Medarbejdere.Medarbejder;
import application.model.Raavarer.Kornsort;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tapning {
    private Fad fad;
    private Medarbejder medarbejder;

    public Tapning() {
    }

    public double udregnFlaskeEstimat(double fortyndelsesLiter, double flaskeStørrelse) {
        return (fad.getMængdePåfyldt() + fortyndelsesLiter) / flaskeStørrelse;
    }

    public Batch opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter, double flaskeStørrelseILiter) {
        fad.setTapningsDato(LocalDate.now());
        fad.setTappetAf(medarbejder.getNavn());

        ArrayList<Kornsort> kornsorter = new ArrayList<>();
        for (Destillat destillat : fad.getDestillater()) {
            kornsorter.add(destillat.getKornsort());
        }
        int antalFlasker = (int) udregnFlaskeEstimat(fortyndelsesLiter, flaskeStørrelseILiter);
        Batch batch = new Batch(kornsorter, fad.getType(), batchNummer, batchNavn, fortyndelsesLiter, this);

        for (int i = 0; i < antalFlasker; i++) {
            Flaske flaske = new Flaske(flaskeStørrelseILiter, batchNavn, i + 1);
            batch.tilføjFlaske(flaske);
        }

        if (antalFlasker <= 50){
            batch.setFåetKvalitetsStempel(true);
        }else {
            batch.setFåetKvalitetsStempel(false);
        }

        return batch;
    }

    public void setFad(Fad fad) {
        this.fad = fad;
    }

    public void setMedarbejder(Medarbejder medarbejder) {
        this.medarbejder = medarbejder;
    }

    public Fad getFad() {
        return fad;
    }
}
