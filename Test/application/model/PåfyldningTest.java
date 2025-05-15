package application.model;

import application.controller.Controller;
import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.FadVæskeKontrol.Påfyldning;
import application.model.Medarbejdere.Medarbejder;
import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Ristethed;
import application.model.Raavarer.Vand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PåfyldningTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void påfyldningTest() {


    }

    @Test
    void tilføjDestillatTest() {
        Fad fad = new Fad(1, "Eg", 30.0, 2);
        Kornsort kornsort = new Kornsort("korn", "kornmark", 30, Ristethed.IKKE_RISTET);
        Vand vand = new Vand("vand", "vandmark", 10);
        Destillat destillat = new Destillat("NM1", 63.5, kornsort, vand, true);
        destillat.setMængdeLiter(30);
        Medarbejder medarbejder = new Medarbejder(1, "Sammi");
        Påfyldning påfyldning = new Påfyldning(fad);

        påfyldning.påfyldDestillat(destillat, 10);
        påfyldning.færdiggørPåfyldning(medarbejder);

        assertTrue(fad.getDestillater().contains(destillat));
        assertEquals(20.0, destillat.getMængdeLiter());
        assertEquals(20.0, fad.getFadStørrelse() - fad.getMængdePåfyldt());
    }

    @Test
    void færdiggørPåfyldning() {
        Fad fad = new Fad(1, "Eg", 50.0, 2);
        Destillat destillat = new Destillat("NM1", 63.5, new Kornsort("korn", "kornmark", 10, Ristethed.IKKE_RISTET), new Vand("vand", "vandmark", 10), true);
        Medarbejder medarbejder = new Medarbejder(1, "Sammi");
        Påfyldning påfyldning = new Påfyldning(fad);
        påfyldning.påfyldDestillat(destillat, 10);

        påfyldning.færdiggørPåfyldning(medarbejder);

        assertEquals(10, fad.getMængdePåfyldt());
        assertTrue(fad.getDestillater().contains(destillat));
        assertEquals("Sammi", fad.getPåfyldtAf());
    }

    //    @org.junit.jupiter.api.Test
    //    void fjernDestillat() {
    //        Fad fad2 = new Fad(2, "Sherry", 20.0, 1);
    //        Destillat destillat2 = new Destillat("NM2", 60, new Kornsort("havre", "havremark", 10, Ristethed.SVÆRT_RISTET), new Vand("havvand", "havet", 50), false);
    //        Påfyldning påfyldning2 = new Påfyldning(fad2);
    //
    //
    //        assertEquals(destillat2, fad2.getDestillater().remove(destillat2));
    //
    //    }

}
