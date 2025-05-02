package application.controller;

import application.model.Destillat;
import application.model.Fad;
import application.model.Råvarer;
import storage.Storage;

public class Controller {

    public static void opretFad(int nummer, String fadtype, int fadStørrelse, int AntalGangeBrugt) {
        Fad fad = new Fad(nummer, fadtype, fadStørrelse, AntalGangeBrugt);
        Storage.tilføjFad(fad);
    }

    public static void opretDestillat(String nmNummer, double alkoholProcent, Råvarer kornsort, Råvarer vand, boolean brugtTørv){
        Destillat destillat = new Destillat(nmNummer, alkoholProcent, kornsort, vand, brugtTørv);
        Storage.tilføjDestillat(destillat);
    }

}

