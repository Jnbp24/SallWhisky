package gui.Elements;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InfoBox extends VBox {
    private Label titelLabel;

    public InfoBox(String titel) {
        super(5);
        this.setStyle("-fx-border-color: grey; -fx-border-width: 2; -fx-padding: 10;");

        this.titelLabel = new Label(titel);
        this.getChildren().add(titelLabel);
    }

    public void opdaterIndhold(String nyTitel) {
        if(this.titelLabel != null)
        titelLabel.setText(nyTitel);
    }

    public Label getTitelLabel() {
        return titelLabel;
    }
}
