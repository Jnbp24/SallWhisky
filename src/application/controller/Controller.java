package application.controller;

import application.model.BatchIndhold.Batch;
import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.FadVæskeKontrol.Påfyldning;
import application.model.FadVæskeKontrol.Tapning;
import application.model.Lager.Lager;
import application.model.Lager.Lagerplads;
import application.model.Medarbejdere.Medarbejder;
import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Ristethed;
import application.model.Raavarer.Vand;
import storage.Storage;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Controller {

    public static Fad opretFad(int nummer, String fadtype, int fadStørrelse, int AntalGangeBrugt) {
        Fad fad = new Fad(nummer, fadtype, fadStørrelse, AntalGangeBrugt);
        Storage.tilføjFad(fad);
        return fad;
    }

    public static Destillat opretDestillat(String nmNummer, double alkoholProcent, Kornsort kornsort, Vand vand, boolean brugtTørv) {
        Destillat destillat = new Destillat(nmNummer, alkoholProcent, kornsort, vand, brugtTørv);
        Storage.tilføjDestillat(destillat);
        return destillat;
    }

    public static Kornsort opretKornsort(String navn, String lokation, int mængde, Ristethed ristethed) {
        Kornsort kornsort = new Kornsort(navn, lokation, mængde, ristethed);
        Storage.tilføjKornsort(kornsort);
        return kornsort;
    }

    public static Vand opretVand(String navn, String lokation, int mængde) {
        Vand vand = new Vand(navn, lokation, mængde);
        Storage.tilføjVand(vand);
        return vand;
    }

    public static Påfyldning tilføjDestillat(Fad fad, Destillat destillat, double mængde, Medarbejder medarbejder) {
        Påfyldning påfyldning = new Påfyldning(fad);
        påfyldning.påfyldDestillat(destillat, mængde);
        påfyldning.færdiggørPåfyldning(medarbejder);
        return påfyldning;
    }

    public static void færdiggørPåfyldning(Påfyldning påfyldning, Medarbejder medarbejder) {
        påfyldning.færdiggørPåfyldning(medarbejder);
    }

    public static Tapning opretTapning() {
        return new Tapning();
    }

    public static Batch opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter, double flaskeStørrelse, Medarbejder medarbejder, Tapning tapning) {
        tapning.setFad(fad);
        tapning.setMedarbejder(medarbejder);
        Batch batch = tapning.opretBatch(fad, batchNavn, batchNummer, fortyndelsesLiter, flaskeStørrelse);
        Storage.tilføjBatch(batch);

        return batch;
    }

    public static Medarbejder opretMedarbejder(int nummer, String navn) {
        Medarbejder medarbejder = new Medarbejder(nummer, navn);
        Storage.tilføjMedarbejder(medarbejder);
        return medarbejder;
    }

    public static double udregnFlaskeestimat(Tapning tapning, double fortyndelsesLiter, double flaskeStørrelse) {
        if (tapning == null) {
            return fortyndelsesLiter / flaskeStørrelse;
        }
        return tapning.udregnFlaskeEstimat(fortyndelsesLiter, flaskeStørrelse);
    }

    public static Lager opretLager(String id) {
        Lager lager = new Lager(id);
        Storage.tilføjLager(lager);
        return lager;
    }

    public static void foretagOmhældning(Fad kildeFad, Fad destinationsFad, double omhældningsMængde) {
        if (kildeFad == null || destinationsFad == null) {
            throw new IllegalArgumentException("Vælg både kilde og destinations fad");
        }
        kildeFad.omhæld(destinationsFad, omhældningsMængde);
    }

    public static Lagerplads opretLagerplads(Lager lager, String reol, int hylde) {
        return lager.opretLagerplads(reol, hylde);
    }

    public static Lagerplads findFadPåFadNummer(int fadNummer) {
        Lagerplads lagerplads;
        for (Lager lager : getLagerer()) {
            lagerplads = lager.findFadPåFadNummer(fadNummer);
            if (lagerplads != null) {
                return lagerplads;
            }
        }
        throw new NoSuchElementException("Dette fad er ikke på lager");
    }

    public static ArrayList<Lagerplads> findFadPåNmNummer(String nmNummer) {
        ArrayList<Lagerplads> lagerpladser = new ArrayList<>();
        for (Lager lager : getLagerer()) {
            lagerpladser.addAll(lager.findFadPåNmNummer(nmNummer));
        }
        return lagerpladser;
    }

    public static ArrayList<Lagerplads> findTapklar() {
        ArrayList<Lagerplads> lagerpladser = new ArrayList<>();
        for (Lager lager : getLagerer()) {
            lagerpladser.addAll(lager.findTapklar());
        }
        return lagerpladser;
    }

    public static void tilføjFadTilLagerplads(Fad fad, Lagerplads lagerplads) {
        lagerplads.placerFad(fad);
    }

    public static void fjernFadFraLagerplads(Lagerplads lagerplads) {
        lagerplads.fjernFad();
    }


    public static ArrayList<Kornsort> getKornList() {
        return Storage.getKornsorter();
    }

    public static ArrayList<Vand> getVandTypeList() {
        return Storage.getVandtyper();
    }

    public static ArrayList<Fad> getFadList() {
        return Storage.getFade();
    }

    public static ArrayList<Destillat> getDestillater() {
        return Storage.getDestillater();
    }

    public static ArrayList<Batch> getBatches() {
        return Storage.getBatches();
    }

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return Storage.getMedarbejderer();
    }

    public static ArrayList<Lager> getLagerer() {
        return Storage.getLagerer();
    }
}

