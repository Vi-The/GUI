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

public class KantineController  implements Initializable, iController {

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
            collision.addCollision(690, changer, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden ud mod Gydehutten N
            collision.addCollision(changer, -30, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden op mod OUTsideSDU
            collision.addCollision(changer, 530, STANDARD_LENGTH, STANDARD_LENGTH); //Dette er siden ned mod nedenunder.
            changer += 40;
        }
        /*
        for (int i = 0; i < 9; i++) { //9 har noget med størrelsen af skærmen at gøre.
            //To Gydehutten N
            collision.addCollision(changer,570, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(570, changer + 400, STANDARD_LENGTH, STANDARD_LENGTH);
            changer +=40;
        }

         */


        //collision.showCollisionAreas(scene);

        collision.addCollision(130, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(90, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(50, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(90, 90, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(10, 290, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(10, 330, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(10, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(170, 330, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(290, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(330, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(370, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(610, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(370, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(330, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(290, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(250, 250, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(250, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(290, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(330, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(370, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(410, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 370, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 330, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(250, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(450, 450, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 450, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.showCollisionAreas(scene);


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
            roomChanger.changeRoom(shape1, 690, 330, "GYDEHUTTEN_N", "Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
        addCollision();
    }
}


