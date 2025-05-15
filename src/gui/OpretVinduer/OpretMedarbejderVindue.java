package gui.OpretVinduer;

import application.controller.Controller;
import application.model.Medarbejdere.Medarbejder;
import gui.Elements.InfoBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OpretMedarbejderVindue extends Stage {
    private TextField medarbejderNavnTxtField = new TextField();
    private TextField medarbejderNummerTxtField = new TextField();
    private ListView medarbejderListview = new ListView<>();
    private ObservableList medarbejderObservableList = FXCollections.observableArrayList();

    public OpretMedarbejderVindue(String title) {
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
        pane.setPrefWidth(750);
        pane.setHgap(25);
        pane.setVgap(25);


        VBox medarbejderBox = new VBox(7.5);
        Label medarbejderNavnLabel = new Label("Medarbejder navn: ");
        medarbejderNavnTxtField.setPromptText("Indtast medarbejder navn");

        Label medarbejderNummer = new Label("Medarbejder nummer: ");
        medarbejderNummerTxtField.setPromptText("Indtast medarbejder nummer");


        VBox listviewBox = new VBox(7.5);

        Label eksisterendeMedarbejdereLabel = new Label("Her kan du se de eksisterende medarbejdere");
        medarbejderObservableList.addAll(Controller.getMedarbejdere());
        medarbejderListview.setItems(medarbejderObservableList);

        VBox medarbejderInfoBox = new VBox(7.5);
        InfoBox medarbejderNavnInfo = new InfoBox("Vælg en medarbejder..");
        InfoBox medarbejderNummerInfo = new InfoBox("Vælg en medarbejder..");


        medarbejderListview.setOnMouseClicked(event -> {
            Medarbejder valgtMedarbejder = (Medarbejder) medarbejderListview.getSelectionModel().getSelectedItem();
            if (valgtMedarbejder != null) {
                medarbejderNavnInfo.opdaterIndhold("Navn: " + valgtMedarbejder.getNavn());
                medarbejderNummerInfo.opdaterIndhold("Medarbejder nummer: " + valgtMedarbejder.getMedarbejderNr());
            }
        });

        Button opretMedarbejderBtn = new Button("Opret medarbejder");
        opretMedarbejderBtn.setOnMouseClicked(event -> {
            try {
                Controller.opretMedarbejder(Integer.parseInt(medarbejderNummerTxtField.getText()), medarbejderNavnTxtField.getText());

                medarbejderObservableList.clear();
                medarbejderObservableList.addAll(Controller.getMedarbejdere());
                medarbejderListview.setItems(medarbejderObservableList);

                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Medarbejder oprettet1");
                succesAlert.setHeaderText("Medarbejder oprettet");
                succesAlert.show();
            } catch (NumberFormatException e) {
                if (medarbejderNummerTxtField.getText().isEmpty() || medarbejderNavnTxtField.getText().isEmpty()) {
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

        listviewBox.getChildren().addAll(eksisterendeMedarbejdereLabel, medarbejderListview);
        pane.add(listviewBox, 1, 0);

        medarbejderInfoBox.getChildren().addAll(medarbejderNavnInfo, medarbejderNummerInfo);
        pane.add(medarbejderInfoBox, 2, 0);

        medarbejderBox.getChildren().addAll(medarbejderNavnLabel, medarbejderNavnTxtField, medarbejderNummer, medarbejderNummerTxtField, opretMedarbejderBtn);
        pane.add(medarbejderBox, 0, 0);


    }
}
