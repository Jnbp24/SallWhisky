package application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FindTapKlarTest {
    private Lager lager;

    @BeforeEach
    void setup(){
        lager = new Lager("Lager 1");
    }


    @Test
    void findTapklar_IngenLagerPladser() {
        ArrayList<Lagerplads> resultat = lager.findTapklar();
        assertTrue(resultat.isEmpty(), "Resulatet bør være tomt når der ikke er lagerpladser oprettet");
    }

    @Test
    void findTapklar_IngenFadPåLagerPlads(){
        lager.opretLagerplads("A",1);
        ArrayList<Lagerplads> resultat = lager.findTapklar();
        assertTrue(resultat.isEmpty(), "Resulatet bør være tomt når der ikke er fade på lagerpladsen");
    }

    @Test
    void findTapKlar_FadeUnder3ÅrPåLager(){
        Lagerplads lagerplads = new Lagerplads("A", 1, lager);
        Fad fad = new Fad(1,"Eg", 150.00,0);
        fad.setPåfyldningsDato(LocalDate.now().minusYears(2));
        lagerplads.placerFad(fad);
        lager.getPladser().add(lagerplads);

        ArrayList<Lagerplads> resultat = lager.findTapklar();
        assertTrue(resultat.isEmpty(), "Resultat bør være tomt når fadet er under 3 år gammelt");
    }

    @Test
    void findTapKlar_FadPræcist3ÅrPåLager(){
        Lagerplads lagerplads = new Lagerplads("A", 1, lager);
        Fad fad = new Fad(1,"Eg", 150.00,0);
        fad.setPåfyldningsDato(LocalDate.now().minusYears(3));
        lagerplads.placerFad(fad);
        lager.getPladser().add(lagerplads);

        ArrayList<Lagerplads> resultat = lager.findTapklar();
        assertEquals(1, resultat.size(), "Resultat bør indeholde præcist en lagerplads med et fad der er præcist 3 år gammelt");
    }

    @Test
    void findTapKlar_FadOver3ÅrPåLager(){
        Lagerplads lagerplads = new Lagerplads("A", 1, lager);
        Fad fad = new Fad(1,"Eg", 150.00,0);
        fad.setPåfyldningsDato(LocalDate.now().minusYears(4));
        lagerplads.placerFad(fad);
        lager.getPladser().add(lagerplads);

        ArrayList<Lagerplads> resultat = lager.findTapklar();
        assertEquals(1, resultat.size(), "Resultat bør indeholde præcist en lagerplads med et fad der er over 3 år gammelt");
    }
}