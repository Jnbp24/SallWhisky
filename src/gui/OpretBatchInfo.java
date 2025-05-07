package gui;

import application.model.Batch;
import application.model.Fad;
import application.model.Information;
import application.model.Råvarer;
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

        TableView<Information> batchTableView = new TableView<>();
        TableColumn<Information, Integer> batchNummerKol = new TableColumn<>("Batch Nummer");
        batchNummerKol.setCellValueFactory(new PropertyValueFactory<>("BatchNummer"));

        TableColumn<Information, String> batchNavnKol = new TableColumn<>("Batch Navn");
        batchNummerKol.setCellValueFactory(new PropertyValueFactory<>("BatchNavn"));

        TableColumn<Information, String> fadNummerKol = new TableColumn<>("Fad Nummer");
        fadNummerKol.setCellValueFactory(new PropertyValueFactory<>("fadnummer"));

        TableColumn<Information, Integer> antalGangeBrugtKol = new TableColumn<>("Antal gange brugt");
        antalGangeBrugtKol.setCellValueFactory(new PropertyValueFactory<>("antalgangebrugt"));

        TableColumn<Information, Double> fadStørrelseKol = new TableColumn<>("Fad Størrelse");
        fadStørrelseKol.setCellValueFactory(new PropertyValueFactory<>("fadstørrelse"));

        TableColumn<Information, LocalDate> påfyldningsDatoKol = new TableColumn<>("Påfyldnings dato");
        påfyldningsDatoKol.setCellValueFactory(new PropertyValueFactory<>("påfyldningsdato"));

        TableColumn<Information, String> newMakeKol = new TableColumn<>("New make nummer");
        newMakeKol.setCellValueFactory(new PropertyValueFactory<>("nmNummer"));

        TableColumn<Information, Double> alkoholProcentKol = new TableColumn<>("Alkohol Procent");
        alkoholProcentKol.setCellValueFactory(new PropertyValueFactory<>("alkoholProcent"));

        TableColumn<Information, Double> mængdeLiterKol = new TableColumn<>("Mængde i liter");
        mængdeLiterKol.setCellValueFactory(new PropertyValueFactory<>("mængdeLiter"));

        TableColumn<Information, Råvarer> kornsortKol = new TableColumn<>("Kornsort");
        kornsortKol.setCellValueFactory(new PropertyValueFactory<>("kornsort"));


        batchTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        batchTableView.getColumns().addAll(batchNummerKol, batchNavnKol,fadNummerKol,antalGangeBrugtKol,fadStørrelseKol,påfyldningsDatoKol, newMakeKol,alkoholProcentKol, mængdeLiterKol, kornsortKol);
        batchTableView.setPrefWidth(650);



        pane.add(batchTableView, 0, 0);

    }
}