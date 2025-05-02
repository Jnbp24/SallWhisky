package gui;

import application.controller.Controller;
import application.model.Kornsort;
import application.model.Ristethed;
import application.model.Råvarer;
import application.model.Vand;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpretDestillatVindue extends Stage {
    private TextField nmNummerTxtField = new TextField();
    private TextField alkolholProcentTxtField = new TextField();
    private TextField kornsortTxtField = new TextField();
    private TextField kornsortLokationTxtField = new TextField();
    private TextField vandTxtfield = new TextField();
    private TextField vandLokationTxtField = new TextField();

    public OpretDestillatVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(500);
        pane.setPrefWidth(300);

        Label newMakeNummerLabel = new Label("New make nummer: ");
        nmNummerTxtField.setPromptText("Indtast new make nummer");
        pane.add(nmNummerTxtField, 1, 0);
        pane.add(newMakeNummerLabel, 0, 0);

        Label alkoholprocentLabel = new Label("Alkohol procent: ");
        alkolholProcentTxtField.setPromptText("Indtast alkohol procent");
        pane.add(alkolholProcentTxtField, 1, 1);
        pane.add(alkoholprocentLabel, 0, 1);


        Label kornsortLabel = new Label("Kornsort: ");
        kornsortTxtField.setPromptText("Indtast kornsort");
        pane.add(kornsortTxtField, 1, 2);
        pane.add(kornsortLabel, 0, 2);

        Label kornsortLokationLabel = new Label("Kornsort lokation: ");
        kornsortLokationTxtField.setPromptText("Indtast lokation");
        pane.add(kornsortLokationTxtField, 1, 3);
        pane.add(kornsortLokationLabel, 0, 3);

        CheckBox ikkeRistetBox = new CheckBox("Ikke ristet");
        CheckBox letRistetBox = new CheckBox("Let ristet");
        CheckBox sværtRistetBox = new CheckBox("Svært ristet");
        VBox RistetboxGroup = new VBox(ikkeRistetBox,letRistetBox,sværtRistetBox);

        Label RistethedLabel = new Label("Vælg ristethed");
        pane.add(RistetboxGroup,1,4);
        pane.add(RistethedLabel,0,4);







        Label vandLabel = new Label("By: ");
        vandTxtfield.setPromptText("Indtast by");
        pane.add(vandTxtfield, 1, 5);
        pane.add(vandLabel, 0, 5);

        Label vandLokationLabel = new Label("Vand lokation: ");
        vandLokationTxtField.setPromptText("Indtast lokation");
        pane.add(vandLokationTxtField, 1, 6);
        pane.add(vandLokationLabel, 0, 6);


        Label tørvLabel = new Label("Er det brugt tørv?");
        CheckBox tørvBox = new CheckBox();
        pane.add(tørvBox, 1, 7);
        pane.add(tørvLabel, 0, 7);


        Button opretBtn = new Button("Opret Destillat");
        opretBtn.setOnMouseClicked(event -> {
            try {
//                Kornsort kornsort = new Kornsort(kornsortTxtField.getText());
//                Vand vand = new Vand(vandTxtfield.getText());


//                Controller.opretDestillat(nmNummerTxtField.getText(), Integer.parseInt(alkolholProcentTxtField.getText()), kornsortTxtField.getText(), vandTxtfield.getText(), tørvBox.isSelected());
                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Destillat oprettet!");
                succesAlert.setHeaderText("Dit destillat er nu oprettet");
                succesAlert.show();
            } catch (NumberFormatException e) {
                if (nmNummerTxtField.getText().isEmpty() || alkolholProcentTxtField.getText().isEmpty() || kornsortTxtField.getText().isEmpty() || vandTxtfield.getText().isEmpty()) {
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

        pane.add(opretBtn, 1, 8);
        GridPane.setHalignment(opretBtn, HPos.RIGHT);


        Button annullerBtn = new Button("Annuller");
        annullerBtn.setOnMouseClicked(event -> {
            this.close();
        });
        pane.add(annullerBtn, 0, 8);
        GridPane.setHalignment(annullerBtn, HPos.LEFT);


    }


}
