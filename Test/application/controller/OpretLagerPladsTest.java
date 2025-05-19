package application.controller;

import application.model.Lager.Lager;
import application.model.Lager.Lagerplads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpretLagerPladsTest {
    private Lagerplads lagerplads;
    private Lager lager;

    @BeforeEach
    void setup(){
        lager = Controller.opretLager("Lager1");
        lagerplads = Controller.opretLagerplads(lager,"A", 1);
    }

    @Test
    void opretLagerPladsLager() {
        assertEquals(lager,lagerplads.getLager());
    }

    @Test
    void opretLagerPladsReol(){
        assertEquals("A", lagerplads.getReol());
    }

    @Test
    void opretLagerPladsHylde(){
        assertEquals(1,lagerplads.getHylde());
    }
}