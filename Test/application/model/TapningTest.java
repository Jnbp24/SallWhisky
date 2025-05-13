package application.model;

import application.controller.Controller;
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
        Tapning tapning = new Tapning(fad, medarbejder);
        double actual = tapning.udregnFlaskeEstimat(10, 10);

        assertEquals(1.5, actual, 0.001);
    }

    @Test
    void opretBatch() {
        Fad fad = new Fad(2, "Sherry", 20, 2);
        Medarbejder medarbejder = new Medarbejder(1, "Sammi");
        Batch batch = Controller.opretBatch(fad, "B109", 109, 12, 1.5, medarbejder);

        assertEquals("Sherry", batch.getFadtype());
        assertEquals("B109", batch.getBatchNavn());
        assertEquals(109, batch.getBatchNummer());
        assertEquals(12, batch.getFortyndelseLiter());
        assertEquals("Sammi", medarbejder.getNavn());
    }
}