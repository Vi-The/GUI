package com.example.gui.presentation;

import com.example.gui.domain.Keylistener;
import com.example.gui.domain.RoomChanger;
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

public class GydehuttenSController implements Initializable, iController {

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene;
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
            if(i < 7) { //To Gydehutten N
                collision.addCollision(changer, -30,STANDARD_LENGTH,STANDARD_LENGTH);
                collision.addCollision(changer+480, -30, STANDARD_LENGTH,STANDARD_LENGTH);
            }
            collision.addCollision(changer, 690, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(changer + 400, 690, STANDARD_LENGTH, STANDARD_LENGTH);
            //To Nedenunder
            collision.addCollision(90, changer, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(90, changer + 400, STANDARD_LENGTH, STANDARD_LENGTH);
            //To Fitness
            collision.addCollision(570, changer, STANDARD_LENGTH, STANDARD_LENGTH);
            collision.addCollision(570, changer + 400, STANDARD_LENGTH, STANDARD_LENGTH);
            changer += 40;
        }
        //collision.showCollisionAreas(scene);
        collision.addCollision(130, 90, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(130, 50, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(130, 490, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(130, 530, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(130, 450, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(170, 610, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(490, 210, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 130, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 490, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 530, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 10, STANDARD_LENGTH, STANDARD_LENGTH);
        collision.addCollision(530, 50, STANDARD_LENGTH, STANDARD_LENGTH);
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
            roomChanger.changeRoom(shape1, 90, 330, "Nedenunder", "SDU Fredagsbar: Nedenunder", true);
            roomChanger.changeRoom(shape1, 570, 330, "Fitness", "Fitness", true);
            roomChanger.changeRoom(shape1, 330, 690, "Bikeshop", "Bikeshop", true);
            //Adding doorroom to Gydehutten S
            roomChanger.changeRoom(shape1, 250, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 290, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 330, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 370, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
            roomChanger.changeRoom(shape1, 410, -30, "GYDEHUTTEN_N", "Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
        timer.start();
    }
}


