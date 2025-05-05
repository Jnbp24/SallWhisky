package application.model;

import java.util.ArrayList;

public class Tapning {
    private Fad fad;

    public void opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter) {

        ArrayList<Råvarer> kornsorter = new ArrayList<>();
        for (Destillat destillat : fad.getDestillater()) {
            kornsorter.add(destillat.getKornsort());
        }

        Batch batch = new Batch(kornsorter, fad.getFadType(), batchNummer, batchNavn, fortyndelsesLiter);
    }
}
