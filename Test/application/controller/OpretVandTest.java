package application.controller;

import application.model.Raavarer.Vand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

class OpretVandTest {


    private Vand vand;

    @BeforeEach
    void setUp() {
        Storage.getVandtyper().clear();
        vand = Controller.opretVand("Kildevand", "Danmark", 50);
    }

    @Test
    void testVandNavn() {
        assertEquals("Kildevand", vand.getNavn(), "Navn skal matche det angivne");
    }

    @Test
    void testVandLokation() {
        assertEquals("Danmark", vand.getLokation(), "Lokation skal matche det angivne");
    }

    @Test
    void testVandMængde() {
        assertEquals(50, vand.getMængde(), "Mængde skal matche det angivne");
    }

    @Test
    void testVandAddedToStorage() {
        assertTrue(Storage.getVandtyper().contains(vand), "Vand skal være tilføjet til Storage");
    }
}