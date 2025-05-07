package gui;

import application.controller.Controller;
import application.model.Fad;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

}
