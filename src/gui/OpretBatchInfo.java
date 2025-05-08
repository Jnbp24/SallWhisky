package gui;

import application.model.Batch;
import application.model.Fad;
import application.model.Information;
import application.model.Råvarer;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class OpretBatchInfo extends Stage {
    public OpretBatchInfo(String title) {
        this.setResizable(false);
        this.setTitle(title);


        TabPane tabPane = new TabPane();
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {




        TableView<Batch> batchTableView = new TableView<>();
        TableColumn<Batch, Integer> batchNummerKol = new TableColumn<>("Batch Nummer");
        batchNummerKol.setCellValueFactory(new PropertyValueFactory<>("BatchNummer"));

        TableColumn<Batch, String> batchNavnKol = new TableColumn<>("Batch Navn");
        batchNummerKol.setCellValueFactory(new PropertyValueFactory<>("BatchNavn"));


        TableView<Fad> fadTableView = new TableView<>();
        TableColumn<Fad, String> fadNummerKol = new TableColumn<>("Fad Nummer");
        fadNummerKol.setCellValueFactory(new PropertyValueFactory<>("fadnummer"));

        TableColumn<Fad, Integer> antalGangeBrugtKol = new TableColumn<>("Antal gange brugt");
        antalGangeBrugtKol.setCellValueFactory(new PropertyValueFactory<>("antalgangebrugt"));

        TableColumn<Fad, Double> fadStørrelseKol = new TableColumn<>("Fad Størrelse");
        fadStørrelseKol.setCellValueFactory(new PropertyValueFactory<>("fadstørrelse"));

        TableColumn<Fad, LocalDate> påfyldningsDatoKol = new TableColumn<>("Påfyldnings dato");
        påfyldningsDatoKol.setCellValueFactory(new PropertyValueFactory<>("påfyldningsdato"));

        TableColumn<Fad, String> newMakeKol = new TableColumn<>("New make nummer");
        newMakeKol.setCellValueFactory(new PropertyValueFactory<>("nmNummer"));

        TableColumn<Fad, Double> alkoholProcentKol = new TableColumn<>("Alkohol Procent");
        alkoholProcentKol.setCellValueFactory(new PropertyValueFactory<>("alkoholProcent"));

        TableColumn<Fad, Double> mængdeLiterKol = new TableColumn<>("Mængde i liter");
        mængdeLiterKol.setCellValueFactory(new PropertyValueFactory<>("mængdeLiter"));

        TableColumn<Fad, Råvarer> kornsortKol = new TableColumn<>("Kornsort");
        kornsortKol.setCellValueFactory(new PropertyValueFactory<>("kornsort"));


        batchTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        batchTableView.getColumns().addAll(batchNummerKol, batchNavnKol);
        batchTableView.setPrefWidth(250);
        GridPane.setHalignment(batchTableView,HPos.LEFT);



        fadTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        fadTableView.getColumns().addAll(fadNummerKol,antalGangeBrugtKol,fadStørrelseKol,påfyldningsDatoKol, newMakeKol,alkoholProcentKol, mængdeLiterKol, kornsortKol);
        fadTableView.setPrefWidth(500);
        GridPane.setHalignment(fadTableView,HPos.RIGHT);



        pane.add(batchTableView, 0, 0);
        pane.add(fadTableView,1,0);
        pane.setHgap(50);

    }
}