package gui.Tabs;

import application.model.Batch;
import gui.Knapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
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
        batchTabContent.setHgap(75);
        batchTabContent.setVgap(15);

        batchBox.getChildren().addAll(Knapper.OpretBatchButton(), batchListView);

        batchObservable.setAll(Storage.getBatches());
        batchListView.setItems(batchObservable);


        batchTabContent.add(batchBox, 0, 0);

        return batchTabContent;
    }


}
