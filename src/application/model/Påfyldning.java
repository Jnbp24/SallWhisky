package application.model;

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

    public void tilføjDestillat(Destillat destillat, double valgtDestillatmængde) {
        if (valgtDestillatmængde > destillat.getMængdeLiter()) {
            System.out.println(destillat.getNmNummer());
            System.out.println(destillat.getMængdeLiter());
            System.out.println(valgtDestillatmængde);
            throw new IllegalArgumentException("Ikke nok væske i destillatet");
        }
        if (resterendeVolume - destillat.getVand().getMængde() <= 0) {
            throw new IllegalArgumentException("Ikke nok plads i fadet");
        }

        destillater.add(destillat);
        resterendeVolume -= destillat.getVand().getMængde();
        destillat.setMængdeLiter(destillat.getMængdeLiter() - valgtDestillatmængde);
        mængdeLiterFraAlleDestillater += valgtDestillatmængde;
        fad.tilføjDestillat(destillat);
    }


    public void færdiggørPåfyldning(Medarbejder medarbejder) {
        if (!destillater.isEmpty()) {
            for (Destillat destillat : destillater) {
                if (!fad.getDestillater().contains(destillat)) {
                    fad.tilføjDestillat(destillat);
                }
            }
            fad.setMængdePåfyldt(mængdeLiterFraAlleDestillater);
            fad.setPåfyldtAf(medarbejder.getNavn());
        }
    }
}

