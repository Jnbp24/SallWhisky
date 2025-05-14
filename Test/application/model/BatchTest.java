package application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BatchTest {

    @Test
    void tilføjFlaske() {
        Flaske expected = new Flaske(2, "B189", 234);
        ArrayList<Råvarer> kornsorter = new ArrayList<>();
        kornsorter.add(new Kornsort("Korn", "Kornsort", 23, Ristethed.IKKE_RISTET));
        Batch batch = new Batch(kornsorter,"Eg", 12, "B89", 23, new Tapning());
        batch.tilføjFlaske(expected);

        assertEquals(expected, batch.getFlasker().getFirst());
    }
}