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
import javafx.scene.layout.VBox;

public class DestillatTab {
    private static ListView<Destillat> destillatListView = new ListView<>();
    private static ObservableList destillatObservable = FXCollections.observableArrayList();

    public GridPane initContent() {
        //Load dummy-data
        //        MainVindue.initStorage();

        VBox destillatbox = new VBox(15);
        GridPane destillatTabContent = new GridPane();
        destillatTabContent.setAlignment(Pos.CENTER);
        destillatTabContent.setVgap(10);
        destillatTabContent.setHgap(20);


        VBox labelBox = new VBox(3.5);
        Label destillatListeLabel = new Label("Liste af oprettede destillater");
        Label visHistorikLabel = new Label("Tryk på et destillat for at se indholdet");

        VBox historikInfo = new VBox(10);
        Label historikLabel = new Label("Fad historik");
        InfoBox newMakeNummerInfo = new InfoBox("Vælg et fad..");
        InfoBox alkoholProcentInfo = new InfoBox("Vælg et fad..");
        InfoBox vandInfo = new InfoBox("Vælg et fad..");
        InfoBox mængdeInfo = new InfoBox("Vælg et fad..");
        InfoBox kornInfo = new InfoBox("Vælg et fad..");
        InfoBox tørvInfo = new InfoBox("Vælg et fad..");


        destillatListView.setOnMouseClicked(event -> {
            Destillat valgtDestillat = destillatListView.getSelectionModel().getSelectedItem();
            if (valgtDestillat != null) {

                newMakeNummerInfo.opdaterIndhold("New make nummer: " + valgtDestillat.getNmNummer());
                alkoholProcentInfo.opdaterIndhold("Alkohol procent: " + valgtDestillat.getAlkoholProcent());
                vandInfo.opdaterIndhold("Vandtype: " + valgtDestillat.getVand());
                mængdeInfo.opdaterIndhold("Mængde vand: " + valgtDestillat.getMængdeLiter() + " L");
                kornInfo.opdaterIndhold("Korn: " + valgtDestillat.getKornsort());
                tørvInfo.opdaterIndhold("Brugt tørv: " + valgtDestillat.getTørv());
            }
        });
        historikInfo.getChildren().addAll(historikLabel, newMakeNummerInfo, alkoholProcentInfo, vandInfo, mængdeInfo, kornInfo, tørvInfo);

        labelBox.getChildren().addAll(destillatListeLabel, visHistorikLabel);
        labelBox.setStyle("-fx-border-color: grey; " + "-fx-border-width: 2;" + "-fx-padding: 10;");


        destillatbox.getChildren().addAll(Knapper.OpretDestillatButton(), labelBox, destillatListView);

        opdaterDestillatList();
        destillatListView.setItems(destillatObservable);

        destillatTabContent.add(destillatbox, 0, 0);
        destillatTabContent.add(historikInfo, 1, 0);

        return destillatTabContent;
    }

    public static void opdaterDestillatList() {
        destillatObservable.clear();
        for (Destillat destillat : Controller.getDestillater()) {
            if (destillat != null && destillat.getMængdeLiter() > 0) {
                destillatObservable.add(destillat);
            }
        }
        destillatListView.setItems(destillatObservable);
    }
}
