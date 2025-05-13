package application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerpladsTest {
    private Fad fad;
    private Lagerplads lagerplads;
    private Lager lager;

    @BeforeEach
    void setUp(){
        fad = new Fad(12, "Shery", 200.5, 3);
        lager = new Lager("Lager 2");
        lagerplads = new Lagerplads("A", 1, lager);
    }

    @Test
    void placerFadReol() {
        assertEquals("A", lagerplads.getReol());
    }

    @Test
    void placerFadHylde() {
        assertEquals(1, lagerplads.getHylde());
    }

    @Test
    void placerFadLager() {
        assertEquals(lager, lagerplads.getLager());
    }

    @Test
    void fjernFad() {
        lagerplads.placerFad(fad);
        lagerplads.fjernFad();
        assertNull(lagerplads.getFad());
    }
}