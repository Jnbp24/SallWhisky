package gui.OpretVinduer;

import application.controller.Controller;
import application.model.*;
import gui.Tabs.BatchTab;
import gui.elements.InfoBox;
import gui.elements.Knapper;
import gui.mainVindue.MainVindue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.L;

public class FindHistorikVindue extends Stage {
    private Batch batch;

    public FindHistorikVindue(String title, Batch batch) {
        this.batch = batch;
        this.setResizable(false);
        this.setTitle(title);

        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(650);
        pane.setPrefWidth(600);


        StringBuilder historikStringbuilder = new StringBuilder("\nFad: " + batch.getFadtype() + "\nDestillat(er): " + batch.getTapning().getFad().getDestillater() + "\n");
        for (Kornsort kornsort : batch.getKornsorter()) {
            historikStringbuilder.append(kornsort.getNavn() + "Ristethed: " + kornsort.getRistethed());
        }
                InfoBox historikInfoBox = new InfoBox(batch.getBatchNavn() + "'s historik: ");
                ;

//        Fad fad = batch.getFadtype();
//        Destillat destillat = fad.getDestillater().add(batch.);


        VBox historikBox = new VBox(7.5);
        Label historikLabel = new Label(batch.getBatchNavn() + "'s historik: ");
//        InfoBox historikFad = new InfoBox("Fad: " + batch.getFadtype());
////        InfoBox historikDestillat = new InfoBox("Destillat: " + batch.getFadtype());
//        InfoBox historikKorn = new InfoBox("Kornsorter: " + batch.getKornsorter());
//        InfoBox historikRistethed = new InfoBox("Ristethed: " + kornsort.getRistethed());




    }


}
