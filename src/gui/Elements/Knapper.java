package gui.Elements;

import application.model.Fad;
import gui.LagerVinduer.LagerbeholdningVindue;
import gui.OpretVinduer.*;
import gui.OpretVinduer.Fad.LavOmhældningVindue;
import gui.OpretVinduer.Fad.OpretFadVindue;
import gui.OpretVinduer.Fad.TilføjDestillatVindue;
import gui.OpretVinduer.Råvarer.OpretKornVindue;
import gui.OpretVinduer.Råvarer.OpretVandVindue;
import gui.Tabs.BatchTab;
import javafx.scene.control.Alert;
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
            Fad valgtFad = fadListView.getSelectionModel().getSelectedItem();
            if (valgtFad == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fejl");
                alert.setHeaderText("Intet fad valgt");
                alert.setContentText("Vælg et fad fra listen");
                alert.showAndWait();
                return;
            }
            tilføjDestillatVindue.show();
        });
        return tilføjDestillatBtn;
    }

    public static Button OpretLagerbeholdningButton() {
        Button lagerbeholdningBtn = new Button("Lager beholdning");
        lagerbeholdningBtn.setOnMouseClicked(event -> {
            LagerbeholdningVindue lagerbeholdningVindue = new LagerbeholdningVindue("Lagerbeholdning");
            lagerbeholdningVindue.show();
        });
        return lagerbeholdningBtn;
    }

    public static Button opretMedarbejderButton() {
        Button medarbejderBtn = new Button("Opret en medarbejder");
        medarbejderBtn.setOnMouseClicked(event -> {
            OpretMedarbejderVindue medarbejderVindue = new OpretMedarbejderVindue("Medarbejdere");
            medarbejderVindue.show();
        });
        return medarbejderBtn;
    }

    public static Button opretOmhældningButton() {
        Button omhældningButton = new Button("Lav en omhældning");
        omhældningButton.setOnMouseClicked(event -> {
            LavOmhældningVindue omhældningVindue = new LavOmhældningVindue("Foretag omhældning");
            omhældningVindue.show();
        });
        return omhældningButton;
    }

    public static Button opretFuldHistorikButton(){
        Button fuldHistorikButton = new Button("Vis fuld historik");
        fuldHistorikButton.setOnMouseClicked(event -> {
            FindHistorikVindue historikVindue = new FindHistorikVindue("Vis historik", BatchTab.getBatch());
            historikVindue.show();

        });
        return fuldHistorikButton;
    }
}
