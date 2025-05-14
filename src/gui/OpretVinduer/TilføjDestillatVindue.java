package gui.OpretVinduer;

import application.controller.Controller;
import application.model.Destillat;
import application.model.Fad;
import application.model.Medarbejder;
import application.model.Påfyldning;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TilføjDestillatVindue extends Stage {
    private static ListView<Destillat> destillatListView = new ListView<>();
    private TextField resterendeMængdeTextfield = new TextField();
    private TextField mængdeFraDestillatTextfield = new TextField();
    private Fad fad;
    private Label resterendeMængdeLbl = new Label("Resterende liter");
    private Label fyldPåLbl = new Label("Fyld på");
    private ListView<Medarbejder> medarbejderListView = new ListView<>();

    private Påfyldning påfyldning;

    public TilføjDestillatVindue(String title, Fad fad) {
        this.setResizable(false);
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
        this.fad = fad;


    }

    private void initContent(GridPane pane) {
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(35));
        pane.setVgap(20);

        mængdeFraDestillatTextfield.setText("0");

        pane.add(new Label("Destillater"), 0, 0);
        pane.add(destillatListView, 0, 1);
        updaterList();
        destillatListView.setOnMouseClicked(event -> {
            resterendeMængdeTextfield.setText(String.valueOf((fad.getFadStørrelse() - fad.getMængdePåfyldt() - Integer.parseInt(mængdeFraDestillatTextfield.getText()))));
        });

        pane.add(new Label("Vælg medarbejder til påfyldning"), 2, 0);
        pane.add(medarbejderListView, 2, 1);
        medarbejderListView.getItems().setAll(Controller.getMedarbejdere());


        Button tilføjBtn = new Button("Tilføj");
        tilføjBtn.setOnMouseClicked(event -> {
            try {
                påfyldning = Controller.tilføjDestillat(fad, destillatListView.getSelectionModel().getSelectedItem(), Double.parseDouble(mængdeFraDestillatTextfield.getText()));
                mængdeFraDestillatTextfield.setText("0");
                updaterList();

            } catch (IllegalArgumentException e) {
                Alert fejlAlert = new Alert(Alert.AlertType.ERROR);
                fejlAlert.setTitle("Invalid information");
                fejlAlert.setHeaderText("Mængde overskrider resterende volume");
                fejlAlert.show();
            }
        });

        mængdeFraDestillatTextfield.setOnAction(event -> {
            if (destillatListView.getSelectionModel().getSelectedItem() != null){
                resterendeMængdeTextfield.setText(String.valueOf((fad.getFadStørrelse() - fad.getMængdePåfyldt() - Integer.parseInt(mængdeFraDestillatTextfield.getText()))));
            }
        });

        Button plusBtn = new Button("+");
        plusBtn.setOnMouseClicked(event ->{
            mængdeFraDestillatTextfield.setText(String.valueOf(Integer.parseInt(mængdeFraDestillatTextfield.getText()) + 1));
            if (destillatListView.getSelectionModel().getSelectedItem() != null){
                resterendeMængdeTextfield.setText(String.valueOf((fad.getFadStørrelse() - fad.getMængdePåfyldt() - Integer.parseInt(mængdeFraDestillatTextfield.getText()))));
            }
        });

        Button minusBtn = new Button("-");
        minusBtn.setOnMouseClicked(event -> {
            mængdeFraDestillatTextfield.setText(String.valueOf(Integer.parseInt(mængdeFraDestillatTextfield.getText()) - 1));
            if (destillatListView.getSelectionModel().getSelectedItem() != null){
                resterendeMængdeTextfield.setText(String.valueOf((fad.getFadStørrelse() - fad.getMængdePåfyldt() - Integer.parseInt(mængdeFraDestillatTextfield.getText()))));
            }
        });

        Button accepterBtn = new Button("Accepter");
        pane.add(accepterBtn, 0, 2);
        accepterBtn.setOnMouseClicked(event -> {
            Controller.færdiggørPåfyldning(påfyldning, medarbejderListView.getSelectionModel().getSelectedItem());
            this.close();
        });

        resterendeMængdeTextfield.setPrefWidth(5);
        mængdeFraDestillatTextfield.setPrefWidth(35);

        HBox hBox = new HBox(minusBtn, mængdeFraDestillatTextfield, plusBtn);
        hBox.setPadding(new Insets(35));
        VBox vBox = new VBox(resterendeMængdeLbl, resterendeMængdeTextfield, fyldPåLbl, hBox, tilføjBtn);
        vBox.setPadding(new Insets(35));
        pane.add(vBox, 1, 1);
    }

    public static void updaterList(){
        destillatListView.getItems().clear();
        destillatListView.getItems().setAll(Controller.getDestillater());
    }
}
