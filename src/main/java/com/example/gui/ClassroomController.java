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

public class ClassroomController  implements Initializable, iController {

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

    /*@Override
    public void addImage(Parent root, int posX, int width, int posY, int height, String FolderAndImage) throws FileNotFoundException {
        Image i = new Image(new FileInputStream(FolderAndImage));
        ImageView image = new ImageView(i);
        image.setX(posX);
        image.setY(posY);
        image.setFitHeight(height);
        image.setFitWidth(width);
        root.getChildrenUnmodifiable().add(image);
    }*/

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) { //switch case
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {

                    keylistener.checkKeyInput(keyEvent, shape1);
                }
            });
            if (shape1.getLayoutX() >= 0 && shape1.getLayoutX() <= 20 && shape1.getLayoutY() == 330  ){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("GYDEHUTTEN_N.fxml"));
                    Stage window = (Stage) shape1.getScene().getWindow();
                    window.setScene(new Scene(root, 700, 700));
                    window.setTitle("Gydehutten N");
                    timer.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
    }

}


