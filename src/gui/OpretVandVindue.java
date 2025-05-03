package gui;

import application.controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretVandVindue extends Stage {
    private TextField vandTypeTxtField = new TextField();
    private TextField vandLokationTxtField = new TextField();
    private TextField vandMængdeTxtField = new TextField();

    public OpretVandVindue(String title) {

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

        Label vandLabel = new Label("By: ");
        vandTypeTxtField.setPromptText("Indtast by");
        pane.add(vandTypeTxtField, 1, 0);
        pane.add(vandLabel, 0, 0);

        Label vandLokationLabel = new Label("Vand lokation: ");
        vandLokationTxtField.setPromptText("Indtast lokation");
        pane.add(vandLokationTxtField, 1, 1);
        pane.add(vandLokationLabel, 0, 1);

        Label vandMængdeLabel = new Label("Mængde i liter: ");
        vandMængdeTxtField.setPromptText("Indtast mængde");
        pane.add(vandMængdeTxtField,1,2);
        pane.add(vandMængdeLabel,0,2);


        Button opretBtn = new Button("Opret Vand");
        opretBtn.setOnMouseClicked(event -> {
            try {
                Controller.opretVand(vandTypeTxtField.getText(),vandLokationTxtField.getText(),Integer.parseInt(vandMængdeTxtField.getText()));
                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Vandtype oprettet!");
                succesAlert.setHeaderText("Din vandtype er nu oprettet");
                succesAlert.show();
                this.close();
            } catch (NumberFormatException e) {
                if (vandTypeTxtField.getText().isEmpty() || vandLokationTxtField.getText().isEmpty() || vandMængdeTxtField.getText().isEmpty()) {
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
        pane.add(opretBtn,1,3);
        GridPane.setHalignment(opretBtn,HPos.RIGHT);

        Button annullerBtn = new Button("Annuller");
        annullerBtn.setOnMouseClicked(event -> {
            this.close();
        });
        pane.add(annullerBtn, 0, 3);
        GridPane.setHalignment(annullerBtn, HPos.LEFT);

    }
}
