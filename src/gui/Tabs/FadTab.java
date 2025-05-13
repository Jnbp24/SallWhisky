package gui.Tabs;

import application.controller.Controller;
import application.model.Destillat;
import application.model.Fad;
import application.model.Påfyldning;
import gui.elements.InfoBox;
import gui.elements.Knapper;
import gui.mainVindue.MainVindue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FadTab {
    private static ListView<Fad> fadListView = new ListView<>();
    private ObservableList fadObservable = FXCollections.observableArrayList();

    public GridPane initContent() {
        //Load dummy-data
        //        MainVindue.initStorage();

        GridPane fadTabContent = new GridPane();
        fadTabContent.setAlignment(Pos.CENTER);
        fadTabContent.setVgap(10);
        fadTabContent.setHgap(20);

        Label FadListeLabel = new Label("Liste af oprettede fade - Tryk på et fad for at tilføje et destillat");
        Label visHistorikLabel = new Label("Tryk på et fad for at se indholdet");

        VBox labelBox = new VBox(3.5);
        labelBox.getChildren().addAll(FadListeLabel, visHistorikLabel);
        labelBox.setStyle("-fx-border-color: grey; " + "-fx-border-width: 2;" + "-fx-padding: 10;");


        HBox Knapbox = new HBox(75);
        Knapbox.getChildren().addAll(Knapper.OpretFadButton(), Knapper.TilføjDestillatButton(fadListView), Knapper.opretOmhældningButton());

        VBox listebox = new VBox(10);
        listebox.getChildren().addAll(Knapbox, labelBox, fadListView);


        fadTabContent.add(listebox, 0, 0);
        fadListView.setItems(fadObservable);
        updateFadList();


        VBox historikInfo = new VBox(10);
        Label historikLabel = new Label("Fad historik");
        InfoBox fadNummerInfo = new InfoBox("Vælg et fad..");
        InfoBox fadTypeInfo = new InfoBox("Vælg et fad..");
        InfoBox kapacitetInfo = new InfoBox("Vælg et fad..");
        InfoBox antalGangeBrugtInfo = new InfoBox("Vælg et fad..");
        InfoBox destillaterInfo = new InfoBox("Vælg et fad..");
        InfoBox medarbejderInfo = new InfoBox("Vælg et fad..");

        fadListView.setOnMouseClicked(event -> {
            Fad valgtFad = fadListView.getSelectionModel().getSelectedItem();
            if (valgtFad != null) {

                fadNummerInfo.opdaterIndhold("Fadnummer: " + valgtFad.getNummer());
                fadTypeInfo.opdaterIndhold("Fadtype: " + valgtFad.getType());
                kapacitetInfo.opdaterIndhold("Fadstørrelse: " + valgtFad.getFadStørrelse() + " liter");
                antalGangeBrugtInfo.opdaterIndhold("Antal gange brugt: " + valgtFad.getAntalGangeBrugt());

                StringBuilder destillatBuilderInfo = new StringBuilder("\n");
                for (Destillat destillat : valgtFad.getDestillater()) {
                    destillatBuilderInfo.append(destillat.getNmNummer()).append("\n");
                }
                destillaterInfo.opdaterIndhold("New make nummer i fad: " + destillatBuilderInfo);

                StringBuilder påfyldningBuilderInfo = new StringBuilder();
                for (String påfyldninger : valgtFad.getPåfyldninger()) {
                    påfyldningBuilderInfo.append(påfyldninger).append(" - ").append(valgtFad.getPåfyldningsDato()).append("\n");
                }
                medarbejderInfo.opdaterIndhold("Påfyldninger: \n" + påfyldningBuilderInfo);
            }
        });


        historikInfo.getChildren().addAll(historikLabel, fadNummerInfo, fadTypeInfo, kapacitetInfo, antalGangeBrugtInfo, destillaterInfo, medarbejderInfo);
        fadTabContent.add(historikInfo, 1, 0);
        return fadTabContent;
    }

    public void updateFadList() {
        fadObservable.setAll(Controller.getFadList());
    }
}
