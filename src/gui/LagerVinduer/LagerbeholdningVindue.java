package gui.LagerVinduer;

import application.controller.Controller;
import application.model.Lager;
import application.model.Lagerplads;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LagerbeholdningVindue extends Stage {
    private static ListView<Lagerplads> lagerpladsListView = new ListView<>();
    private static ObservableList<Lager> lagerLokationList = FXCollections.observableArrayList();
    private static ComboBox lagerCombobox;
    private TextField findFadPåFadNummerTxtField = new TextField();
    private TextField findFadPåNmNummerTxtField = new TextField();

    public LagerbeholdningVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane){

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
        lagerCombobox.setOnAction(event -> updaterLagerPladsList());
        pane.add(lagerCombobox, 0,1);

        Label findFadPåFadNummerLabel = new Label("Søg efter fadnummer");
        Button findFadPåFadNummerBtn = new Button("Søg");
        findFadPåFadNummerBtn.setOnMouseClicked(event -> lagerpladsListView.getItems().setAll(Controller.findFadPåFadNummer(Integer.parseInt(findFadPåFadNummerTxtField.getText()))));

        Label findFadPåNmNummerLabel = new Label("Søg efter Newmake nummer");
        Button findFadPåNmNummerBtn = new Button("Søg");
        findFadPåNmNummerBtn.setOnMouseClicked(event -> lagerpladsListView.getItems().setAll(Controller.findFadPåNmNummer(findFadPåNmNummerTxtField.getText())));

        HBox findFadPåFadNummerHbox = new HBox(findFadPåFadNummerTxtField, findFadPåFadNummerBtn);
        HBox findFadPåNmNummerHbox = new HBox(findFadPåNmNummerTxtField, findFadPåFadNummerBtn);

        VBox findFadVbox = new VBox(findFadPåFadNummerLabel, findFadPåFadNummerHbox, findFadPåNmNummerLabel ,findFadPåNmNummerHbox);

        pane.add(findFadVbox, 1,2);
    }

    public static void updaterLagerPladsList(){
        lagerpladsListView.getItems().setAll(lagerLokationList.get(lagerCombobox.getSelectionModel().getSelectedIndex()).getPladser());
    }
}
