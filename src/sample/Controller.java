package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import sample.concurency.ParserTask;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Controller implements Initializable {

    private final String[] encodings = {"WINDOWS-1251","windows-1258", "UTF-8", "UTF-16",
            "ISO-8859-5", "MACCYRILLIC", "IBM866", "IBM855", "KOI8-R"};
    public ListView<String> lvFiles,lvResult;
    public ChoiceBox<String> cbEncoding;

    public TextField etPredicate;
    private Thread runner;
    private DirectoryChooser directoryChooser;

    private FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        directoryChooser = new DirectoryChooser();
        fileChooser = new FileChooser();
        lvFiles.setItems(FXCollections.observableArrayList());


        cbEncoding.getItems().addAll(encodings);
        cbEncoding.setValue(encodings[0]);


    }


    private void readFile(String file, String encoding) {
        if (runner == null || !runner.isAlive()) {
            String predicate = etPredicate.getText()== null ?"" : etPredicate.getText();

            System.out.printf("Starting thread with encoding %s prediacate %s in file %s", encoding,predicate,file);
            runner = new Thread(new ParserTask(file, encoding,predicate));
            runner.start();
        }
    }


    public void onStart(ActionEvent event) {
        String selectedItem = lvFiles.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            readFile(selectedItem, cbEncoding.getValue());
        }
    }

    public void onListClicked(Event event) {
        System.out.println(lvFiles.getSelectionModel().getSelectedItem());
    }

    public void onOpenFile(ActionEvent event) {
        lvFiles.getItems().addAll("Menu open");
        File file = fileChooser.showOpenDialog(lvFiles.getScene().getWindow());
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            lvFiles.getItems().add(absolutePath);
        }


    }

    public void onOpenFiles(ActionEvent event) {


        directoryChooser.setInitialDirectory(new File("."));

        File files = directoryChooser.showDialog(lvFiles.getScene().getWindow());

        if (files != null) {
            File[] newFiles = files.listFiles();

            String[] strings = Stream.of(newFiles).map(File::getAbsolutePath).toArray(String[]::new);


            lvFiles.getItems().clear();
            lvFiles.getItems().addAll(strings);
        }

    }

    public void onQuit(ActionEvent event) {
        lvFiles.getItems().add("Menu quit");
    }

    public void onStop(ActionEvent event) {
        if (runner != null) {
            runner.interrupt();
        }
    }
}
