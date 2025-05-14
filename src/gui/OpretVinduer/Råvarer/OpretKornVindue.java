package gui.OpretVinduer.Råvarer;

import application.controller.Controller;
import application.model.Ristethed;
import gui.Tabs.RaavarerTab;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpretKornVindue extends Stage {
    private TextField kornsortTypeTxtField = new TextField();
    private TextField kornsortLokationTxtField = new TextField();
    private TextField kornsortMængdeTxtField = new TextField();

    public OpretKornVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);

        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(300);
        pane.setPrefWidth(300);


        Label kornsortLabel = new Label("Kornsort: ");
        kornsortTypeTxtField.setPromptText("Indtast kornsort");
        pane.add(kornsortTypeTxtField, 1, 0);
        pane.add(kornsortLabel, 0, 0);

        Label kornsortLokationLabel = new Label("Kornsort mark: ");
        kornsortLokationTxtField.setPromptText("Indtast lokation");
        pane.add(kornsortLokationTxtField, 1, 1);
        pane.add(kornsortLokationLabel, 0, 1);

        Label kornsortMængdeLabel = new Label("Mængde i gram: ");
        kornsortMængdeTxtField.setPromptText("Indtast mængde");
        pane.add(kornsortMængdeTxtField, 1, 2);
        pane.add(kornsortMængdeLabel, 0, 2);


        ToggleGroup ristetgroup = new ToggleGroup();

        //Sætter ikke ristet som default
        RadioButton ikkeRistetBox = new RadioButton("Ikke ristet");
        ikkeRistetBox.setUserData(Ristethed.IKKE_RISTET);
        ikkeRistetBox.setSelected(true);
        ikkeRistetBox.setToggleGroup(ristetgroup);

        RadioButton letRistetBox = new RadioButton("Let ristet");
        letRistetBox.setUserData(Ristethed.LET_RISTET);
        letRistetBox.setToggleGroup(ristetgroup);

        RadioButton sværtRistetBox = new RadioButton("Svært ristet");
        sværtRistetBox.setUserData(Ristethed.SVÆRT_RISTET);
        sværtRistetBox.setToggleGroup(ristetgroup);


        VBox RistetboxGroup = new VBox(ikkeRistetBox, letRistetBox, sværtRistetBox);
        Label RistethedLabel = new Label("Vælg ristethed");
        pane.add(RistetboxGroup, 1, 3);
        pane.add(RistethedLabel, 0, 3);


        Button opretBtn = new Button("Opret kornsort");
        opretBtn.setOnMouseClicked(event -> {
            try {
                Ristethed valgtRistethed;
                if (ristetgroup.getSelectedToggle() != null) {
                    valgtRistethed = (Ristethed) ristetgroup.getSelectedToggle().getUserData();
                }
                else {
                    valgtRistethed = null;
                }
                
                Controller.opretKornsort(kornsortTypeTxtField.getText(), kornsortLokationTxtField.getText(), Integer.parseInt(kornsortMængdeTxtField.getText()), valgtRistethed);
                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Kornsort oprettet!");
                succesAlert.setHeaderText("Din kornsort er nu oprettet");
                succesAlert.show();
                RaavarerTab.opdaterListview();
                this.close();
            } catch (NumberFormatException e) {
                if (kornsortTypeTxtField.getText().isEmpty() || kornsortLokationTxtField.getText().isEmpty() || kornsortMængdeTxtField.getText().isEmpty()) {
                    Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                    fejlAlert.setTitle("Invalid information");
                    fejlAlert.setHeaderText("Alle felter skal udfyldes");
                    fejlAlert.show();
                }
                else {
                    Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                    fejlAlert.setTitle("Invalid information");
                    fejlAlert.setHeaderText("Ugyldig information indtastet");
                    fejlAlert.show();
                }
            }
        });
        pane.add(opretBtn, 1, 4);
        GridPane.setHalignment(opretBtn, HPos.RIGHT);

        Button annullerBtn = new Button("Annuller");
        annullerBtn.setOnMouseClicked(event -> {
            this.close();
        });
        pane.add(annullerBtn, 0, 4);
        GridPane.setHalignment(annullerBtn, HPos.LEFT);

    }

}
