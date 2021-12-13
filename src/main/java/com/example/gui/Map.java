package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;




public class Map { //Fungerer på samme måde som shop. Loader billedet ind i vinduet modsat shoppen.

    Scene scene;
    private Group root;
    private Stage stage = new Stage();

    public void addImage() throws FileNotFoundException { //Sørger for den kan sige den ikke kan finde filen.
        Image Map = new Image(new FileInputStream("src/Assets/Map over SDU 3.png"));
        ImageView image = new ImageView(Map);
        image.setX(0);
        image.setY(0);
        root.getChildren().add(image);
    }


    void openMap() {
        try {
            root = new Group();
            Scene scene = new Scene(root,690,690);
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