package gui.OpretVinduer;

import application.model.BatchIndhold.Batch;
import application.model.FadIndhold.Destillat;
import application.model.Raavarer.Kornsort;
import gui.Elements.Billeder;
import gui.Elements.InfoBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
        pane.setPrefHeight(900);
        pane.setPrefWidth(400);


        StringBuilder historikStringbuilder = new StringBuilder("\nFadtype(er): " + batch.getFadtyper() + "\n\n________________________________________________________________\n" +
                "Destillat(er): ");

        for (Destillat destillat : batch.getTapning().getFad().getDestillater()) {
            historikStringbuilder.append("\n\n" +
                    "NM nummer: " + destillat.getNmNummer() + "\n" +
                    "ABV: " + destillat.getAlkoholProcent() + "\n" +
                    "Tørv: " + destillat.getTørv());
        }

        historikStringbuilder.append("\n________________________________________________________________\n");
        historikStringbuilder.append("Kornsorter:\n");

        for (Kornsort kornsort : batch.getKornsorter()) {
            if (!historikStringbuilder.toString().contains(kornsort.getNavn()) && !historikStringbuilder.toString().contains(kornsort.getRistethed().getDisplay()) && !historikStringbuilder.toString().contains(kornsort.getLokation())){
                historikStringbuilder.append("\n" +
                        kornsort.getNavn() + " - " + kornsort.getRistethed().getDisplay() + "\n" +
                        "Kornmark: " + kornsort.getLokation() + "\n");
            }
        }

        historikStringbuilder.append("\n________________________________________________________________\n");

        historikStringbuilder.append("Vand: \n\n");

        for (Destillat destillat : batch.getTapning().getFad().getDestillater()) {
            if (!historikStringbuilder.toString().contains(destillat.getVand().getNavn()) && !historikStringbuilder.toString().contains(destillat.getVand().getLokation())) {
                historikStringbuilder.append(destillat.getVand().getNavn() + "\n" + destillat.getVand().getLokation() + "\n" + "Vand lokation: " + "\n");
            }

        }

        historikStringbuilder.append("\n________________________________________________________________\n");

        historikStringbuilder.append("\nAntal flasker: " + batch.getFlasker().size() + "\nFlaskestørrelse: " + batch.getFlasker().getFirst().getFlaskeStørrelseILiter()).append("\nType: ").append(batch.getWhiskyType().getDisplay());

        InfoBox historikInfoBox = new InfoBox("" + historikStringbuilder);

        if (batch.harFåetKvalitetsStempel()){
            Image kvalitetsStempel = new Image("billeder/kvalitetsstempel.png");
            ImageView imageView = new ImageView(kvalitetsStempel);
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);

            historikInfoBox.getTitelLabel().setGraphic(imageView);
            historikInfoBox.getTitelLabel().setContentDisplay(ContentDisplay.BOTTOM);
        }

        historikInfoBox.setPrefSize(380, 800);
        pane.add(historikInfoBox, 0, 1);

        Label historikLabel = new Label(batch.getBatchNavn() + "'s historik: ");
        historikLabel.setAlignment(Pos.CENTER);
        historikLabel.setStyle("-fx-font-weight: bold");
        pane.add(historikLabel, 0, 0);


    }


}
