package gui.OpretVinduer;

import application.controller.Controller;
import application.model.Raavarer.Kornsort;
import application.model.Raavarer.Vand;
import gui.Tabs.DestillatTab;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OpretDestillatVindue extends Stage {
    private TextField nmNummerTxtField = new TextField();
    private TextField alkolholProcentTxtField = new TextField();
    private CheckBox tørvBox = new CheckBox();

    private ListView<Kornsort> kornsortListView = new ListView<>();
    private ListView<Vand> vandtyperListView = new ListView<>();
    private ObservableList<Kornsort> kornsortList = FXCollections.observableArrayList();
    private ObservableList<Vand> vandtypeList = FXCollections.observableArrayList();

    public OpretDestillatVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);

        loadKornOgVandListe();
    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(650);
        pane.setPrefWidth(600);


        Label newMakeNummerLabel = new Label("New make nummer: ");
        nmNummerTxtField.setPromptText("Indtast new make nummer");
        pane.add(nmNummerTxtField, 1, 0);
        pane.add(newMakeNummerLabel, 0, 0);

        Label alkoholprocentLabel = new Label("Alkohol procent: ");
        alkolholProcentTxtField.setPromptText("Indtast alkohol procent");
        pane.add(alkolholProcentTxtField, 1, 1);
        pane.add(alkoholprocentLabel, 0, 1);

        Label tørvLabel = new Label("Er det brugt tørv?");
        pane.add(tørvBox, 1, 2);
        pane.add(tørvLabel, 0, 2);

        Label kornsortLabel = new Label("Vælg Korn: ");
        pane.add(kornsortLabel, 0, 4);
        pane.add(kornsortListView, 1, 4);
        kornsortListView.setPrefHeight(200);
        kornsortListView.setPrefWidth(200);
        GridPane.setHalignment(kornsortLabel, HPos.LEFT);
        GridPane.setHalignment(kornsortListView, HPos.CENTER);

        Label vandtypeLabel = new Label("Vælg Vandtype: ");
        pane.add(vandtypeLabel, 0, 5);
        pane.add(vandtyperListView, 1, 5);
        vandtyperListView.setPrefHeight(200);
        vandtyperListView.setPrefWidth(200);

        Button opretDestillat = new Button("Opret Destillat");
        opretDestillat.setOnMouseClicked(event -> {
            Kornsort valgtKorn = null;
            Vand valgtVand = null;
            try {
                String newMakeNummer = nmNummerTxtField.getText().toUpperCase();
                if (!newMakeNummer.startsWith("NM")){
                    newMakeNummer = "NM" + nmNummerTxtField.getText().toUpperCase();
                }
                double alkoholProcent = Double.parseDouble(alkolholProcentTxtField.getText());
                boolean erTørv = tørvBox.isSelected();
                valgtKorn = kornsortListView.getSelectionModel().getSelectedItem();
                valgtVand = vandtyperListView.getSelectionModel().getSelectedItem();
                if (newMakeNummer.isEmpty() || valgtKorn == null || valgtVand == null) {
                    throw new IllegalArgumentException("Alle felter skal udfyldes");
                }

                //Highlighter det sidste valgte emne i listviewet så brugeren ved hvad de har valgt
                kornsortListView.getSelectionModel().select(valgtKorn);
                vandtyperListView.getSelectionModel().select(valgtVand);

                Controller.opretDestillat(newMakeNummer, alkoholProcent, valgtKorn, valgtVand, erTørv);
                DestillatTab.opdaterDestillatList();


                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Destillat oprettet");
                succesAlert.setHeaderText("Dit destillat er oprettet");
                succesAlert.show();
                this.close();
            } catch (IllegalArgumentException e) {
                if (valgtKorn != null && valgtVand != null) {
                    Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                    infoAlert.setTitle("Valg bekræftet");
                    infoAlert.setHeaderText("Du har valgt: ");
                    infoAlert.setContentText("Korn: " + valgtKorn + "\nVand: " + valgtVand);
                    infoAlert.show();
                }
                else {
                    Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                    fejlAlert.setTitle("Fejl");
                    fejlAlert.setHeaderText("Ugyldigt valg");
                    fejlAlert.setContentText("Vælg både korn og vand");
                    fejlAlert.show();
                }
            }
        });
        pane.add(opretDestillat, 1, 7);
        GridPane.setHalignment(opretDestillat, HPos.RIGHT);

        Button annullerBtn = new Button("Annuller");
        annullerBtn.setOnMouseClicked(event -> {
            this.close();
        });
        pane.add(annullerBtn, 0, 7);
        GridPane.setHalignment(annullerBtn, HPos.LEFT);


    }

    private void loadKornOgVandListe() {
        kornsortList.setAll(Controller.getKornList());
        vandtypeList.setAll(Controller.getVandTypeList());

        kornsortListView.setItems(kornsortList);
        vandtyperListView.setItems(vandtypeList);
    }


}
