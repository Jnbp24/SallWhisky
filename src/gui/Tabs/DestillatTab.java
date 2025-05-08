package gui.Tabs;

import application.controller.Controller;
import application.model.Destillat;
import gui.Knapper;
import gui.mainVindue.MainVindue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import storage.Storage;

public class DestillatTab {
    private ListView<Destillat> destillatListView = new ListView<>();
    private ObservableList destillatObservable = FXCollections.observableArrayList();
    public GridPane initContent() {
        //Load dummy-data
        MainVindue.initStorage();
        VBox destillatbox = new VBox(15);
        GridPane destillatTabContent = new GridPane();
        destillatTabContent.setAlignment(Pos.CENTER);
        destillatTabContent.setVgap(15);

        destillatbox.getChildren().addAll(Knapper.OpretDestillatButton(), destillatListView);

        destillatObservable.setAll(Controller.getDestillater());
        destillatListView.setItems(destillatObservable);

        destillatTabContent.add(destillatbox,0,0);

        return destillatTabContent;
    }
}
