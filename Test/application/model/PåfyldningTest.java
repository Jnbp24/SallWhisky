package application.model;

import application.controller.Controller;
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

    @org.junit.jupiter.api.Test
    void tilføjDestillatTest() {
        Fad fad = new Fad(1, "Eg", 30.0, 2);
        Destillat destillat = new Destillat("NM1", 63.5, new Kornsort("korn", "kornmark", 30, Ristethed.IKKE_RISTET), new Vand("vand", "vandmark", 10), true);
        Påfyldning påfyldning = Controller.tilføjDestillat(fad, destillat, 10);
        Controller.færdiggørPåfyldning(påfyldning);

        assertEquals(destillat, fad.getDestillater().getFirst());
//        assertEquals(20, fad.getDestillater());

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
//
//    }

    @org.junit.jupiter.api.Test
    void færdiggørPåfyldning() {
    }
}
