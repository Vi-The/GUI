package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;




public class Map {

    Scene scene;
    private Group root;
    private Stage stage = new Stage();

    public void addImage() throws FileNotFoundException {
        Image Map = new Image(new FileInputStream("src/Assets/Map til spil v2.png"));
        ImageView image = new ImageView(Map);
        image.setX(0);
        image.setY(0);
        root.getChildren().add(image);
    }


    void openMap() {
        try {
            root = new Group();
            Scene scene = new Scene(root,300,300);
            this.scene = scene;
            stage.setTitle("Kort over spillet");
            stage.setScene(scene);
            addImage();
            stage.show();
            closeMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void closeMap() {
        try {
            scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.M)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}