package application.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LagerTest {
    private Lager lager;
    private Lagerplads lagerplads;
    private Fad fad;

    @Test
    void opretLagerplads() {
        lager = new Lager("Lager 2");
        lagerplads = new Lagerplads("B", 2, lager);
        fad = new Fad(1, "Eg", 150.50, 0);
    }

    @Test
    void findFad() {

    }

    @Test
    void findTapklar() {

    }
}