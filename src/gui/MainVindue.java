package gui;

import application.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainVindue extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sall Whisky");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    private void initContent(GridPane pane) {

        pane.setPrefWidth(400);
        pane.setPrefHeight(600);


        Label sallWhiskyHeaderLabel = new Label("Sall Whisky Distillery");
        sallWhiskyHeaderLabel.setAlignment(Pos.CENTER);
        pane.add(sallWhiskyHeaderLabel, 3, 0);


        Button opretFadBtn = new Button("Opret Fad");
        pane.add(opretFadBtn, 0, 2);
        opretFadBtn.setOnMouseClicked(event -> {

            OpretFadVindue fadVindue = new OpretFadVindue("Opret Fad");
            fadVindue.show();

            //Controller.opretFad();
        });
    }

}
