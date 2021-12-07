package com.example.gui;

import com.example.domain.Keylistener;
import com.example.domain.RoomChanger;
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

public class BikeshopController implements Initializable, iController {

    @FXML
    private Rectangle shape1;

    @FXML
    private AnchorPane scene;
    private final Keylistener keylistener = new Keylistener(true, "Bikeshop");

    @FXML
    public void start(ActionEvent event) {
        shape1.setLayoutY(330);
        shape1.setLayoutX(330);
    }

    @Override
    public void addCollision() {
        int changer = -30;
        for (int i = 0; i < 19; i++) {
            collision.addCollision(-30, changer);
            collision.addCollision(690, changer);
            collision.addCollision(changer, 490);
            changer += 40;
        }
        collision.showCollisionAreas(scene);
        changer = -30;
        for (int i = 0; i < 7; i++) {
            collision.addCollision(changer, 210);
            changer += 40;
        }
        changer = 330;
        for (int i = 0; i < 9; i++) {
            collision.addCollision(changer, 210);
            changer += 40;
        }
        collision.addCollision(10, 250);
        collision.addCollision(450, 250);
        collision.addCollision(490, 290);
        collision.addCollision(450, 290);
        collision.addCollision(410, 290);
        int posX = 90;
        for (int x = 0; x < 4; x++) {
            int posY = 330;
            for (int y = 0; y < 3; y++) {
                collision.addCollision(posX, posY);
                posY += 40;
            }
            posX += 40;
        }
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
            roomChanger.changeRoom(shape1, 290, 210, "Gydehutten_S", "Gydehutten Syd", true);
            roomChanger.changeRoom(shape1, 250, 210, "Gydehutten_S", "Gydehutten Syd", true);
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


