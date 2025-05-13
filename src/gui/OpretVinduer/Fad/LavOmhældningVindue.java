package gui.OpretVinduer.Fad;

import application.controller.Controller;
import application.model.Fad;
import application.model.Medarbejder;
import gui.elements.InfoBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LavOmhældningVindue extends Stage {
    private ListView<Fad> kildeListView = new ListView<>();
    private ObservableList kildeObservable = FXCollections.observableArrayList();

    private ListView<Fad> destinationListView = new ListView<>();
    private ObservableList destinationObservable = FXCollections.observableArrayList();

    private TextField omhældningsMængdeTxtField = new TextField();

    public LavOmhældningVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(35));
        pane.setVgap(20);
        pane.setHgap(25);

        HBox omhældningBox = new HBox(20);
        VBox omhældningsInfo = new VBox();
        VBox kildeFadBox = new VBox(7.5);
        VBox destinationFadBox = new VBox(7.5);

        omhældningsInfo.setAlignment(Pos.CENTER);

        Label kildeFadLabel = new Label();
        Label destinationsFadLabel = new Label();
        kildeFadLabel.setVisible(false);
        destinationsFadLabel.setVisible(false);


        InfoBox kildeFadInfo = new InfoBox("Vælg venligst et kilde fad");
        InfoBox kildeFadForklaring = new InfoBox("Kildefad: Indeholder væsken der ønskes omhældet");


        InfoBox destinationFadInfo = new InfoBox("Vælg venligst et destinations fad");
        InfoBox destinationFadForklaring = new InfoBox("Destinations fad: Fadet der modtager væsken der omhældes");
        destinationFadInfo.setVisible(false);
        destinationFadForklaring.setVisible(false);


        kildeObservable.addAll(Controller.getFadList());
        kildeListView.setItems(kildeObservable);

        destinationObservable.addAll(Controller.getFadList());
        destinationListView.setItems(destinationObservable);
        destinationListView.setVisible(false);

        //Gemmer destinationsview før kildelistview item er valgt
        kildeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if (newValue != null) {
                destinationListView.setVisible(true);
                destinationFadInfo.setVisible(true);
                destinationFadForklaring.setVisible(true);
                kildeFadLabel.setVisible(true);
                destinationsFadLabel.setVisible(true);
            }
            else {
                destinationListView.setVisible(false);


            }
        });


        kildeFadBox.getChildren().addAll(kildeFadInfo, kildeListView, kildeFadForklaring);
        destinationFadBox.getChildren().addAll(destinationFadInfo, destinationListView, destinationFadForklaring);


        Button foretagOmhældningBtn = new Button("Omhæld");
        foretagOmhældningBtn.setOnMouseClicked(event -> {
            try {
                Fad valgtKildeFad = kildeListView.getSelectionModel().getSelectedItem();
                Fad valgtDestination = destinationListView.getSelectionModel().getSelectedItem();
                Controller.foretagOmhældning(valgtKildeFad, valgtDestination, Integer.parseInt(omhældningsMængdeTxtField.getText()));

                Alert succesAlert = new Alert(Alert.AlertType.CONFIRMATION);
                succesAlert.setTitle("Omhældning succesful");
                succesAlert.setHeaderText("Omhældning succesful");
                succesAlert.show();
                this.close();
            } catch (NumberFormatException e) {
                if (kildeListView.getSelectionModel().isEmpty() || destinationListView.getSelectionModel().isEmpty()) {
                    Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                    fejlAlert.setTitle("Invalid information");
                    fejlAlert.setHeaderText("Vælg både et kilde og et destinations fad");
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


        omhældningsInfo.getChildren().addAll(kildeFadLabel, destinationsFadLabel, omhældningsMængdeTxtField, foretagOmhældningBtn);
        omhældningBox.getChildren().addAll(kildeFadBox, omhældningsInfo, destinationFadBox);
        pane.add(omhældningBox, 0, 0);

    }
}
