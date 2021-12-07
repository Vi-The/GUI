package com.example.domain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("GAME");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);
    }
}