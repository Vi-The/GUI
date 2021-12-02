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

public class ClassroomController  implements Initializable, iController {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private Keylistener keylistener = new Keylistener(scene);

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 19; i++)//collision uden dør
        {
            collision.addCollision(changer,610, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(690, changer, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(changer, 50, STANDARD_LENGTH, STANDARD_LENGTH);
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
            roomChanger.changeRoom(shape1, -30, 330, "GYDEHUTTEN_N", "Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
        timer.start();
    }
}


