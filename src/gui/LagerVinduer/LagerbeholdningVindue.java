package gui.LagerVinduer;

import application.controller.Controller;
import application.model.Lager;
import application.model.Lagerplads;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import storage.Storage;

public class LagerbeholdningVindue extends Stage {
    private ListView<Lagerplads> lagerpladsListView = new ListView<>();
    private ObservableList<Lager> lagerLokationList = FXCollections.observableArrayList();
    private ComboBox lagerCombobox;

    public LagerbeholdningVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {

        pane.setPrefSize(800, 800);
        pane.setVgap(25);


        Label overskriftLabel = new Label("Lagerbeholdning");
        overskriftLabel.setFont(Font.font("Dialog", 20));
        overskriftLabel.setTextFill(Color.BLACK);

        HBox headerHbox = new HBox();
        headerHbox.setStyle("-fx-background-color: orange;" + "-fx-padding: 10; " + "-fx-border-color: black; " + "-fx-border-width: 3; " + "-fx-border-radius: 0; " + "-fx-background-radius: 0;");
        headerHbox.setAlignment(Pos.CENTER);

        HBox.setHgrow(headerHbox, Priority.ALWAYS);
        headerHbox.getChildren().addAll(overskriftLabel);
        GridPane.setHgrow(headerHbox, Priority.ALWAYS);


        pane.add(headerHbox, 0, 0);
        pane.add(lagerpladsListView, 0, 2);

        lagerLokationList.setAll(Controller.getLagerer());
        lagerCombobox = new ComboBox<>(lagerLokationList);
        pane.add(lagerCombobox, 0, 1);


    }
}
