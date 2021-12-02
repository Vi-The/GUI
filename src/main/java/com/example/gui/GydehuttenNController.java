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

public class GydehuttenNController implements Initializable, iController {

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
            //To OutsideSDU
            collision.addCollision(changer, -30,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(changer+400, -30, STANDARD_LENGTH,STANDARD_LENGTH);
            //To Gydehutten S
            collision.addCollision(changer, 690,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(changer+400, 690, STANDARD_LENGTH,STANDARD_LENGTH);
            //To Kantine
            collision.addCollision(90, changer,STANDARD_LENGTH,STANDARD_LENGTH);
            collision.addCollision(90, changer+400, STANDARD_LENGTH,STANDARD_LENGTH);
            //To Classroom
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
           if (shape1.getLayoutX() == 90  && shape1.getLayoutY() == 330 ){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("Kantine.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Kantine");
                    shape1.setLayoutY(631);
                    shape1.setLayoutX(330);
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (shape1.getLayoutY() == -30 && shape1.getLayoutX() == 330){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("OUTSIDESDU.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("OUTSIDE SDU");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           else if(shape1.getLayoutX() == 570 && shape1.getLayoutY() == 330 ){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("Classroom.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Classroom");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (shape1.getLayoutX() == 330 && shape1.getLayoutY() == 690){
                try {
                    collision.removeCollision();
                    Parent root = FXMLLoader.load(getClass().getResource("Gydehutten_S.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Gydehutten S");
                    collision.removeCollision();
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

/*
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GYDEHUTTENS.fxml"));
        primaryStage.setTitle("Gydehutten S");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.show();
    }

}

*/
