package gui;

import application.controller.Controller;
import application.model.Fad;
import application.model.Kornsort;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainVindue extends Application {
    private static ListView<Fad> fadListView = new ListView<>();

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
//        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefWidth(1260);
        pane.setPrefHeight(800);
        pane.setHgap(75);
        pane.setVgap(35);

//        pane.setGridLinesVisible(true);


        //Finder resources folderen, derefter findes billeder folderen for så at finde png'en
        Image SallImage = new Image(getClass().getResourceAsStream("/billeder/SallLogo.png"));
        ImageView SallImageView = new ImageView(SallImage);
        SallImageView.setFitWidth(250);
        SallImageView.setFitHeight(250);
        SallImageView.setPreserveRatio(true);

        pane.add(SallImageView, 1, 1, 2, 2);

        Button opretFadBtn = new Button("Opret Fad");
        pane.add(opretFadBtn, 1, 3);
//        GridPane.setHalignment(opretFadBtn, HPos.CENTER);
//        GridPane.setValignment(opretFadBtn, VPos.CENTER);

        opretFadBtn.setOnMouseClicked(event -> {

            OpretFadVindue fadVindue = new OpretFadVindue("Opret Fad");
            fadVindue.show();

        });


        Button opretDestillatBtn = new Button("Opret Destillat");
        pane.add(opretDestillatBtn, 1, 4);
//        GridPane.setHalignment(opretDestillatBtn, HPos.CENTER);
//        GridPane.setValignment(opretDestillatBtn, VPos.CENTER);

        opretDestillatBtn.setOnMouseClicked(event -> {
            OpretDestillatVindue destillatVindue = new OpretDestillatVindue("Opret Destillat");
            destillatVindue.show();
        });


        Button opretVandBtn = new Button("Opret Vand");
        pane.add(opretVandBtn, 1, 5);
//        GridPane.setHalignment(opretVandBtn, HPos.CENTER);
//        GridPane.setValignment(opretVandBtn, VPos.CENTER);

        opretVandBtn.setOnMouseClicked(event -> {
            OpretVandVindue vandVindue = new OpretVandVindue("Opret Råvare");
            vandVindue.show();
            ;
        });


        Button opretKornBtn = new Button("Opret Korn");
        pane.add(opretKornBtn, 2, 5);

        Button opretBatchBtn = new Button("Opret batch");
        pane.add(opretBatchBtn,2,3);
        opretBatchBtn.setOnMouseClicked(event -> {
            OpretBatchVindue batchVindue= new OpretBatchVindue("Opret Batch");
            batchVindue.show();
        });



        opretKornBtn.setOnMouseClicked(event -> {
            OpretKornVindue kornVindue = new OpretKornVindue("Opret Korn");
            kornVindue.show();
        });

        pane.add(fadListView, 0, 8);
//        GridPane.setHalignment(fadListView, HPos.LEFT);
        updateFadList();

        Button tilføjDestillatBtn = new Button("Tilføj Destillat");
        pane.add(tilføjDestillatBtn, 1, 7);

        tilføjDestillatBtn.setOnMouseClicked(event -> {
            TilføjDestillatVindue tilføjDestillatVindue = new TilføjDestillatVindue("Tilføj Destillat", fadListView.getSelectionModel().getSelectedItem());
            tilføjDestillatVindue.show();
        });

    }

    public static void updateFadList() {
        fadListView.getItems().setAll(Controller.getFadList());
    }

}
