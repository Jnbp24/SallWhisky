package gui.OpretVinduer;

import application.controller.Controller;
import application.model.Fad;
import application.model.Information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class OpretBatchVindue extends Stage {
    private ListView<Fad> fadListView = new ListView<>();
    private TextField fadNavnTextField = new TextField();
    private TextField batchNavnTxtField = new TextField();
    private TextField batchNummerTxtField = new TextField();
    private TextField fortyndelseTxtField = new TextField();
    private TableView<Information> informationTableView = new TableView<>();
    private ObservableList<String> flaskerListe = FXCollections.observableArrayList();


    public OpretBatchVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setPrefHeight(450);
        pane.setPrefWidth(500);
        pane.setVgap(10);
        pane.setHgap(30);

        Label vælgFadLabel = new Label("Vælg et fad der ønskes tappet:");
        fadListView.getItems().setAll(Storage.getFade());
        fadListView.setPrefHeight(300);

        fadListView.setOnMouseClicked(event -> {
            fadNavnTextField.setText(String.valueOf(fadListView.getSelectionModel().getSelectedItem()));
        });

        Label fadNavnLabel = new Label("Fad: ");
        fadNavnTextField.setPromptText("Fad navn: ");
        fadNavnTextField.setEditable(false);


        Label batchNavn = new Label("Batch navn: ");
        batchNavnTxtField.setPromptText("Indtast navn på batch");

        Label batchNummer = new Label("Batch Nummer: ");
        batchNummerTxtField.setPromptText("Indtast nummer på batch");

        Button minusBtn = new Button("-");
        minusBtn.setOnMouseClicked(event -> {
            try {
                int værdi = Integer.parseInt(fortyndelseTxtField.getText());
                fortyndelseTxtField.setText((String.valueOf(værdi - 1)));
            } catch (NumberFormatException e) {
                Alert udfyldBoxAlert = new Alert(Alert.AlertType.ERROR);
                udfyldBoxAlert.setTitle("Indsæt fortyndelsesliter.");
                udfyldBoxAlert.setHeaderText("Indtast et gyldigt tal.");
                udfyldBoxAlert.show();
            }
        });
        fortyndelseTxtField.setPrefWidth(40);
        Button plusBtn = new Button("+");
        plusBtn.setOnMouseClicked(event -> {
            try {
                int værdi = Integer.parseInt(fortyndelseTxtField.getText());
                fortyndelseTxtField.setText((String.valueOf(værdi + 1)));
            } catch (NumberFormatException e) {
                Alert udfyldBoxAlert = new Alert(Alert.AlertType.ERROR);
                udfyldBoxAlert.setTitle("Indsæt fortyndelsesliter.");
                udfyldBoxAlert.setHeaderText("Indtast et gyldigt tal.");
                udfyldBoxAlert.show();
            }
        });


//        fortyndelseTxtField.setText(String.valueOf(Integer.parseInt(fortyndelseTxtField.getText()) + 1)));


        Label fortyndelseLabel = new Label("Fortyndelse i liter: ");


        Button lavTapningBtn = new Button("Foretag tapning");
        lavTapningBtn.setOnMouseClicked(event -> {

            try {
                Controller.opretBatch(fadListView.getSelectionModel().getSelectedItem(), batchNavnTxtField.getText(), Integer.parseInt(batchNummerTxtField.getText()), Double.parseDouble(fortyndelseTxtField.getText()));
                informationTableView.refresh();
                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Batch oprettet!");
                succesAlert.setHeaderText("Batch er er nu oprettet");
                succesAlert.show();
                this.close();
            } catch (NumberFormatException e) {
                if (fadListView.getSelectionModel().isEmpty() || batchNavnTxtField.getText().isEmpty() || batchNummerTxtField.getText().isEmpty() || fortyndelseTxtField.getText().isEmpty()) {
                    Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                    fejlAlert.setTitle("Invalid information");
                    fejlAlert.setHeaderText("Alle felter skal udfyldes");
                    fejlAlert.show();
                } else {
                    Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                    fejlAlert.setTitle("Invalid information");
                    fejlAlert.setHeaderText("Ugyldig information indtastet");
                    fejlAlert.show();
                }
            }
        });

        HBox fortyndelseBox = new HBox(minusBtn, fortyndelseTxtField, plusBtn);
        pane.add(fortyndelseBox, 2, 1);
        VBox listBox = new VBox(vælgFadLabel, fadListView);
        listBox.setSpacing(5);
        pane.add(listBox, 0, 0);

        Label estimatLabel = new Label("Antal flaske estimat: ");
        TextField estimatTxtfield = new TextField();
        pane.add(estimatTxtfield, 2, 3);
        estimatTxtfield.setEditable(false);

        flaskerListe.add("1L flaske");
        flaskerListe.add("1.5L flaske");
        flaskerListe.add("2L flaske");

        ComboBox flaskeCombobox = new ComboBox<>(flaskerListe);
        flaskeCombobox.setPromptText("Vælg flaskestørrelse: ");


        VBox tapningVBox = new VBox(fortyndelseLabel, fortyndelseBox);
        VBox informationBox = new VBox(fadNavnLabel, fadNavnTextField, batchNavn, batchNavnTxtField, batchNummer, batchNummerTxtField, tapningVBox, estimatLabel, estimatTxtfield, flaskeCombobox, lavTapningBtn);
        informationBox.setSpacing(7.5);
        pane.add(informationBox, 2, 0);
    }
}

