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

public class NedenunderController  implements Initializable, iController {

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
        for (int i = 0; i < 19; i++) {
            //Outer frame - ensures that we can't go out of the frame.
            collision.addCollision(-30, changer, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden modsat Gydehutten
            collision.addCollision(690, changer, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden ud mod Gydehutten S
            collision.addCollision(changer, -30, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden op mod Kantinan
            collision.addCollision(changer, 530, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden ned mod bikeshop.
            changer += 40;
        }

        //collision.showCollisionAreas(scene);

        collision.addCollision(570, 330, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 330, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(570, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 450, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 450, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 450, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(250, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(210, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(170, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(130, 410, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(170, 290, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(130, 290, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(90, 290, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(50, 290, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(50, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(90, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(210, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(250, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(290, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(290, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(330, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(370, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(370, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(570, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(570, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 170, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(370, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(330, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(290, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(250, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(210, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        //collision.showCollisionAreas(scene);

    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) { //switch case
            RoomChanger roomChanger = new RoomChanger(collision,timer);
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            roomChanger.changeRoom(shape1, 690, 330, "Gydehutten_S", "Gydehutten Syd", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
        addCollision();
    }
}

