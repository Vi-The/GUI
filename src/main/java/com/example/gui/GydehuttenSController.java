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

public class GydehuttenSController implements Initializable, iController {

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene;
    private final Keylistener keylistener = new Keylistener(false, "Gydehutten Syd");

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 9; i++) {
            if(i < 7) { //To Gydehutten N
                collision.addCollision(changer, -30);
                collision.addCollision(changer+480, -30);
            }
            collision.addCollision(changer, 690);
            collision.addCollision(changer + 400, 690);
            //To Nedenunder
            collision.addCollision(90, changer);
            collision.addCollision(90, changer + 400);
            //To Fitness
            collision.addCollision(570, changer);
            collision.addCollision(570, changer + 400);
            changer += 40;
        }
        collision.showCollisionAreas(scene);
        collision.addCollision(130, 90);
        collision.addCollision(130, 50);
        collision.addCollision(130, 490);
        collision.addCollision(130, 530);
        collision.addCollision(130, 450);
        collision.addCollision(170, 610);
        collision.addCollision(490, 210);
        collision.addCollision(530, 130);
        collision.addCollision(530, 490);
        collision.addCollision(530, 530);
        collision.addCollision(530, 10);
        collision.addCollision(530, 50);
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
            if(questChecker.talkedToProfessor)
                roomChanger.changeRoom(shape1, 570, 330, "Fitness", "Fitness", true);
            roomChanger.changeRoom(shape1, 250, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 290, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 330, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 370, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 410, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);

            if(questChecker.talkedToBryce)
                roomChanger.changeRoom(shape1, 90, 330, "Nedenunder", "SDU Fredagsbar: Nedenunder", true);
            if(questChecker.talkedToFriends)
                roomChanger.changeRoom(shape1, 330, 690, "Bikeshop", "Cykelforhandler", true);
            //Adding doorroom to Gydehutten S
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