package application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {
    private Lager lager;
    private Lagerplads lagerplads;
    private Fad fad;

    @BeforeEach
    void setUp(){
        lager = new Lager("Lager 2");
        lager.opretLagerplads("B", 2);
        lagerplads = lager.getPladser().getFirst();
        fad = new Fad(1, "Eg", 150.50, 0);
    }

    @Test
    void opretLagerplads() {
        lager.opretLagerplads("A", 5);

        assertEquals("B", lager.getPladser().getFirst().getReol());
        assertEquals("A", lager.getPladser().getLast().getReol());

        assertEquals(2, lager.getPladser().getFirst().getHylde());
        assertEquals(5, lager.getPladser().getLast().getHylde());

    }

    @Test
    void findFadPåFadNr() {
        lagerplads.placerFad(fad);
        assertEquals(lagerplads, lager.findFadPåFadNummer(fad.getNummer()));
    }

    @Test
    void findTapklar() {

    }
}