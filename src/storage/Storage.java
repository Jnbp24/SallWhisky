package storage;

import application.model.Batch;
import application.model.Fad;
import application.model.Flaske;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Fad> fade = new ArrayList<>();
    private static ArrayList<Batch> batches = new ArrayList<>();
    private static ArrayList<Flaske> flasker = new ArrayList<>();


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
}
