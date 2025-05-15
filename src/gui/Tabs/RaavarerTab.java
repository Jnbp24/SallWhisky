package gui.Tabs;

import application.controller.Controller;
import application.model.Kornsort;
import application.model.Råvarer;
import gui.Elements.InfoBox;
import gui.Elements.Knapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RaavarerTab {
    private static ListView<Råvarer> kornsorterListview = new ListView<>();
    private static ObservableList<Råvarer> kornsorterObservable = FXCollections.observableArrayList();

    private static ListView<Råvarer> vandtyperListview = new ListView<>();
    private static ObservableList<Råvarer> vandtyperObservable = FXCollections.observableArrayList();

    public GridPane initContent() {

        GridPane råvarerTabContent = new GridPane();
        råvarerTabContent.setAlignment(Pos.CENTER);
        råvarerTabContent.setVgap(10);
        råvarerTabContent.setHgap(20);


        VBox kornBox = new VBox(7.5);
        kornsorterObservable.addAll(Controller.getKornList());
        kornsorterListview.setItems(kornsorterObservable);

        InfoBox kornInfoBox = new InfoBox("Her kan du se en liste af oprettede kornsorter");

        VBox kornHistorikInfo = new VBox(10);
        Label kornHistorikLabel = new Label("Korn historik");
        InfoBox kornsortNavnInfo = new InfoBox("Vælg korn..");
        InfoBox kornLokationInfo = new InfoBox("Vælg korn..");
        InfoBox kornMængdeInfo = new InfoBox("Vælg korn..");
        InfoBox kornRistethed = new InfoBox("Vælg korn..");

        kornBox.getChildren().addAll(Knapper.OpretKornButton(), kornInfoBox, kornsorterListview);

        VBox vandBox = new VBox(7.5);

        InfoBox vandtyperBox = new InfoBox("Her kan du se en liste af oprettede vandtyper");
        vandtyperObservable.addAll(Controller.getVandTypeList());
        vandtyperListview.setItems(vandtyperObservable);
        vandBox.getChildren().addAll(Knapper.OpretVandButton(), vandtyperBox, vandtyperListview);

        VBox vandHistorikInfo = new VBox(10);
        Label vandHistorikLabel = new Label("Vand historik");
        InfoBox vandTypeInfo = new InfoBox("Vælg vand..");
        InfoBox vandLokationInfo = new InfoBox("Vælg vand..");
        InfoBox vandMængdeILiterInfo = new InfoBox("Vælg vand..");


        kornHistorikInfo.getChildren().addAll(kornHistorikLabel, kornsortNavnInfo, kornLokationInfo, kornMængdeInfo, kornRistethed);
        vandHistorikInfo.getChildren().addAll(vandHistorikLabel, vandTypeInfo, vandLokationInfo, vandMængdeILiterInfo);
        råvarerTabContent.add(kornBox, 0, 0);
        råvarerTabContent.add(kornHistorikInfo, 1, 0);
        råvarerTabContent.add(vandBox, 2, 0);
        råvarerTabContent.add(vandHistorikInfo, 3, 0);


        kornsorterListview.setOnMouseClicked(event -> {
            Kornsort valgtKornsort = (Kornsort) kornsorterListview.getSelectionModel().getSelectedItem();
            kornsortNavnInfo.opdaterIndhold("Navn på kornsort: " + valgtKornsort.getNavn());
            kornLokationInfo.opdaterIndhold("Kornsort lokation: " + valgtKornsort.getLokation());
            kornMængdeInfo.opdaterIndhold("Korn mængde: " + valgtKornsort.getMængde());
            kornRistethed.opdaterIndhold("Ristethed: " + valgtKornsort.getRistethed() );
        });

        vandtyperListview.setOnMouseClicked(event -> {
            Råvarer valgtVand = vandtyperListview.getSelectionModel().getSelectedItem();
            vandTypeInfo.opdaterIndhold("Vandtype: " + valgtVand.getNavn());
            vandLokationInfo.opdaterIndhold("Vand lokation: " + valgtVand.getLokation());
            vandMængdeILiterInfo.opdaterIndhold("Vandmængde i liter: " + valgtVand.getMængde());
        });
        return råvarerTabContent;
    }

    public static void opdaterListview() {
        kornsorterObservable.setAll(Controller.getKornList());
        kornsorterListview.setItems(kornsorterObservable);

        vandtyperObservable.addAll(Controller.getVandTypeList());
        vandtyperListview.setItems(vandtyperObservable);
    }
}
