package application.model;

import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.Lager.Lager;
import application.model.Lager.Lagerplads;
import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Ristethed;
import application.model.Raavarer.Vand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {
    private Lager lager;
    private Lagerplads lagerplads;
    private Fad fad;

    @BeforeEach
    void setUp() {
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
    void findFad_PåFadNummer() {
        lagerplads.placerFad(fad);
        assertEquals(lagerplads, lager.findFadPåFadNummer(fad.getFadnummer()));
    }

    @Test
    void findFad_PåNmNummer() {
        Lager lager = new Lager("Lager 1");
        lager.opretLagerplads("A", 1);
        lager.opretLagerplads("B", 1);

        Fad fad1 = new Fad(1, "Eg", 30.0, 2);
        Fad fad2 = new Fad(2, "Eg", 50.0, 3);
        Kornsort kornsort = new Kornsort("korn", "kornmark", 30, Ristethed.IKKE_RISTET);
        Vand vand = new Vand("vand", "vandmark", 10);

        Destillat destillat1 = new Destillat("NM1", 63.5, kornsort, vand, true);
        Destillat destillat2 = new Destillat("NM2", 63.5, kornsort, vand, true);

        fad1.tilføjDestillat(destillat1);
        fad2.tilføjDestillat(destillat2);

        lager.getPladser().get(0).placerFad(fad1);
        lager.getPladser().get(1).placerFad(fad2);

        ArrayList<Lagerplads> resultat = lager.findFadPåNmNummer("NM1");

        assertEquals(1, resultat.size(), "Bør tjekke at kun et fad findes med dette NM nummer");
        assertEquals("A", resultat.get(0).getReol(), "Bør tjekke at NM nummeret ligger på den forventede reol plads");
        assertTrue(resultat.get(0).getFad().getDestillater().contains(destillat1), "Bør tjekke at resultatet faktisk indeholder destillatet tilsvarende NM nummeret");
    }
}