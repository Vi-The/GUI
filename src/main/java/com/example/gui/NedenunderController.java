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

public class NedenunderController  implements Initializable, iController {

    @FXML
    private Rectangle shape1; // skifte shape1 til navn på spilleren eller noget #cleancode

    @FXML
    private AnchorPane scene; // scene navn til navnet på det gældende rum
    private final Keylistener keylistener = new Keylistener(true, "Nedenunder");

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
            collision.addCollision(-30, changer ); //Dette er siden modsat Gydehutten
            //collision.addCollision(690, changer ); //Dette er siden ud mod Gydehutten S
            collision.addCollision(changer, -30 ); //Dette er siden op mod Kantinan
            collision.addCollision(changer, 530 ); //Dette er siden ned mod bikeshop.
            changer += 40;
        }
        changer = -30;
        for (int i = 0; i < 9; i++) {
            //To Gydehutten S
            collision.addCollision(690, changer);
            collision.addCollision(690, changer + 400 );
            changer +=40;
        }

        collision.showCollisionAreas(scene);

        collision.addCollision(570, 330 );
        collision.addCollision(530, 330 );
        collision.addCollision(570, 410 );
        collision.addCollision(530, 410 );
        collision.addCollision(490, 450 );
        collision.addCollision(450, 450 );
        collision.addCollision(410, 450 );
        collision.addCollision(490, 410 );
        collision.addCollision(450, 410 );
        collision.addCollision(410, 410 );
        collision.addCollision(410, 370 );
        collision.addCollision(250, 410 );
        collision.addCollision(210, 410 );
        collision.addCollision(170, 410 );
        collision.addCollision(130, 410 );
        collision.addCollision(170, 290 );
        collision.addCollision(130, 290 );
        collision.addCollision(90, 290 );
        collision.addCollision(50, 290 );
        collision.addCollision(50, 210 );
        collision.addCollision(90, 210 );
        collision.addCollision(210, 170 );
        collision.addCollision(250, 170 );
        collision.addCollision(290, 170 );
        collision.addCollision(290, 170 );
        collision.addCollision(330, 170 );
        collision.addCollision(370, 170 );
        collision.addCollision(410, 170 );
        collision.addCollision(450, 170 );
        collision.addCollision(370, 130 );
        collision.addCollision(570, 130 );
        collision.addCollision(570, 170 );
        collision.addCollision(530, 170 );
        collision.addCollision(450, 210 );
        collision.addCollision(410, 210 );
        collision.addCollision(330, 210 );
        collision.addCollision(290, 210 );
        collision.addCollision(250, 210 );
        collision.addCollision(210, 210 );
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
        Image Samuel = new Image(getClass().getResourceAsStream("/Assets/Characters/SamuelNyNy.png"));
        shape1.setFill(new ImagePattern(Samuel));
        timer.start();
        addCollision();
    }
}


