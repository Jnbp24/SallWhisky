package application.controller;

import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Ristethed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

class OpretKornsortTest {

    private Kornsort kornsort;

    @BeforeEach
    void setUp() {
        Storage.getKornsorter().clear();
        kornsort = Controller.opretKornsort("Byg", "Danmark", 100, Ristethed.IKKE_RISTET);
    }

    @Test
    void testKornsortNavn() {
        assertEquals("Byg", kornsort.getNavn(), "Navn skal matche det angivne");
    }

    @Test
    void testKornsortLokation() {
        assertEquals("Danmark", kornsort.getLokation(), "Lokation skal matche det angivne");
    }

    @Test
    void testKornsortMængde() {
        assertEquals(100, kornsort.getMængde(), "Mængde skal matche det angivne");
    }

    @Test
    void testKornsortRistethed() {
        assertEquals(Ristethed.IKKE_RISTET, kornsort.getRistethed(), "Ristethed skal matche det angivne");
    }


}