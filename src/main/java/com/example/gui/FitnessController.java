package com.example.gui;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class FitnessController  implements Initializable, iController {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private final Keylistener keylistener = new Keylistener(scene);

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for(int i = 0; i < 19; i++) {
            collision.addCollision(changer,90,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(changer,570,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(690,changer,STANDARD_LENGTH,STANDARD_LENGTH);
            changer += 40;
        }
        changer = -30;
        for(int i = 0; i < 9; i++) {
            //To Gydehytte N
            collision.addCollision(-30, changer,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(-30, changer+400, STANDARD_LENGTH,STANDARD_LENGTH);
            changer += 40;
        }
        collision.showCollisionAreas(scene);

        // recptionen
        collision.addCollision(90, 290,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(90, 330,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(90, 370,STANDARD_LENGTH,STANDARD_LENGTH);

        // vending machines
        collision.addCollision(10, 170,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(10, 130,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(90, 170,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(90, 130,STANDARD_LENGTH,STANDARD_LENGTH);

        //Væg ved omklædningsrummet
        collision.addCollision(530, 210,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(530, 170,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(530, 130,STANDARD_LENGTH,STANDARD_LENGTH);

        collision.addCollision(530, 450,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(530, 490,STANDARD_LENGTH,STANDARD_LENGTH);
        collision.addCollision(530, 530,STANDARD_LENGTH,STANDARD_LENGTH);


    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) { //switch case
            RoomChanger roomChanger = new RoomChanger(collision, timer);
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            roomChanger.changeRoom(shape1, -30, 330, "Gydehutten_S", "Gydehutten Syd", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
        timer.start();
    }
}

