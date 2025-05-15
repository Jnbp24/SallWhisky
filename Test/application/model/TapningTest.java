package application.model;

import application.controller.Controller;
import application.model.BatchIndhold.Batch;
import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.FadVæskeKontrol.Påfyldning;
import application.model.FadVæskeKontrol.Tapning;
import application.model.Medarbejdere.Medarbejder;
import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Ristethed;
import application.model.Raavarer.Vand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TapningTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void udregnFlaskeEstimat() {
        Fad fad = new Fad(2, "Sherry", 20, 2);
        Destillat destillat = new Destillat("NM10", 60, new Kornsort("s", "s", 23, Ristethed.IKKE_RISTET), new Vand("nanv", "avnd", 5), true);
        Medarbejder medarbejder = new Medarbejder(1, "Sammi");
        Påfyldning påfyldning = Controller.tilføjDestillat(fad, destillat, 5);
        Controller.færdiggørPåfyldning(påfyldning, medarbejder);
        Tapning tapning = new Tapning();
        tapning.setFad(fad);
        tapning.setMedarbejder(medarbejder);
        double actual = tapning.udregnFlaskeEstimat(10, 10);

        assertEquals(1.5, actual, 0.001);
    }

    @Test
    void opretBatch() {
        Fad fad = new Fad(2, "Sherry", 20, 2);
        Medarbejder medarbejder = new Medarbejder(1, "Sammi");
        Batch batch = Controller.opretBatch(fad, "B109", 109, 12, 1.5, medarbejder, new Tapning());

        assertEquals("Sherry", batch.getFadtype());
        assertEquals("B109", batch.getBatchNavn());
        assertEquals(109, batch.getBatchNummer());
        assertEquals(12, batch.getFortyndelseLiter());
        assertEquals("Sammi", medarbejder.getNavn());
    }
}