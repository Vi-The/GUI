package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GYDEHUTTENC extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GYDEHUTTENS.fxml"));
        primaryStage.setTitle("Gydehutten S");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }
    public static void main(String[] args) {launch(args);
    }

}



