package application.controller;

import application.model.Destillat;
import application.model.Kornsort;
import application.model.Ristethed;
import application.model.Vand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

class OpretDestilatTest {

    private Destillat destillat;
    private Kornsort kornsort;
    private Vand vand;

    @BeforeEach
    void setUp() {
        kornsort = Controller.opretKornsort("Byg", "Danmark", 100, Ristethed.IKKE_RISTET);
        vand = Controller.opretVand("Kildevand", "Danmark", 50);
        destillat = Controller.opretDestillat("NM10", 60.0, kornsort, vand, true);
    }

    @Test
    void testDestillatNmNummer() {
        assertEquals("NM10", destillat.getNmNummer(), "NM-nummer skal matche det angivne");
    }

    @Test
    void testDestillatAlkoholProcent() {
        assertEquals(60.0, destillat.getAlkoholProcent(), 0.001, "Alkoholprocent skal matche det angivne");
    }

    @Test
    void testDestillatKornsort() {
        assertEquals(kornsort, destillat.getKornsort(), "Kornsort skal matche det angivne objekt");
    }

    @Test
    void testDestillatVand() {
        assertEquals(vand, destillat.getVand(), "Vand skal matche det angivne objekt");
    }

    @Test
    void testDestillatBrugtTørv() {
        assertTrue(destillat.isBrugtTørv(), "Brugt tørv skal være sandt");
    }

    @Test
    void testDestillatAddedToStorage() {
        assertTrue(Storage.getDestillater().contains(destillat), "Destillat skal være tilføjet til Storage");
    }
}