package application.controller;

import application.model.*;
import storage.Storage;

import java.util.ArrayList;

public class Controller {

    public static void opretFad(int nummer, String fadtype, int fadStørrelse, int AntalGangeBrugt) {
        Fad fad = new Fad(nummer, fadtype, fadStørrelse, AntalGangeBrugt);
        Storage.tilføjFad(fad);
    }

    public static void opretDestillat(String nmNummer, double alkoholProcent, Kornsort kornsort, Vand vand, boolean brugtTørv){
        Destillat destillat = new Destillat(nmNummer, alkoholProcent, kornsort, vand, brugtTørv);
        Storage.tilføjDestillat(destillat);
    }

    public static void opretKornsort(String navn, String lokation, int mængde, Ristethed ristethed){
        Kornsort kornsort = new Kornsort(navn, lokation, mængde, ristethed);
        Storage.tilføjKornsort(kornsort);
    }

    public static void opretVand(String navn, String lokation, int mængde) {
        Vand vand = new Vand(navn, lokation, mængde);
        Storage.tilføjVand(vand);
    }


    public static ArrayList<Kornsort> getKornList(){
        return Storage.getKornsorter();
    }
    public static ArrayList<Vand> getVandTypeList(){
        return Storage.getVandtyper();
    }
}

