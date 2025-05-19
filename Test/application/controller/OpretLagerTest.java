package application.controller;

import application.model.Lager.Lager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OpretLagerTest {
    private Lager lager;


    @BeforeEach
    void setup(){
        lager = Controller.opretLager("Lager1");
    }
    @Test
    void opretLager() {
        assertEquals("Lager1", lager.getId());
    }
}