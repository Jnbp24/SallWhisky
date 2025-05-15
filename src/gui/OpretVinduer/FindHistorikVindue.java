package gui.OpretVinduer;

import application.model.*;
import gui.Elements.InfoBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPrefHeight(650);
        pane.setPrefWidth(600);


        StringBuilder historikStringbuilder = new StringBuilder("\nFad: " + batch.getFadtype() + "\nDestillat(er): " + batch.getTapning().getFad().getDestillater() + "\n" + "Kornsorter: \n");
        for (Kornsort kornsort : batch.getKornsorter()) {
            historikStringbuilder.append("\n" + "Kornsort: " + "\n" + kornsort.getNavn() + "\n" + "Ristethed: " + "\n" + kornsort.getRistethed() + "\n" + "Kornmark: " + "\n" + kornsort.getLokation() + "\n");
        }
        for (Destillat destillat : batch.getTapning().getFad().getDestillater()) {
            historikStringbuilder.append(destillat.getVand().getNavn() + "\n" + "Vand: " + "\n" +  destillat.getVand().getLokation() + "\n" +  "Vand lokation: " + "\n");
        }


        InfoBox historikInfoBox = new InfoBox(batch.getBatchNavn() + "'s historik: " + historikStringbuilder);
        pane.add(historikInfoBox, 0, 0);


        VBox historikBox = new VBox(7.5);
        Label historikLabel = new Label(batch.getBatchNavn() + "'s historik: ");


    }


}
