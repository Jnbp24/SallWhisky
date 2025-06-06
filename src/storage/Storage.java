package storage;

import application.model.BatchIndhold.Batch;
import application.model.BatchIndhold.Flaske;
import application.model.FadIndhold.Destillat;
import application.model.FadIndhold.Fad;
import application.model.Lager.Lager;
import application.model.Medarbejdere.Medarbejder;
import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Vand;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Fad> fade = new ArrayList<>();
    private static ArrayList<Batch> batches = new ArrayList<>();
    private static ArrayList<Flaske> flasker = new ArrayList<>();
    private static ArrayList<Destillat> destillater = new ArrayList<>();
    private static ArrayList<Kornsort> kornsorter = new ArrayList<>();
    private static ArrayList<Vand> vandtyper = new ArrayList<>();
    private static ArrayList<Medarbejder> medarbejderer = new ArrayList<>();
    private static ArrayList<Lager> lagerer = new ArrayList<>();


    public static void tilføjFad(Fad fad) {
        if (!fade.contains(fad)) {
            fade.add(fad);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    public static void tilføjBatch(Batch batch) {
        if (!batches.contains(batch)) {
            batches.add(batch);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    public static void tilføjFlaske(Flaske flaske) {
        if (!flasker.contains(flaske)) {
            flasker.add(flaske);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    public static void tilføjDestillat(Destillat destillat) {
        if (!destillater.contains(destillat)) {
            destillater.add(destillat);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    public static void tilføjKornsort(Kornsort kornsort) {
        if (!kornsorter.contains(kornsort)) {
            kornsorter.add(kornsort);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    public static void tilføjVand(Vand vand) {
        if (!vandtyper.contains(vand)) {
            vandtyper.add(vand);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    public static void tilføjMedarbejder(Medarbejder medarbejder) {
        if (!medarbejderer.contains(medarbejder)) {
            medarbejderer.add(medarbejder);
        }
        else
            throw new IllegalArgumentException("Denne medarbejder er allerede tilføjet!");
    }

    public static void tilføjLager(Lager lager) {
        if (!lagerer.contains(lager)) {
            lagerer.add(lager);
        }
        else
            throw new IllegalArgumentException("Lager er allerede oprettet");
    }

    public static ArrayList<Kornsort> getKornsorter() {
        return new ArrayList<>(kornsorter);
    }

    public static ArrayList<Vand> getVandtyper() {
        return new ArrayList<>(vandtyper);
    }

    public static ArrayList<Fad> getFade() {
        return new ArrayList<>(fade);
    }

    public static ArrayList<Destillat> getDestillater() {
        return new ArrayList<>(destillater);
    }

    public static ArrayList<Medarbejder> getMedarbejderer() {
        return new ArrayList<>(medarbejderer);
    }

    public static ArrayList<Batch> getBatches() {
        return new ArrayList<>(batches);
    }

    public static ArrayList<Lager> getLagerer() {
        return new ArrayList<>(lagerer);
    }
}
