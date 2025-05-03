package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefWidth(400);
        pane.setPrefHeight(600);

//        pane.setGridLinesVisible(true);


        //Finder resources folderen, derefter findes billeder folderen for så at finde png'en
        Image SallImage = new Image(getClass().getResourceAsStream("/billeder/SallLogo.png"));
        ImageView SallImageView = new ImageView(SallImage);
        SallImageView.setFitWidth(250);
        SallImageView.setFitHeight(250);
        SallImageView.setPreserveRatio(true);

        pane.add(SallImageView, 1, 1,2,2);

        Button opretFadBtn = new Button("Opret Fad");
        pane.add(opretFadBtn, 1,3,2,1);
        GridPane.setHalignment(opretFadBtn,HPos.CENTER);
        GridPane.setValignment(opretFadBtn,VPos.CENTER);

        opretFadBtn.setOnMouseClicked(event -> {

            OpretFadVindue fadVindue = new OpretFadVindue("Opret Fad");
            fadVindue.show();

        });


        Button opretDestillatBtn = new Button("Opret Destillat");
        pane.add(opretDestillatBtn,1,4,2,1);
        GridPane.setHalignment(opretDestillatBtn,HPos.CENTER);
        GridPane.setValignment(opretDestillatBtn,VPos.CENTER);

        opretDestillatBtn.setOnMouseClicked(event -> {
            OpretDestillatVindue destillatVindue = new OpretDestillatVindue("Opret Destillat");
            destillatVindue.show();
        });


        Button opretVandBtn = new Button("Opret Vand");
        pane.add(opretVandBtn,1,5,2,1);
        GridPane.setHalignment(opretVandBtn,HPos.CENTER);
        GridPane.setValignment(opretVandBtn,VPos.CENTER);

        opretVandBtn.setOnMouseClicked(event -> {
            OpretVandVindue vandVindue = new OpretVandVindue("Opret Råvare");
            vandVindue.show();;
        });


        Button opretKornBtn = new Button("Opret Korn");
        pane.add(opretKornBtn,1,6,2,1);
        GridPane.setHalignment(opretKornBtn,HPos.CENTER);
        GridPane.setValignment(opretKornBtn,VPos.CENTER);

        opretKornBtn.setOnMouseClicked(event -> {
            OpretKornVindue kornVindue = new OpretKornVindue("Opret Korn");
            kornVindue.show();
        });


    }

}
