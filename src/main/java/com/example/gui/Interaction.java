package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Interaction {
    Scene scene;
    private Group root;
    private Rectangle shape;
    private final Stage stage = new Stage();
    private Names names = new Names();
    String room;

    void openTextbox(Rectangle shape, String room) {
        this.room = room;
        this.shape = shape;

        switch (room) {
            //Lav en if-stamement for positionen af spilleren og bed programmet om at kører openWindow(Name)
            case "OutsideSDU":
                break;
            case "Gydehutten Nord":
                break;
            case "Kantine":
                break;
            case "Classroom":
                if(shape.getLayoutX() == 370 && shape.getLayoutY() == 210){
                    openWindow("Professor");
                }
                break;
            case "Gydehutten Syd":
                break;
            case "Nedenunder":
                break;
            case "Fitness":
                break;
            case "Bikeshop":
                break;
        }

    }

    void openWindow(String Character) {
        try {
            if(Character == "Male"){
                Character = names.Males();
            }
            else if(Character == "Female") {
                Character = names.Females();
            }
            root = new Group();
            Scene scene = new Scene(root, 450, 300);
            this.scene = scene;
            stage.setTitle(Character);
            stage.setScene(scene);
            //showInv();
            stage.show();
            closeText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void closeText() {
        try {
            scene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.T)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
