package gui.Tabs;

import application.controller.Controller;
import application.model.Råvarer;
import gui.elements.InfoBox;
import gui.elements.Knapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

        kornBox.getChildren().addAll(Knapper.OpretKornButton(), kornInfoBox, kornsorterListview);

        VBox vandBox = new VBox(7.5);

        InfoBox vandtyperBox = new InfoBox("Her kan du se en liste af oprettede vandtyper");
        vandtyperObservable.addAll(Controller.getVandTypeList());
        vandtyperListview.setItems(vandtyperObservable);
        vandBox.getChildren().addAll(Knapper.OpretVandButton(), vandtyperBox, vandtyperListview);

        råvarerTabContent.add(kornBox, 0, 0);
        råvarerTabContent.add(vandBox, 1, 0);

        return råvarerTabContent;
    }

    public static void opdaterListview(){
        kornsorterObservable.setAll(Controller.getKornList());
        kornsorterListview.setItems(kornsorterObservable);

        vandtyperObservable.addAll(Controller.getVandTypeList());
        vandtyperListview.setItems(vandtyperObservable);
    }
}
