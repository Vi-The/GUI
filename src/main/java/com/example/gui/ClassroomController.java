package com.example.gui;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassroomController implements Initializable, iController {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private final Keylistener keylistener = new Keylistener(false, "Klasselokale");

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(10);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 19; i++)//collision uden dør
        {
            collision.addCollision(changer, 610);
            collision.addCollision(690, changer);
            collision.addCollision(changer, 50);
            changer += 40;
        }
        changer = -30;
        for (int i = 0; i < 9; i++) {
            //To Gydehytte N
            collision.addCollision(-30, changer);
            collision.addCollision(-30, changer + 400);
            changer += 40;
        }
        collision.showCollisionAreas(scene);
        changer = -30;
        for (int i = 0; i < 19; i++) {
            collision.addCollision(changer, 130);
            changer += 40;
        }
        collision.addCollision(370, 170);
        collision.addCollision(330, 170);
        collision.addCollision(330, 210);
        int posX = 170;
        for (int x = 0; x < 9; x++) {
            int posY = 290;
            for (int y = 0; y < 4; y++) {
                collision.addCollision(posX, posY);
                posY += 40;
            }
            posX += 40;
        }
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
            roomChanger.changeRoom(shape1, -30, 330, "GYDEHUTTEN_N", "Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image Samuel = new Image(getClass().getResourceAsStream("/Assets/Characters/SamuelNyNy.png"));
        shape1.setFill(new ImagePattern(Samuel));
        addCollision();
        timer.start();
    }
}