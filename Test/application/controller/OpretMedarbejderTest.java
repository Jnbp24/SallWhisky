package application.controller;

import static org.junit.jupiter.api.Assertions.*;

import application.model.Medarbejdere.Medarbejder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OpretMedarbejderTest {
    private Medarbejder medarbejder;

    @BeforeEach
    void setup() {
        medarbejder = Controller.opretMedarbejder(1, "Jonas");
    }

    @Test
    void opretMedarbejderNummerTest() {
        assertEquals(1, medarbejder.getMedarbejderNr());
    }

    @Test
    void opretMedarbejderNavnTest() {
        assertEquals("Jonas", medarbejder.getNavn());
    }
}