package gui.Tabs;

import application.controller.Controller;
import application.model.Batch;
import application.model.Fad;
import gui.Knapper;
import gui.mainVindue.MainVindue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import storage.Storage;

public class FadTab {
    private static ListView<Fad> fadListView = new ListView<>();
    private ObservableList fadObservable = FXCollections.observableArrayList();

    public GridPane initContent() {
        //Load dummy-data
        MainVindue.initStorage();

        GridPane fadTabContent = new GridPane();
        fadTabContent.setAlignment(Pos.CENTER);
        fadTabContent.setVgap(15);
        HBox Knapbox = new HBox(100);
        Knapbox.getChildren().addAll(Knapper.OpretFadButton(), Knapper.TilføjDestillatButton(fadListView));




        fadTabContent.add(Knapbox, 0, 0);
        fadTabContent.add(fadListView, 0, 1);
        fadListView.setItems(fadObservable);
        updateFadList();

        return fadTabContent;
    }

    public void updateFadList() {
        fadObservable.setAll(Controller.getFadList());
    }
}
