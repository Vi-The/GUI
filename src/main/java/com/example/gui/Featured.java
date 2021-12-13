package com.example.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Featured { //Åbner nyt vindue når man klikker på featured. Navnene er tilføjet i fxml filen, fordi vi ikke vidste at de skulle tilhøre anchorpane for at vi kunne tilgå children (vores navne).
    @FXML
    Button tilbage;
    private ArrayList<String> featured = new ArrayList<>();

    public void start() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) tilbage.getScene().getWindow();
        window.setScene(new Scene(root, 700, 700));
        window.setTitle("Cykelhjelm");
        window.setResizable(false);
    }
}
