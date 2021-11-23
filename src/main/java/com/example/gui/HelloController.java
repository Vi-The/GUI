package com.example.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController {


    @FXML
    Button Startbutton;


    //method
    public void clickStart() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("OUTSIDESDU.fxml"));

        Stage window = (Stage) Startbutton.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
/*
    @FXML
    ImageView myBike;

    @Override
    public void initialize (URL url, ResourceBundle rb) {

    Image myImage = new Image(getClass().getResourceAsStream("Bike.jpg"));

    myBike.setImage(image);
    }
    */
}