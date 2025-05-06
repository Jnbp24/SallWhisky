package gui;

import application.controller.Controller;
import application.model.Destillat;
import application.model.Fad;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TilføjDestillatVindue extends Stage {
private ListView<Destillat> destillatListView = new ListView<>();
private TextField påfyldtMængde = new TextField();
private TextField mængdeFraDestillat = new TextField();
private Fad fad;

    public TilføjDestillatVindue(String title, Fad fad) {

        this.setResizable(false);
        this.setTitle(title);

        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
        pane.add(new Label(String.valueOf(fad.getFadStørrelse())),0,2);
        this.fad = fad;
    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(500);
        pane.setPrefWidth(300);


        pane.add(new Label("Destillater"),0,0);
        pane.add(destillatListView, 0,1);
        destillatListView.getItems().setAll(Controller.getDestillater());


        pane.add(påfyldtMængde,1,0);
        pane.add(mængdeFraDestillat, 1,1);

        Button tilføjBtn = new Button("Tilføj");
        tilføjBtn.setOnMouseClicked(event -> {
            påfyldtMængde.setText(String.valueOf(Double.parseDouble(påfyldtMængde.getText()) + Controller.tilføjDestillat(fad, destillatListView.getSelectionModel().getSelectedItem(),Double.parseDouble(mængdeFraDestillat.getText()))));
        });

        Button plusBtn = new Button("+");
        plusBtn.setOnMouseClicked(event -> mængdeFraDestillat.setText(String.valueOf(Integer.parseInt(mængdeFraDestillat.getText()) + 1)));

        Button minusBtn = new Button("-");
        minusBtn.setOnMouseClicked(event -> mængdeFraDestillat.setText(String.valueOf(Integer.parseInt(mængdeFraDestillat.getText())- 1)));

    }
}
