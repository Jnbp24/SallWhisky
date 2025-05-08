package gui.mainVindue;

import application.model.*;
import gui.elements.Billeder;
import gui.elements.Knapper;
import gui.Tabs.BatchTab;
import gui.Tabs.DestillatTab;
import gui.Tabs.FadTab;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import storage.Storage;

public class MainVindue extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sall Whisky");
        GridPane pane = new GridPane();
        pane.setPrefSize(600, 600);


        this.initContent(pane);
        this.initStorage();


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
        mainTabContent.setVgap(20);
        mainTabContent.setHgap(20);

        Label overskriftLabel = new Label("Lager styrings system");
        overskriftLabel.setFont(Font.font("Dialog", 35));
        overskriftLabel.setTextFill(Color.BLACK);

        HBox headerHbox = new HBox();
        headerHbox.setStyle("-fx-background-color: orange;" + "-fx-padding: 10; " + "-fx-border-color: black; " + "-fx-border-width: 3; " + "-fx-border-radius: 0; " + "-fx-background-radius: 0;");
        headerHbox.setAlignment(Pos.CENTER);

        ImageView headerBillede = new Billeder().opretBillede("/billeder/SallLogo.png", 150, 150);
        HBox venstreOverskriftBox = new HBox(headerBillede);
        venstreOverskriftBox.setAlignment(Pos.CENTER_LEFT);

        HBox centerOverskriftBox = new HBox(overskriftLabel);
        centerOverskriftBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(centerOverskriftBox, Priority.ALWAYS);

        headerHbox.getChildren().addAll(venstreOverskriftBox, centerOverskriftBox);
        GridPane.setHgrow(headerHbox, Priority.ALWAYS);
        headerHbox.setMaxWidth(Double.MAX_VALUE);
        mainTabContent.add(headerHbox, 0, 1);

        //        VBox forsideBilleder = new VBox();
        //        ImageView glødBillede = new Billeder().opretBillede("/billeder/GlødWhisky.png",150,150);
        //
        //        forsideBilleder.getChildren().addAll(glødBillede);
        //        mainTabContent.add(forsideBilleder,0,2);

        Label lagerbeholdningsLabel = new Label("Her kan du se den nuværende lagerbeholdning");
        Label lagerhistorikLabel = new Label("Her kan du se en historik over hvad der tidligere har været på lager");


        VBox lagerbeholdningBox = new VBox();
        lagerbeholdningBox.getChildren().addAll(Knapper.OpretLagerbeholdningButton(), lagerbeholdningsLabel);
        lagerbeholdningBox.setAlignment(Pos.CENTER);
        lagerbeholdningBox.setSpacing(10);

        VBox lagerhistorikBox = new VBox();
        lagerhistorikBox.getChildren().addAll(Knapper.OpretLagerHistorikButton(), lagerhistorikLabel);
        lagerhistorikBox.setAlignment(Pos.CENTER);
        lagerhistorikBox.setSpacing(10);

        VBox forsideKnapper = new VBox();
        forsideKnapper.getChildren().addAll(lagerbeholdningBox, lagerhistorikBox);
        forsideKnapper.setAlignment(Pos.CENTER);
        forsideKnapper.setSpacing(45);
        mainTabContent.add(forsideKnapper, 0, 2);

        return mainTabContent;
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

