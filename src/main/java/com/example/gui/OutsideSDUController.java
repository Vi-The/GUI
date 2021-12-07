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
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OutsideSDUController implements Initializable, iController {
    @FXML
    private Rectangle shape1;
    @FXML
    private AnchorPane scene1;
    private final Keylistener keylistener = new Keylistener(true, "Hovedindgangen SDU");

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 19; i++)
        {
            collision.addCollision(-30, changer);
            collision.addCollision(690, changer);
            collision.addCollision(changer, 50);
            collision.addCollision(changer, 530);
            changer += 40;
        }

        changer = -30;
        for (int i = 0; i < 9; i++) {
            collision.addCollision(changer, 490);
            collision.addCollision(changer + 400, 490);
            changer += 40;
        }
        collision.showCollisionAreas(scene1);
        //Collisions at the screen
        collision.addCollision(570, 250);
        collision.addCollision(530, 250);
        collision.addCollision(530, 210);
        collision.addCollision(570, 210);
        collision.addCollision(570, 170);
        collision.addCollision(530, 170);
        collision.addCollision(10, 410);
        collision.addCollision(50, 410);
        collision.addCollision(90, 410);
        collision.addCollision(130, 410);
        collision.addCollision(170, 410);
        collision.addCollision(210, 410);
        collision.addCollision(250, 410);
        collision.addCollision(290, 410);
        collision.addCollision(290, 370);
        collision.addCollision(290, 330);
        collision.addCollision(290, 290);
        collision.addCollision(290, 250);
        collision.addCollision(290, 210);
        collision.addCollision(290, 170);
        collision.addCollision(290, 130);
        collision.addCollision(250, 130);
        collision.addCollision(210, 130);
        collision.addCollision(170, 130);
        collision.addCollision(130, 130);
        collision.addCollision(90, 130);
        collision.addCollision(50, 130);
        collision.addCollision(10, 130);
        //Karen
        collision.addCollision(570,370);
    }

    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long timestamp) {
            RoomChanger roomChanger = new RoomChanger(collision, timer);
            scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            if(questChecker.talkedToKaren)
                roomChanger.changeRoom(shape1, 330, 490,"GYDEHUTTEN_N","Gydehutten Nord", true);
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