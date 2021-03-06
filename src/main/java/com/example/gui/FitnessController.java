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

public class FitnessController implements Initializable, iController {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private final Keylistener keylistener = new Keylistener(false, "Fitness");

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 19; i++) {
            collision.addCollision(changer, 90);
            collision.addCollision(changer, 570);
            collision.addCollision(690, changer);
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

        // recptionen
        collision.addCollision(90, 290);
        collision.addCollision(90, 330);
        collision.addCollision(90, 370);

        // vending machines
        collision.addCollision(10, 170);
        collision.addCollision(10, 130);
        collision.addCollision(90, 170);
        collision.addCollision(90, 130);

        //Væg ved omklædningsrummet
        collision.addCollision(530, 210);
        collision.addCollision(530, 450);

        //Bryce

        collision.addCollision(170, 410);
        collision.addCollision(170,370);

        collision.addCollision(290, 330);
        collision.addCollision(290, 290);
        collision.addCollision(330, 290);
        collision.addCollision(290, 290);
        collision.addCollision(290, 250);
        collision.addCollision(250, 330);

        collision.addCollision(210, 170);
        collision.addCollision(210, 130);

        collision.addCollision(450,290);
        collision.addCollision(450,330);
        collision.addCollision(490,290);
        collision.addCollision(490,330);

        int posX = 170;
        for(int x = 0; x < 5; x++){
            int posY = 490;
            for (int y = 0; y < 2; y++){
                collision.addCollision(posX, posY);
                posY += 40;
            }
            posX += 40;
        }
        posX = 450;
        for(int x = 0; x < 6; x++){
            int posY = 490;
            for (int y = 0; y < 2; y++){
                collision.addCollision(posX, posY);
                posY += 40;
            }
            posX += 40;
        }
        posX = 450;
        for(int x = 0; x < 6; x++){
            int posY = 130;
            for (int y = 0; y < 2; y++){
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
            roomChanger.changeRoom(shape1, -30, 330, "Gydehutten_S", "Gydehutten Syd", true);
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