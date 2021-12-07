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

public class KantineController implements Initializable, iController {

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private final Keylistener keylistener = new Keylistener(true, "Kantine");

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
            collision.addCollision(changer, 50); //Dette er siden op mod OUTsideSDU
            collision.addCollision(changer, 490); //Dette er siden ned mod nedenunder.
            changer += 40;
        }
        changer = -30;
        for (int i = 0; i < 8; i++) {
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
        collision.addCollision(610, 130);
        collision.addCollision(530, 330);
        collision.addCollision(450, 450);
        collision.addCollision(490, 450);
      int posX = 250;
        for(int x = 0; x < 8; x++){
            int posY = 130;
            for (int y = 0; y < 1; y++){
                collision.addCollision(posX, posY);
                posY += 40;
            }
            posX += 40;
        }
        posX = 250;
        for(int x = 0; x < 8; x++){
            int posY = 250;
            for (int y = 0; y < 1; y++){
                collision.addCollision(posX, posY);
                posY += 40;
            }
            posX += 40;
        }
        posX = 250;
        for(int x = 0; x < 8; x++){
            int posY = 370;
            for (int y = 0; y < 1; y++){
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
            roomChanger.changeRoom(shape1, 690, 290, "GYDEHUTTEN_N", "Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image Samuel = new Image(getClass().getResourceAsStream("/Assets/Characters/SamuelNyNy.png"));
        shape1.setFill(new ImagePattern(Samuel));
        timer.start();
        addCollision();
    }
}