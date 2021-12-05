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

public class GydehuttenNController implements Initializable, iController {

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
        for (int i = 0; i < 9; i++) {
            //To OutsideSDU
            collision.addCollision(changer, -30);
            collision.addCollision(changer + 400, -30);

            if (i < 7) {//Toward Gydehutten S
                collision.addCollision(changer, 690);
                collision.addCollision(changer + 480, 690);
            }
            //Toward Kantine
            collision.addCollision(90, changer);
            collision.addCollision(90, changer + 400);
            //Toward Classroom
            collision.addCollision(570, changer);
            collision.addCollision(570, changer + 400);
            changer += 40;
        }
        //collision.showCollisionAreas(scene);
        collision.addCollision(170, 170);
        collision.addCollision(130, 90);
        collision.addCollision(130, 50);
        collision.addCollision(530, 130);
        collision.addCollision(490, 410);
        collision.addCollision(490, 450);
        collision.addCollision(530, 490);
        collision.addCollision(530, 530);
        collision.addCollision(130, 490);
        collision.addCollision(130, 530);
        collision.addCollision(130, 450);
        collision.addCollision(530, 10);
        collision.addCollision(530, 50);
        collision.showCollisionAreas(scene);
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            RoomChanger roomChanger = new RoomChanger(collision, timer);
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            roomChanger.changeRoom(shape1, 90, 330, "Kantine", "SDU Kantine", true);
            roomChanger.changeRoom(shape1, 330, -30, "OUTSIDESDU", "Outside SDU", true);
            roomChanger.changeRoom(shape1, 570, 330, "Classroom", "Classroom", true);
            //Adding bigger doors to Gydehutten S
            roomChanger.changeRoom(shape1, 250, 690, "Gydehutten_S", "Gydehutten Syd", true);
            roomChanger.changeRoom(shape1, 290, 690, "Gydehutten_S", "Gydehutten Syd", true);
            roomChanger.changeRoom(shape1, 330, 690, "Gydehutten_S", "Gydehutten Syd", true);
            roomChanger.changeRoom(shape1, 370, 690, "Gydehutten_S", "Gydehutten Syd", true);
            roomChanger.changeRoom(shape1, 410, 690, "Gydehutten_S", "Gydehutten Syd", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
        timer.start();
    }
}