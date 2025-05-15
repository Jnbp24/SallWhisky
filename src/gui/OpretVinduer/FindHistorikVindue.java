package gui.OpretVinduer;

import application.model.*;
import gui.Elements.InfoBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
        pane.setAlignment(Pos.CENTER);
        pane.setPrefHeight(650);
        pane.setPrefWidth(600);


        StringBuilder historikStringbuilder = new StringBuilder("\nFad: " + batch.getFadtype() + "\n" +
                "Destillat(er): ");

        for (Destillat destillat : batch.getTapning().getFad().getDestillater()) {
            historikStringbuilder.append("\n" +
                    "NM nummer: " + destillat.getNmNummer() + "\n" +
                    "ABV: " + destillat.getAlkoholProcent() + "\n" +
                    "Tørv: " + destillat.getTørv());
        }
        for (Kornsort kornsort : batch.getKornsorter()) {
            historikStringbuilder.append("\n" +
                    "Kornsort: " + "\n" + kornsort.getNavn() + " - " + kornsort.getRistethed().toString() + "\n" +
                    "Kornmark: " + "\n" + kornsort.getLokation() + "\n");
        }
        for (Destillat destillat : batch.getTapning().getFad().getDestillater()) {
            historikStringbuilder.append(destillat.getVand().getNavn() + "\n" +
                    "Vand: " + "\n" + destillat.getVand().getLokation() + "\n" +
                    "Vand lokation: " + "\n");

        }

        for (Flaske flaske : batch.getFlasker()) {
            historikStringbuilder.append("\n" + "Antal flasker: " + batch.getFlasker());
        }

        InfoBox historikInfoBox = new InfoBox("" + historikStringbuilder);
        historikInfoBox.setPrefSize(550, 550);
        pane.add(historikInfoBox, 0, 1);

        Label historikLabel = new Label(batch.getBatchNavn() + "'s historik: ");
        historikLabel.setAlignment(Pos.CENTER);
        historikLabel.setStyle("-fx-font-weight: bold");
        pane.add(historikLabel, 0, 0);


    }


}
