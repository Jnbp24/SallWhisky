package application.model.FadVæskeKontrol;

import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.Medarbejdere.Medarbejder;

import java.util.ArrayList;

public class Påfyldning {
    private double resterendeVolume;
    private Fad fad;
    private ArrayList<Destillat> destillater = new ArrayList<>();
    private double mængdeLiterFraAlleDestillater = 0;

    public Påfyldning(Fad fad) {
        this.fad = fad;
        resterendeVolume = fad.getFadStørrelse();
    }

    public void påfyldDestillat(Destillat destillat, double valgtDestillatmængde) {
        if (valgtDestillatmængde > destillat.getMængdeLiter()) {
            System.out.println(destillat.getNmNummer());
            System.out.println(destillat.getMængdeLiter());
            System.out.println(valgtDestillatmængde);
            throw new IllegalArgumentException("Ikke nok væske i destillatet");
        }
        if (resterendeVolume - destillat.getVand().getMængde() <= 0) {
            throw new IllegalArgumentException("Ikke nok plads i fadet");
        }

        destillat.setMængdeLiter(destillat.getMængdeLiter() - valgtDestillatmængde);
        resterendeVolume -= destillat.getVand().getMængde();
        mængdeLiterFraAlleDestillater += valgtDestillatmængde;

        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
        }

        fad.tilføjDestillat(destillat);
    }


    public void færdiggørPåfyldning(Medarbejder medarbejder) {
        if (!destillater.isEmpty()) {
            for (Destillat destillat : destillater) {
                if (!fad.getDestillater().contains(destillat)) {
                    fad.tilføjDestillat(destillat);
                }
            }
            fad.setMængdePåfyldt(fad.getMængdePåfyldt() + mængdeLiterFraAlleDestillater);
            fad.setPåfyldtAf(medarbejder.getNavn());
        }
    }
}

