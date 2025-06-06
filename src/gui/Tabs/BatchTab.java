package gui.Tabs;

import application.controller.Controller;
import application.model.BatchIndhold.Batch;
import application.model.FadIndhold.Fad;
import application.model.FadVæskeKontrol.Tapning;
import application.model.Raavarer.Kornsort;
import gui.Elements.InfoBox;
import gui.Elements.Knapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import storage.Storage;

public class BatchTab {
    private static ListView<Batch> batchListView = new ListView<>();
    private ObservableList batchObservable = FXCollections.observableArrayList();

    public GridPane initContent() {
        GridPane batchTabContent = new GridPane();
        batchTabContent.setAlignment(Pos.CENTER);

        VBox batchBox = new VBox(15);
        batchTabContent.setPrefWidth(1260);
        batchTabContent.setPrefHeight(800);
        batchTabContent.setVgap(20);
        batchTabContent.setHgap(25);

        Label batchListeLabel = new Label("Liste af oprettede batches");
        Label visHistorikLabel = new Label("Tryk på en batch for at se indholdet");

        HBox knapperBox = new HBox(25);
        knapperBox.getChildren().addAll(Knapper.OpretBatchButton(), Knapper.opretFuldHistorikButton());

        VBox labelBox = new VBox(3.5);
        labelBox.getChildren().addAll(batchListeLabel, visHistorikLabel);
        labelBox.setStyle("-fx-border-color: grey; " + "-fx-border-width: 2;" + "-fx-padding: 10;");
        batchBox.getChildren().addAll(knapperBox, labelBox, batchListView);


        batchObservable.setAll(Storage.getBatches());
        batchListView.setItems(batchObservable);

        batchTabContent.add(batchBox, 0, 1);

        VBox historikInfo = new VBox(10);
        Label historikLabel = new Label("Batch historik");
        InfoBox batchNummerInfo = new InfoBox("Vælg en batch..");
        InfoBox batchNavnInfo = new InfoBox("Vælg en batch..");
        InfoBox fadTypeInfo = new InfoBox("Vælg en batch..");
        InfoBox kornsortInfo = new InfoBox("Vælg en batch..");
        InfoBox fortyndelseInfo = new InfoBox("Vælg en batch..");
        InfoBox antalFlaskerIBatch = new InfoBox("Vælg en batch..");
        InfoBox tapningMedarbejder = new InfoBox("Vælg en batch..");


        batchListView.setOnMouseClicked(event -> {
            Batch valgtBatch = batchListView.getSelectionModel().getSelectedItem();
            if (valgtBatch != null) {
                batchNummerInfo.opdaterIndhold("Batch nummer: " + valgtBatch.getBatchNummer());
                batchNavnInfo.opdaterIndhold("Batch navn: " + valgtBatch.getBatchNavn());
                fortyndelseInfo.opdaterIndhold("Fortyndelse: " + valgtBatch.getFortyndelseLiter() + "L");
                fadTypeInfo.opdaterIndhold("Fadtype: " + valgtBatch.getFadtyper());
                StringBuilder kornsortBuilderInfo = new StringBuilder("\n");
                for (Kornsort råvarer : valgtBatch.getKornsorter()) {
                    kornsortBuilderInfo.append(råvarer.getNavn()).append("\n");
                }
                kornsortInfo.opdaterIndhold("Kornsort i batch: " + kornsortBuilderInfo);
                antalFlaskerIBatch.opdaterIndhold("Antal flasker i Batch: " + valgtBatch.getFlasker().size());

                Tapning tapning = valgtBatch.getTapning();
                if (tapning != null) {
                    Fad fad = tapning.getFad();
                    if (fad != null) {
                        StringBuilder tappetBuilder = new StringBuilder();

                        tappetBuilder.append(fad.getTappetAf()).append(" - ").append(fad.getTapningsDato()).append("\n");

                        tapningMedarbejder.opdaterIndhold("Tappet af: \n" + tappetBuilder);
                    } else {
                        tapningMedarbejder.opdaterIndhold("Intet fad fundet");
                    }
                } else {
                    tapningMedarbejder.opdaterIndhold("Ingen tapning foretaget");
                }
            }
        });


        historikInfo.getChildren().addAll(historikLabel, batchNummerInfo, batchNavnInfo, fortyndelseInfo, fadTypeInfo, kornsortInfo, antalFlaskerIBatch, tapningMedarbejder);
        batchTabContent.add(historikInfo, 1, 1);

        return batchTabContent;
    }

    public static void updaterBatchList() {
        batchListView.getItems().setAll(Controller.getBatches());
    }

    public static Batch getBatch() {
        return batchListView.getSelectionModel().getSelectedItem();
    }

}
