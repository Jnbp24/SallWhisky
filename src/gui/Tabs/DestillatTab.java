package gui.Tabs;

import application.controller.Controller;
import application.model.Destillat;
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
    private ListView<Destillat> destillatListView = new ListView<>();
    private ObservableList destillatObservable = FXCollections.observableArrayList();

    public GridPane initContent() {
        //Load dummy-data
        MainVindue.initStorage();


        VBox destillatbox = new VBox(15);
        GridPane destillatTabContent = new GridPane();
        destillatTabContent.setAlignment(Pos.CENTER);
        destillatTabContent.setVgap(10);

        Label destillatListeLabel = new Label("Liste af oprettede destillater");
        Label visHistorikLabel = new Label("Tryk på et destillat for at se indholdet");

        VBox labelBox = new VBox(3.5);
        labelBox.getChildren().addAll(destillatListeLabel,visHistorikLabel);
        labelBox.setStyle("-fx-border-color: grey; " + "-fx-border-width: 2;" + "-fx-padding: 10;");


        destillatbox.getChildren().addAll(Knapper.OpretDestillatButton(), labelBox, destillatListView);

        destillatObservable.setAll(Controller.getDestillater());
        destillatListView.setItems(destillatObservable);

        destillatTabContent.add(destillatbox, 0, 0);

        return destillatTabContent;
    }
}
