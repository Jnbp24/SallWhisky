package gui.Tabs;

import application.controller.Controller;
import application.model.Fad;
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
        MainVindue.initStorage();

        GridPane fadTabContent = new GridPane();
        fadTabContent.setAlignment(Pos.CENTER);
        fadTabContent.setVgap(10);

        Label FadListeLabel = new Label("Liste af oprettede fade - Tryk på et fad for at tilføje et destillat");
        Label visHistorikLabel = new Label("Tryk på et fad for at se indholdet");

        VBox labelBox = new VBox(3.5);
        labelBox.getChildren().addAll(FadListeLabel, visHistorikLabel);
        labelBox.setStyle("-fx-border-color: grey; " + "-fx-border-width: 2;" + "-fx-padding: 10;");


        HBox Knapbox = new HBox(200);
        Knapbox.getChildren().addAll(Knapper.OpretFadButton(), Knapper.TilføjDestillatButton(fadListView));


        fadTabContent.add(Knapbox, 0, 0);
        fadTabContent.add(labelBox, 0, 1);
        fadTabContent.add(fadListView, 0, 2);
        fadListView.setItems(fadObservable);
        updateFadList();


        VBox historikInfo = new VBox(10);
        InfoBox fadTypeInfo = new InfoBox("Vælg et fad..");
        InfoBox kapacitetInfo = new InfoBox("Vælg et fad..");

        fadListView.setOnMouseClicked(event -> {
            Fad valgtFad = fadListView.getSelectionModel().getSelectedItem();
            if (valgtFad != null) {
                fadTypeInfo.opdaterIndhold("Fadtype: " + valgtFad.getBeskrivelse());
                kapacitetInfo.opdaterIndhold("Fadstørrelse: " + valgtFad.getFadStørrelse() + " liter");
            }
        });


        historikInfo.getChildren().addAll(fadTypeInfo, kapacitetInfo);
        fadTabContent.add(historikInfo, 1, 0);
        return fadTabContent;
    }

    public void updateFadList() {
        fadObservable.setAll(Controller.getFadList());
    }
}
