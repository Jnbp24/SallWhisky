package application.controller;

import application.model.*;
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

    public static Påfyldning tilføjDestillat(Fad fad, Destillat destillat, double mængde) {
        Påfyldning påfyldning = new Påfyldning(fad);
        påfyldning.tilføjDestillat(destillat, mængde);
        return påfyldning;
    }

    public static void færdiggørPåfyldning(Påfyldning påfyldning, Medarbejder medarbejder) {
        påfyldning.færdiggørPåfyldning(medarbejder);
    }

    public static void opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter, double flaskeStørrelse, Medarbejder medarbejder) {
        Tapning batch = new Tapning(fad, medarbejder);
        Storage.tilføjBatch(batch.opretBatch(fad, batchNavn, batchNummer, fortyndelsesLiter, flaskeStørrelse));
    }

    public static Medarbejder opretMedarbejder(int nummer, String navn) {
        Medarbejder medarbejder = new Medarbejder(nummer, navn);
        Storage.tilføjMedarbejder(medarbejder);
        return medarbejder;
    }

    public static double udregnFlaskeestimat(Tapning tapning, double fortyndelsesLiter, double flaskeStørrelse) {
        return tapning.udregnFlaskeEstimat(fortyndelsesLiter, flaskeStørrelse);
    }

    public static Lager opretLager(String id) {
        Lager lager = new Lager(id);
        Storage.tilføjLager(lager);
        return lager;
    }

    public static void opretLagerplads(Lager lager, String reol, int hylde) {
        lager.opretLagerplads(reol, hylde);
    }

    public static Lagerplads findFad(int fadNummer){
        Lagerplads lagerplads;
        for (Lager lager : getLagerer()) {
            lagerplads = lager.findFad(fadNummer);
            if (lagerplads != null){
                return lagerplads;
            }
        }
        throw new NoSuchElementException("Dette fad er ikke på lager");
    }

    public static ArrayList<Fad> findTapklar(Lager lager) {
        return lager.findTapklar();
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

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return Storage.getMedarbejderer();
    }

    public static ArrayList<Lager> getLagerer() {
        return Storage.getLagerer();
    }
}

