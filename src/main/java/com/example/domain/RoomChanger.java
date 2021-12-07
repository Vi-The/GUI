package com.example.domain;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomChanger {
    Collision collision;
    AnimationTimer timer;
    public RoomChanger(Collision collision, AnimationTimer timer)
    {
        this.collision = collision;
        this.timer = timer;
    }
    public void changeRoom(Rectangle player, int doorXasis, int doorYaxis, String fxmlMail, String roomTitle, boolean disabledCollision) {
        if (player.getLayoutX() == doorXasis && player.getLayoutY() == doorYaxis) {
            try {
                collision.removeCollision();
                Parent root = FXMLLoader.load(getClass().getResource(fxmlMail+".fxml"));
                Stage window = (Stage) player.getScene().getWindow();
                window.setScene(new Scene(root, 700, 700));
                window.setTitle(roomTitle);
                collision.setDisableCollision(disabledCollision);
                timer.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
