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

//    public void tilføjDestillat(Destillat destillat, double mængdeFraDestillat) {
//        if (mængdeFraDestillat <= destillat.getMængdeLiter()) {
//            if (resterendeVolume - destillat.getVand().getMængde() >= 0) {
//                destillater.add(destillat);
//                resterendeVolume -= destillat.getVand().getMængde();
//                destillat.setMængdeLiter(destillat.getMængdeLiter() - mængdeFraDestillat);
//                mængdeLiterFraAlleDestillater += mængdeFraDestillat;
//            }
//            else {
//                throw new IllegalArgumentException("Ikke nok plads i fadet");
//            }
//        }
//        else {
//            throw new IllegalArgumentException("Ikke nok væske i destillatet");
//        }
//    }

    public void tilføjDestillat(Destillat destillat, double valgtDestillatmængde) {
        if (valgtDestillatmængde > destillat.getMængdeLiter()) {
            throw new IllegalArgumentException("Ikke nok væske i destillatet");
        }
        if (resterendeVolume - destillat.getVand().getMængde() <= 0) {
            throw new IllegalArgumentException("Ikke nok plads i fadet");
        }

        destillater.add(destillat);
        resterendeVolume -= destillat.getVand().getMængde();
        destillat.setMængdeLiter(destillat.getMængdeLiter() - valgtDestillatmængde);
        mængdeLiterFraAlleDestillater += valgtDestillatmængde;
    }

    public double fjernDestillat(Destillat destillat) {
        if (destillater.contains(destillat)) {
            throw new IllegalArgumentException("Destillat kan ikke fjernes, da det ikke findes i listen");
        }
        else {
            destillater.remove(destillat);
            resterendeVolume += destillat.getVand().getMængde();
            return resterendeVolume;
        }
    }

    public void færdiggørPåfyldning(Medarbejder medarbejder) {
        if (!destillater.isEmpty()) {
            for (Destillat destillat : destillater) {
                fad.tilføjDestillat(destillat);
            }
            fad.setMængdePåfyldt(mængdeLiterFraAlleDestillater);
            fad.setPåfyldtAf(medarbejder.getNavn());
        }
    }
}

