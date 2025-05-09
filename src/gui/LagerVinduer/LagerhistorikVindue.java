package gui.LagerVinduer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LagerhistorikVindue extends Stage {

    public LagerhistorikVindue(String title) {

        this.setResizable(false);
        this.setTitle(title);


        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane){
        Label overskriftLabel = new Label("Lagerhistorik");
        overskriftLabel.setFont(Font.font("Dialog", 35));
        overskriftLabel.setTextFill(Color.BLACK);

        HBox headerHbox = new HBox();
        headerHbox.setStyle("-fx-background-color: orange;" + "-fx-padding: 10; " + "-fx-border-color: black; " + "-fx-border-width: 3; " + "-fx-border-radius: 0; " + "-fx-background-radius: 0;");
        headerHbox.setAlignment(Pos.CENTER);

    }
}
