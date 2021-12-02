package com.example.gui;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GydehuttenSController  implements Initializable, iController {

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
        for(int i = 0; i < 9; i++)
        {
            //To Gydehutten N
            collision.addCollision(changer, -30,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(changer+400, -30, STANDARD_LENGTH,STANDARD_LENGTH);
            //To Bikeshop
            collision.addCollision(changer, 690,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(changer+400, 690, STANDARD_LENGTH,STANDARD_LENGTH);
            //To Nedenunder
            collision.addCollision(90, changer,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(90, changer+400, STANDARD_LENGTH,STANDARD_LENGTH);
            //To Fitness
            collision.addCollision(570, changer,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(570, changer+400, STANDARD_LENGTH,STANDARD_LENGTH);
            changer += 40;
        }
        collision.showCollisionAreas(scene);
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) { //switch case
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            if (shape1.getLayoutY() >= 0 && shape1.getLayoutY() <= 20 && shape1.getLayoutX() == 330 ){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("GYDEHUTTEN_N.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Gydehutten N");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(shape1.getLayoutX() >= 630 && shape1.getLayoutX() <= 655 && shape1.getLayoutY() == 330 ){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("Fitness.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("SDU Fitness");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (shape1.getLayoutX() >= 0 && shape1.getLayoutX() <= 20 && shape1.getLayoutY() == 330 ){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("Nedenunder.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Nedenunder");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (shape1.getLayoutX() < 350 && shape1.getLayoutX() > 300 && shape1.getLayoutY() >= 639){ // skal ændres så det ikke kun er på det korrdinatsæt at blokken vil skifte rum
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("Bikeshop.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Bikeshop");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCollision();
        timer.start();
    }
}


