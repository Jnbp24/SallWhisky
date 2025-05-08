package gui.mainVindue;

import application.controller.Controller;
import application.model.*;
import gui.Knapper;
import gui.Tabs.BatchTab;
import gui.Tabs.DestillatTab;
import gui.Tabs.FadTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

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
        TabPane tabPane = new TabPane();

        Tab mainTab = new Tab("Hovedmenu");
        Tab fadtab = new Tab("Fad");
        Tab batchTab = new Tab("Batch");
        Tab destillatTab = new Tab("Destillat");

        mainTab.setClosable(false);
        fadtab.setClosable(false);
        fadtab.setClosable(false);
        batchTab.setClosable(false);
        destillatTab.setClosable(false);

        mainTab.setContent(mainTabContent());
        fadtab.setContent(new FadTab().initContent());
        batchTab.setContent(new BatchTab().initContent());
        destillatTab.setContent(new DestillatTab().initContent());

        tabPane.getTabs().addAll(mainTab, fadtab, batchTab, destillatTab);
        pane.add(tabPane, 0, 0);

    }


    private GridPane mainTabContent() {

        GridPane mainTabContent = new GridPane();
        mainTabContent.setPrefWidth(1260);
        mainTabContent.setPrefHeight(800);
        mainTabContent.setHgap(75);
        mainTabContent.setVgap(35);


        Image SallImage = new Image(getClass().getResourceAsStream("/billeder/SallLogo.png"));
        ImageView SallImageView = new ImageView(SallImage);
        SallImageView.setFitWidth(250);
        SallImageView.setFitHeight(250);
        SallImageView.setPreserveRatio(true);
        mainTabContent.add(SallImageView, 1, 1, 2, 2);


        mainTabContent.add(Knapper.OpretFadButton(), 1, 3);
        mainTabContent.add(Knapper.OpretDestillatButton(), 1, 4);
        mainTabContent.add(Knapper.OpretVandButton(), 1, 5);
        mainTabContent.add(Knapper.OpretKornButton(), 2, 5);
        mainTabContent.add(Knapper.OpretBatchButton(), 2, 3);
        mainTabContent.add(Knapper.TilføjDestillatButton(fadListView), 1, 7);


        mainTabContent.add(fadListView, 0, 4);
        updateFadList();

        return mainTabContent;
    }

    public static void updateFadList() {
        fadListView.getItems().setAll(Controller.getFadList());
    }

    public static void initStorage() {

        Fad fad1 = new Fad(1, "Eg", 200.0, 0);
        Fad fad2 = new Fad(2, "Sherry", 300.0, 3);
        Fad fad3 = new Fad(3, "Bourbon", 200.0, 1);
        Fad fad4 = new Fad(4, "Ex-Bourbon", 135.0, 2);
        Fad fad5 = new Fad(5, "Eg", 150.0, 2);

        Medarbejder medarbejder1 = new Medarbejder(1, "Snaever");
        Medarbejder medarbejder2 = new Medarbejder(2, "Lars");
        Medarbejder medarbejder3 = new Medarbejder(3, "Hans");


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


        påfyldning1.færdiggørPåfyldning(medarbejder1);
        påfyldning2.færdiggørPåfyldning(medarbejder2);


    }


}

