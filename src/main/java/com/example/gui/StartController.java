package com.example.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {
    @FXML
    Button Startbutton;
    static Parent root;
    //method
    public void clickStart() throws Exception {
        root = FXMLLoader.load(getClass().getResource("OUTSIDESDU.fxml"));
        Stage window = (Stage) Startbutton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 700));
        window.setTitle("Outside SDU");
    }
}