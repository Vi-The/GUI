package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApplication extends Application { //extends Application er en javafx superklasse (ellers kan vi ikke nedarve fra den) og den sørger for at vi kan køre alle javafx bibliotekerne
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Cykelhjem spil");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args); //launch (args) er en indbygget applikation i javafx der launcher/søsætter alt det kode vi har skrevet i start metoden. Ellers kan vi ikke starte programmet.
    }
}