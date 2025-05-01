package application.controller;

import application.model.Fad;
import storage.Storage;

public class Controller {

    public static void opretFad(int nummer, String fadtype, int fadStørrelse, int AntalGangeBrugt) {
        Fad fad = new Fad(nummer, fadtype, fadStørrelse, AntalGangeBrugt);
        Storage.tilføjFad(fad);
    }


}

