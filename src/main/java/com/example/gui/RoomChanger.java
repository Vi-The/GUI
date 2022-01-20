package com.example.gui;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomChanger {
    Collision collision;
    AnimationTimer timer; //Tjekker om der sker noget i vinduet.
    RoomChanger(Collision collision, AnimationTimer timer)
    {
        this.collision = collision;
        this.timer = timer;
    }

    void changeRoom(Rectangle player, int doorXasis, int doorYaxis, String fxmlMail, String roomTitle, boolean disabledCollision) { //Metode siger hvis spilleren position stemmer overens med dørens position, så skifter rummet.
        if (player.getLayoutX() == doorXasis && player.getLayoutY() == doorYaxis) {
            try {
                collision.removeCollision(); //Fjerner collisions når man går ud af rummet
                Parent root = FXMLLoader.load(getClass().getResource(fxmlMail+".fxml")); //fxmlMail er navnet på den fil vi skal bruge
                Stage window = (Stage) player.getScene().getWindow();
                window.setScene(new Scene(root, 700, 700));
                window.setTitle(roomTitle);
                collision.setDisableCollision(disabledCollision); //Hvis man ikke har lyst til collisions i rummet, så kan man fjerne dem. Ikke en nødvendig feature.
                timer.stop(); //Stopper timeren fordi vi skifter rum fordi hvis ikke vi gør det så kører to timeren ved siden af hinanden og skaber dermed fejl.
            } catch (IOException e) { //IOException fordi den reagerer på at vi trykker på tasterne.
                e.printStackTrace();
            }
        }
    }
}
