package gui.LagerVinduer;

import application.controller.Controller;
import application.model.FadIndhold.Fad;
import application.model.Lager.Lager;
import application.model.Lager.Lagerplads;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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
    private static ListView<Fad> fadListView = new ListView<>();

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
        pane.setHgap(25);
        pane.setPadding(new Insets(20));

        Label overskriftLabel = new Label("Lagerbeholdning");
        overskriftLabel.setFont(Font.font("Dialog", 20));
        overskriftLabel.setTextFill(Color.BLACK);

        HBox headerHbox = new HBox();
        headerHbox.setStyle("-fx-background-color: orange;" + "-fx-padding: 10; " + "-fx-border-color: black; " + "-fx-border-width: 3; " + "-fx-border-radius: 0; " + "-fx-background-radius: 0;");
        headerHbox.setAlignment(Pos.CENTER);

        HBox.setHgrow(headerHbox, Priority.ALWAYS);
        headerHbox.getChildren().addAll(overskriftLabel);
        GridPane.setHgrow(headerHbox, Priority.ALWAYS);


        pane.add(headerHbox, 0, 0, 3, 1);
        pane.add(lagerpladsListView, 0, 2);

        lagerLokationList.setAll(Controller.getLagerer());
        lagerCombobox = new ComboBox<>(lagerLokationList);
        lagerCombobox.setValue(lagerLokationList.getFirst());
        lagerCombobox.setOnAction(event -> opdaterLagerPladsList());
        pane.add(lagerCombobox, 0, 1);
        opdaterLagerPladsList();

        Label findFadPåFadNummerLabel = new Label("Søg efter fadnummer");
        Button findFadPåFadNummerBtn = new Button("Søg");
        findFadPåFadNummerBtn.setOnMouseClicked(event -> lagerpladsListView.getItems().setAll(Controller.findFadPåFadNummer(Integer.parseInt(findFadPåFadNummerTxtField.getText()))));

        Label findFadPåNmNummerLabel = new Label("Søg efter Newmake nummer");
        Button findFadPåNmNummerBtn = new Button("Søg");
        findFadPåNmNummerBtn.setOnMouseClicked(event -> lagerpladsListView.getItems().setAll(Controller.findFadPåNmNummer(findFadPåNmNummerTxtField.getText())));

        Label findTapklarLable = new Label("Find alle tapklar fade");
        Button findTapklarBtn = new Button("Find tapklar");
        findTapklarBtn.setOnMouseClicked(event -> lagerpladsListView.getItems().setAll(Controller.findTapklar()));

        pane.add(fadListView, 2, 2);
        opdaterFadList();

        Label tilføjFadLabel = new Label("Tilføj fad til lagerplads");
        Button tilføjFadBtn = new Button("Placer fad");
        tilføjFadBtn.setOnMouseClicked(event -> {
            if (lagerpladsListView.getSelectionModel().getSelectedItem() != null && fadListView.getSelectionModel().getSelectedItem() != null) {
                if (lagerpladsListView.getSelectionModel().getSelectedItem().getFad() == null) {
                    lagerpladsListView.getSelectionModel().getSelectedItem().placerFad(fadListView.getSelectionModel().getSelectedItem());
                    opdaterLagerPladsList();
                    opdaterFadList();
                }
                else {
                    Alert pladsOptagetAlert = new Alert(Alert.AlertType.ERROR);
                    pladsOptagetAlert.setTitle("FEJL");
                    pladsOptagetAlert.setHeaderText("Denne plads er optaget");
                    pladsOptagetAlert.setContentText("Vælg venlist en anden plads");
                    pladsOptagetAlert.show();
                }
            }
            else {
                Alert listAlert = new Alert(Alert.AlertType.ERROR);
                listAlert.setTitle("FEJL");
                listAlert.setHeaderText("Der skal vælges både en lagerplads, og et fad");
                listAlert.setContentText("Vælg venligst en fri plads fra listen, og et fad fra den anden liste");
                listAlert.show();
            }
        });

        Label fjernFadLabel = new Label("Fjern et fad fra lagerplads");
        Button fjernFadBtn = new Button("Fjern fad");
        fjernFadBtn.setOnMouseClicked(event -> {
            if (lagerpladsListView.getSelectionModel().getSelectedItem() != null) {
                if (lagerpladsListView.getSelectionModel().getSelectedItem().getFad() != null) {
                    lagerpladsListView.getSelectionModel().getSelectedItem().fjernFad();
                    opdaterLagerPladsList();
                    opdaterFadList();
                }
                else {
                    Alert ledigFejl = new Alert(Alert.AlertType.ERROR);
                    ledigFejl.setTitle("FEJL");
                    ledigFejl.setHeaderText("Denne plads er tom");
                    ledigFejl.setContentText("Vælg venligst en plads som indeholder et fad");
                    ledigFejl.show();
                }
            }
            else {
                Alert listAlert = new Alert(Alert.AlertType.ERROR);
                listAlert.setTitle("Fejl");
                listAlert.setHeaderText("Ingen plads valgt");
                listAlert.setContentText("Vælg venligst en plads");
                listAlert.show();
            }
        });

        HBox findFadPåFadNummerHbox = new HBox(findFadPåFadNummerTxtField, findFadPåFadNummerBtn);
        HBox findFadPåNmNummerHbox = new HBox(findFadPåNmNummerTxtField, findFadPåNmNummerBtn);

        VBox knapVbox = new VBox(findFadPåFadNummerLabel, findFadPåFadNummerHbox, findFadPåNmNummerLabel, findFadPåNmNummerHbox, findTapklarLable, findTapklarBtn, tilføjFadLabel, tilføjFadBtn, fjernFadLabel, fjernFadBtn);
        knapVbox.setSpacing(15);
        pane.add(knapVbox, 1, 2);


        Button resetBtn = new Button("Reset");
        resetBtn.setOnMouseClicked(event -> opdaterLagerPladsList());
        pane.add(resetBtn, 0,3);
    }

    public static void opdaterLagerPladsList() {
        if (lagerCombobox.getSelectionModel().getSelectedIndex() >= 0) {
            lagerpladsListView.getItems().setAll(lagerLokationList.get(lagerCombobox.getSelectionModel().getSelectedIndex()).getPladser());
        }
    }

    public static void opdaterFadList() {
        fadListView.getItems().clear();
        for (Fad fad : Controller.getFadList()) {
            if (!fad.isPåLager()) {
                fadListView.getItems().add(fad);
            }
        }
    }
}
