package gui.elements;

import application.model.Fad;
import gui.OpretVinduer.*;
import gui.TilføjDestillatVindue;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Knapper {
    public static Button OpretFadButton() {
        Button opretFadBtn = new Button("Opret Fad");
        opretFadBtn.setOnMouseClicked(event -> {
            OpretFadVindue fadVindue = new OpretFadVindue("Opret Fad");
            fadVindue.show();
        });
        return opretFadBtn;
    }

    public static Button OpretDestillatButton() {
        Button opretDestillatBtn = new Button("Opret Destillat");
        opretDestillatBtn.setOnMouseClicked(event -> {
            OpretDestillatVindue destillatVindue = new OpretDestillatVindue("Opret Destillat");
            destillatVindue.show();
        });
        return opretDestillatBtn;
    }

    public static Button OpretVandButton() {
        Button opretVandBtn = new Button("Opret Vand");
        opretVandBtn.setOnMouseClicked(event -> {
            OpretVandVindue vandVindue = new OpretVandVindue("Opret Råvare");
            vandVindue.show();
        });
        return opretVandBtn;
    }

    public static Button OpretKornButton() {
        Button opretKornBtn = new Button("Opret Korn");
        opretKornBtn.setOnMouseClicked(event -> {
            OpretKornVindue kornVindue = new OpretKornVindue("Opret Korn");
            kornVindue.show();
        });
        return opretKornBtn;
    }

    public static Button OpretBatchButton() {
        Button opretBatchBtn = new Button("Opret Batch");
        opretBatchBtn.setOnMouseClicked(event -> {
            OpretBatchVindue batchVindue = new OpretBatchVindue("Opret Batch");
            batchVindue.show();
        });
        return opretBatchBtn;
    }

    public static Button TilføjDestillatButton(ListView<Fad> fadListView) {
        Button tilføjDestillatBtn = new Button("Tilføj Destillat");

        tilføjDestillatBtn.setOnMouseClicked(event -> {
            TilføjDestillatVindue tilføjDestillatVindue = new TilføjDestillatVindue("Tilføj Destillat", fadListView.getSelectionModel().getSelectedItem());
            tilføjDestillatVindue.show();
        });
        return tilføjDestillatBtn;
    }

    public static Button OpretLagerbeholdningButton() {
        Button lagerbeholdningBtn = new Button("Lager beholdning");
        return lagerbeholdningBtn;
    }

    public static Button OpretLagerHistorikButton() {
        Button seHistorikBtn = new Button("Lager historik");
        return seHistorikBtn;
    }
}
