package storage;

import application.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    @BeforeEach
    void setUp() {
        Storage.getFade().clear();
        Storage.getBatches().clear();
        Storage.getKornsorter().clear();
        Storage.getVandtyper().clear();
        Storage.getMedarbejderer().clear();
        Storage.getLagerer().clear();
    }

    @Test
    void tilføjFad() {
        Fad fad = new Fad(1,"Sherry",200.00, 3);
        Storage.tilføjFad(fad);
        assertTrue(Storage.getFade().contains(fad));
    }

    @Test
    void tilføjBatch() {
        ArrayList<Råvarer> kornsorter = new ArrayList<>();
        kornsorter.add(new Kornsort("Korn", "Kornsort", 23, Ristethed.IKKE_RISTET));
        Batch batch = new Batch(kornsorter,"Eg", 12, "B89", 23, new Tapning());
        Storage.tilføjBatch(batch);
        assertTrue(Storage.getBatches().contains(batch));
    }

    @Test
    void tilføjKornsort() {
        Kornsort kornsort = new Kornsort("Rug", "Mark A", 100.00, Ristethed.LET_RISTET);
        Storage.tilføjKornsort(kornsort);
        assertTrue(Storage.getKornsorter().contains(kornsort));
    }

    @Test
    void tilføjVand() {
        Vand vand = new Vand("Kildevand", "Dal", 500.00);
        Storage.tilføjVand(vand);
        assertTrue(Storage.getVandtyper().contains(vand));
    }

    @Test
    void tilføjMedarbejder() {
        Medarbejder medarbejder = new Medarbejder(1,"Jonas");
        Storage.tilføjMedarbejder(medarbejder);
        assertTrue(Storage.getMedarbejderer().contains(medarbejder));
    }

    @Test
    void tilføjLager() {
        Lager lager = new Lager("Lager 1");
        Storage.tilføjLager(lager);
        assertTrue(Storage.getLagerer().contains(lager));
    }
}