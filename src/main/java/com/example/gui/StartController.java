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
    @FXML
    Button Featured;
    //method
    public void clickStart() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("OUTSIDESDU.fxml"));
        Stage window = (Stage) Startbutton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 700));
        window.setTitle("Hovedindgangen SDU");
        window.setResizable(false);
    }
    public void clickFeatured() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Featured.fxml"));
        Stage window = (Stage) Startbutton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 700));
        window.setTitle("Test kaniner");
        window.setResizable(false);
    }

}