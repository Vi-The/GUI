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

public class KantineController implements Initializable, iController {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private final Keylistener keylistener = new Keylistener(scene, true, "Kantine");

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
            collision.addCollision(-30, changer); //Dette er siden modsat Gydehutten
            collision.addCollision(changer, -30); //Dette er siden op mod OUTsideSDU
            collision.addCollision(changer, 530); //Dette er siden ned mod nedenunder.
            changer += 40;
        }
        changer = -30;
        for (int i = 0; i < 8; i++) { //9 har noget med størrelsen af skærmen at gøre.
            //To Gydehutten N
            collision.addCollision(690, changer);
            collision.addCollision(690, changer + 360 );
            changer +=40;
        }
        collision.showCollisionAreas(scene);
        collision.addCollision(130, 130);
        collision.addCollision(90, 130);
        collision.addCollision(50, 130);
        collision.addCollision(90, 90);
        collision.addCollision(10, 290);
        collision.addCollision(10, 330);
        collision.addCollision(10, 370);
        collision.addCollision(170, 330);
        collision.addCollision(290, 130);
        collision.addCollision(330, 130);
        collision.addCollision(370, 130);
        collision.addCollision(410, 130);
        collision.addCollision(450, 130);
        collision.addCollision(490, 130);
        collision.addCollision(530, 130);
        collision.addCollision(610, 130);
        collision.addCollision(530, 250);
        collision.addCollision(490, 250);
        collision.addCollision(450, 250);
        collision.addCollision(410, 250);
        collision.addCollision(370, 250);
        collision.addCollision(330, 250);
        collision.addCollision(290, 250);
        collision.addCollision(250, 250);
        collision.addCollision(250, 370);
        collision.addCollision(290, 370);
        collision.addCollision(330, 370);
        collision.addCollision(370, 370);
        collision.addCollision(410, 370);
        collision.addCollision(450, 370);
        collision.addCollision(490, 370);
        collision.addCollision(530, 370);
        collision.addCollision(530, 330);
        collision.addCollision(250, 130);
        collision.addCollision(450, 450);
        collision.addCollision(490, 450);
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
            roomChanger.changeRoom(shape1, 690, 290, "GYDEHUTTEN_N", "Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
        addCollision();
    }
}


