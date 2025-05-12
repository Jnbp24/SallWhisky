package gui.OpretVinduer;

import application.controller.Controller;
import gui.Tabs.FadTab;
import gui.mainVindue.MainVindue;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretFadVindue extends Stage {
    private TextField fadNummerTxtField = new TextField();
    private TextField fadTypeTxtField = new TextField();
    private TextField fadStørrelseTxtField = new TextField();
    private TextField antalGangeBrugtTxtField = new TextField();


    public OpretFadVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        FadTab fadTab = new FadTab();

        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(200);
        pane.setPrefWidth(300);

        Label fadNummerLabel = new Label("Fadnummer: ");
        fadNummerTxtField.setPromptText("Indtast nummer for fadet");
        pane.add(fadNummerTxtField, 1, 0);
        pane.add(fadNummerLabel, 0, 0);

        Label fadTypeLabel = new Label("Fadtype: ");
        fadTypeTxtField.setPromptText("Indtast fadtype");
        pane.add(fadTypeTxtField, 1, 1);
        pane.add(fadTypeLabel, 0, 1);

        Label fadStørrelseLabel = new Label("Fad størrelse liter");
        fadStørrelseTxtField.setPromptText("Indtast fadets størrelse");
        pane.add(fadStørrelseTxtField, 1, 2);
        pane.add(fadStørrelseLabel, 0, 2);

        Label antalGangeBrugtLabel = new Label("Antal gange brugt: ");
        antalGangeBrugtTxtField.setPromptText("Antal gange brugt");
        pane.add(antalGangeBrugtTxtField, 1, 3);
        pane.add(antalGangeBrugtLabel, 0, 3);


        Button opretBtn = new Button("Opret Fad");
        opretBtn.setOnMouseClicked(event -> {
            try {
                Controller.opretFad(Integer.parseInt(fadNummerTxtField.getText()), fadTypeTxtField.getText(), Integer.parseInt(fadStørrelseTxtField.getText()), Integer.parseInt(antalGangeBrugtTxtField.getText()));
                fadTab.updateFadList();
                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Fad oprettet!");
                succesAlert.setHeaderText("Dit fad er nu oprettet");
                succesAlert.show();
                this.close();
            } catch (NumberFormatException e) {
                if (fadNummerTxtField.getText().isEmpty() || fadTypeTxtField.getText().isEmpty() || fadStørrelseTxtField.getText().isEmpty() || antalGangeBrugtTxtField.getText().isEmpty()) {
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

        pane.add(opretBtn, 1, 6);
        GridPane.setHalignment(opretBtn, HPos.RIGHT);


        Button annullerBtn = new Button("Annuller");
        annullerBtn.setOnMouseClicked(event -> {
            this.close();
        });
        pane.add(annullerBtn, 0, 6);
        GridPane.setHalignment(annullerBtn, HPos.LEFT);


    }


}
