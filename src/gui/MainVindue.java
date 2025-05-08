package gui;

import application.controller.Controller;
import application.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

import java.util.ArrayList;

public class MainVindue extends Application {
    private static ListView<Fad> fadListView = new ListView<>();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sall Whisky");
        GridPane pane = new GridPane();
        this.initContent(pane);
        this.initStorage();
        updateFadList();


        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    private void initContent(GridPane pane) {
        //        pane.setAlignment(Pos.TOP_CENTER);
        GridPane mainTabContent = new GridPane();
        mainTabContent.setPrefWidth(1260);
        mainTabContent.setPrefHeight(800);
        mainTabContent.setHgap(75);
        mainTabContent.setVgap(35);
        //        pane.setGridLinesVisible(true);

        TabPane tabPane = new TabPane();

        Tab mainTab = new Tab("Hovedmenu");
        mainTab.setClosable(false);
        mainTabContent.setPrefWidth(1260);
        mainTabContent.setPrefHeight(800);
        mainTabContent.setHgap(75);
        mainTabContent.setVgap(35);


        mainTabContent.add(tabPane, 0, 0, 3, 1);


        //Finder resources folderen, derefter findes billeder folderen for så at finde png'en
        Image SallImage = new Image(getClass().getResourceAsStream("/billeder/SallLogo.png"));
        ImageView SallImageView = new ImageView(SallImage);
        SallImageView.setFitWidth(250);
        SallImageView.setFitHeight(250);
        SallImageView.setPreserveRatio(true);
        mainTabContent.add(SallImageView, 1, 1, 2, 2);


        Button opretFadBtn = new Button("Opret Fad");
        mainTabContent.add(opretFadBtn, 1, 3);

        opretFadBtn.setOnMouseClicked(event -> {

            OpretFadVindue fadVindue = new OpretFadVindue("Opret Fad");
            fadVindue.show();

        });


        Button opretDestillatBtn = new Button("Opret Destillat");
        mainTabContent.add(opretDestillatBtn, 1, 4);

        opretDestillatBtn.setOnMouseClicked(event -> {
            OpretDestillatVindue destillatVindue = new OpretDestillatVindue("Opret Destillat");
            destillatVindue.show();
        });


        Button opretVandBtn = new Button("Opret Vand");
        mainTabContent.add(opretVandBtn, 1, 5);

        opretVandBtn.setOnMouseClicked(event -> {
            OpretVandVindue vandVindue = new OpretVandVindue("Opret Råvare");
            vandVindue.show();
            ;
        });


        Button opretKornBtn = new Button("Opret Korn");
        mainTabContent.add(opretKornBtn, 2, 5);

        Button opretBatchBtn = new Button("Opret batch");
        mainTabContent.add(opretBatchBtn, 2, 3);
        opretBatchBtn.setOnMouseClicked(event -> {
            OpretBatchVindue batchVindue = new OpretBatchVindue("Opret Batch");
            batchVindue.show();
        });


        opretKornBtn.setOnMouseClicked(event -> {
            OpretKornVindue kornVindue = new OpretKornVindue("Opret Korn");
            kornVindue.show();
        });

        mainTabContent.add(fadListView, 0, 8);
        updateFadList();

        Button tilføjDestillatBtn = new Button("Tilføj Destillat");
        mainTabContent.add(tilføjDestillatBtn, 1, 7);

        tilføjDestillatBtn.setOnMouseClicked(event -> {
            TilføjDestillatVindue tilføjDestillatVindue = new TilføjDestillatVindue("Tilføj Destillat", fadListView.getSelectionModel().getSelectedItem());
            tilføjDestillatVindue.show();
        });

        mainTab.setContent(mainTabContent);
        tabPane.getTabs().add(mainTab);

        OpretBatchInfo batchInfoTab = new OpretBatchInfo("Batch og Fad historik");
        Tab batchTab = new Tab("Batch info", batchInfoTab.getScene().getRoot());
        batchTab.setClosable(false);
        tabPane.getTabs().add(batchTab);
        pane.add(tabPane, 0, 0, 3, 1);


    }

    public static void updateFadList() {
        fadListView.getItems().setAll(Controller.getFadList());
    }

    private void initStorage() {

        Fad fad1 = new Fad(1, "Eg", 200.0, 0);
        Fad fad2 = new Fad(2, "Sherry", 300.0, 3);
        Fad fad3 = new Fad(3, "Bourbon", 200.0, 1);
        Fad fad4 = new Fad(4, "Ex-Bourbon", 135.0, 2);
        Fad fad5 = new Fad(5, "Eg", 150.0, 2);


        Storage.tilføjFad(fad1);
        Storage.tilføjFad(fad2);
        Storage.tilføjFad(fad3);
        Storage.tilføjFad(fad4);
        Storage.tilføjFad(fad5);

        Vand vand1 = new Vand("Glacier", "Grønland", 50.0);
        Vand vand2 = new Vand("Kildevand", "Sall underjordisk dal", 50);

        Kornsort kornsort1 = new Kornsort("Byg", "Mark1", 50, Ristethed.IKKE_RISTET);
        Kornsort kornsort2 = new Kornsort("Rug", "Mark2", 20, Ristethed.SVÆRT_RISTET);
        Kornsort kornsort3 = new Kornsort("Hvede", "Mark3", 100, Ristethed.LET_RISTET);

        Storage.tilføjKornsort(kornsort1);
        Storage.tilføjKornsort(kornsort2);
        Storage.tilføjKornsort(kornsort3);

        Storage.tilføjVand(vand1);
        Storage.tilføjVand(vand2);

        Destillat destillat1 = new Destillat("NM1", 65.0, kornsort1, vand1, true);
        Destillat destillat2 = new Destillat("NM2", 54.0, kornsort3, vand2, false);
        Destillat destillat3 = new Destillat("NM3", 62.0, kornsort3, vand2, false);

        Storage.tilføjDestillat(destillat1);
        Storage.tilføjDestillat(destillat2);
        Storage.tilføjDestillat(destillat3);

        Påfyldning påfyldning1 = new Påfyldning(fad1);
        påfyldning1.tilføjDestillat(destillat1, 50.0);
        påfyldning1.tilføjDestillat(destillat2, 30.0);

        //Pas på at der ikke fyldes mere destillat på end der er tilgængeligt
        Påfyldning påfyldning2 = new Påfyldning(fad2);
        påfyldning2.tilføjDestillat(destillat3, 35);



        påfyldning1.færdiggørPåfyldning();
        påfyldning2.færdiggørPåfyldning();

    }
}

