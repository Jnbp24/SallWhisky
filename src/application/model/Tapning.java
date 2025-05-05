package application.model;

public class Tapning {
    private Fad fad;

    public void opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter){
        Batch batch = new Batch(fad.getDestillat().getKornsort(), fad.getFadType(), batchNummer, batchNavn, fortyndelsesLiter);
    }
}
