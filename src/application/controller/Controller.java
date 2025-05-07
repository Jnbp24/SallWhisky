package application.controller;

import application.model.*;
import storage.Storage;

import java.util.ArrayList;

public class Controller {

    public static void opretFad(int nummer, String fadtype, int fadStørrelse, int AntalGangeBrugt) {
        Fad fad = new Fad(nummer, fadtype, fadStørrelse, AntalGangeBrugt);
        Storage.tilføjFad(fad);
    }

    public static void opretDestillat(String nmNummer, double alkoholProcent, Kornsort kornsort, Vand vand, boolean brugtTørv) {
        Destillat destillat = new Destillat(nmNummer, alkoholProcent, kornsort, vand, brugtTørv);
        Storage.tilføjDestillat(destillat);
    }

    public static void opretKornsort(String navn, String lokation, int mængde, Ristethed ristethed) {
        Kornsort kornsort = new Kornsort(navn, lokation, mængde, ristethed);
        Storage.tilføjKornsort(kornsort);
    }

    public static void opretVand(String navn, String lokation, int mængde) {
        Vand vand = new Vand(navn, lokation, mængde);
        Storage.tilføjVand(vand);
    }

    public static Påfyldning tilføjDestillat(Fad fad, Destillat destillat, double mængde) {
        Påfyldning påfyldning = new Påfyldning(fad);
        påfyldning.tilføjDestillat(destillat, mængde);
        return påfyldning;
    }

    public static void færdiggørPåfyldning(Påfyldning påfyldning) {
        påfyldning.færdiggørPåfyldning();
    }

    public static void opretBatch(Fad fad, String batchNavn, int batchNummer, double fortyndelsesLiter) {
        Tapning batch = new Tapning(fad);
        Storage.tilføjBatch(batch.opretBatch(fad, batchNavn, batchNummer, fortyndelsesLiter));
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
}

