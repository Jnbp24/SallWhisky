package storage;

import application.model.Batch;
import application.model.Fad;
import application.model.Flaske;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Fad> fade = new ArrayList<>();
    private ArrayList<Batch> batches = new ArrayList<>();
    private ArrayList<Flaske> flasker = new ArrayList<>();


    private void tilføjFad(Fad fad) {
        if (!fade.contains(fad)) {
            fade.add(fad);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    private void tilføjBatch(Batch batch) {
        if (!batches.contains(batch)) {
            batches.add(batch);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }

    private void tilføjFlaske(Flaske flaske) {
        if (!flasker.contains(flaske)) {
            flasker.add(flaske);
        }
        else
            throw new IllegalArgumentException("Dette fad er allerede tilføjet!");
    }
}
