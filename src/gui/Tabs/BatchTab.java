package gui.Tabs;

import application.model.Batch;
import gui.elements.InfoBox;
import gui.elements.Knapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import storage.Storage;

public class BatchTab {
    private ListView<Batch> batchListView = new ListView<>();
    private ObservableList batchObservable = FXCollections.observableArrayList();

    public GridPane initContent() {
        GridPane batchTabContent = new GridPane();
        batchTabContent.setAlignment(Pos.CENTER);

        VBox batchBox = new VBox(15);
        batchTabContent.setPrefWidth(1260);
        batchTabContent.setPrefHeight(800);
        batchTabContent.setVgap(10);

        Label batchListeLabel = new Label("Liste af oprettede batches");
        Label visHistorikLabel = new Label("Tryk på en batch for at se indholdet");

        VBox labelBox = new VBox(3.5);
        labelBox.getChildren().addAll(batchListeLabel, visHistorikLabel);
        labelBox.setStyle("-fx-border-color: grey; " + "-fx-border-width: 2;" + "-fx-padding: 10;");
        batchBox.getChildren().addAll(Knapper.OpretBatchButton(), labelBox, batchListView);

        batchObservable.setAll(Storage.getBatches());
        batchListView.setItems(batchObservable);

        batchTabContent.add(batchBox, 0, 0);

        VBox historikInfo = new VBox(10);
        InfoBox batchNummerInfo = new InfoBox("Vælg en batch..");
        InfoBox batchNavnInfo = new InfoBox("Vælg en batch..");

        batchListView.setOnMouseClicked(event -> {
            Batch valgtBatch = batchListView.getSelectionModel().getSelectedItem();
            if (valgtBatch != null) {
                batchNummerInfo.opdaterIndhold(String.valueOf(valgtBatch.getBatchNummer()));
                batchNavnInfo.opdaterIndhold(valgtBatch.getBatchNavn());
            }
        });


        historikInfo.getChildren().addAll(batchNummerInfo);
        batchTabContent.add(historikInfo, 1, 0);


        return batchTabContent;
    }


}
