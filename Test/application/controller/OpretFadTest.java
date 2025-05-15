package application.controller;

import application.model.FadIndhold.Fad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpretFadTest {

    private Fad fad;

    @BeforeEach
    void setUp() {
        fad = Controller.opretFad(1, "Sherry", 200, 0);
    }

    @Test
    void testFadNummer() {
        assertEquals(1, fad.getNummer(), "Fadnummer skal matche det angivne nummer");
    }

    @Test
    void testFadType() {
        assertEquals("Sherry", fad.getType(), "Fadtype skal matche den angivne type");
    }

    @Test
    void testFadStørrelse() {
        assertEquals(200, fad.getFadStørrelse(), "Fadstørrelse skal matche den angivne størrelse");
    }

    @Test
    void testAntalGangeBrugt() {
        assertEquals(0, fad.getAntalGangeBrugt(), "Antal gange brugt skal matche det angivne antal");
    }


}