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

public class OutsideSDUController implements Initializable, iController {
    @FXML
    private Rectangle shape1;
    @FXML
    private AnchorPane scene1;
    private final Keylistener keylistener = new Keylistener(scene1);
    private Items items = new Items(StartController.root);

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
            collision.addCollision(changer, -30);
            changer += 40;
        }
        changer = -30;
        for (int i = 0; i < 9; i++) {
            collision.addCollision(changer, 690);
            collision.addCollision(changer + 400, 690);
            changer += 40;
        }
        collision.showCollisionAreas(scene1);
        //Collision thats not the box
        collision.addCollision(50, 50);
        collision.addCollision(90, 50);
        collision.addCollision(50, 90);
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
            roomChanger.changeRoom(shape1, 330, 690,"GYDEHUTTEN_N","Gydehutten Nord", true);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
       // items.placeItem(50,150,"src/main/resources/Assets/Items/rat.jpg");
        timer.start();
    }
}