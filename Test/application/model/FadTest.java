package application.model;

import application.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {
    private Fad fad;
    private Medarbejder medarbejder;
    private Kornsort kornsort;
    private Vand vand;
    private Destillat destillat;

    @BeforeEach
    void setUp() {
        fad = new Fad(1, "Eg", 30.0, 2);
        medarbejder = new Medarbejder(1, "Sammi");
        kornsort = new Kornsort("korn", "Kornvej", 10, Ristethed.LET_RISTET);
        vand = new Vand("vand", "Vandvej", 10);
        destillat = new Destillat("NM1", 63.5, kornsort, vand, true);
    }

    @Test
    void tilføjDestillatRåvarer() {
        assertEquals(kornsort, destillat.getKornsort());
        assertEquals(vand, destillat.getVand());
    }

    @Test
    void tilføjDestillatNmNummer(){
        assertEquals("NM1", destillat.getNmNummer());
    }

    @Test
    void tilføjDestillatAlkohol(){
        assertEquals(63.5, destillat.getAlkoholProcent());
    }

    @Test
    void tilføjDestillatBrugtTørv(){
        assertEquals(true, destillat.isBrugtTørv());
    }

}