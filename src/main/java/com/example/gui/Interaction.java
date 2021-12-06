package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Interaction {
    Scene scene;
    private Group root;
    private Rectangle shape;
    private final Stage stage = new Stage();
    private final Names names = new Names();
    String room;

    void openTextbox(Rectangle shape, String room) {
        this.room = room;
        this.shape = shape;

        switch (room) {
            //Lav en if-stamement for positionen af spilleren og bed programmet om at kører openWindow(room)
            case "OutsideSDU":
                break;
            case "Gydehutten Nord":
                break;
            case "Kantine":
                break;
            case "Classroom":
                if (shape.getLayoutX() == 370 && shape.getLayoutY() == 210) {
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

    void openWindow(String character) {
        try {
            if (character == "Male")
                character = names.Males();
            else if (character == "Female")
                character = names.Females();
            root = new Group();
            Scene scene = new Scene(root, 450, 300);
            this.scene = scene;
            stage.setTitle(character);
            stage.setScene(scene);
            getText(character);
            stage.show();
            closeText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getText(String NPC) {
        Text text;
        switch (NPC) {
            case "Professor":
                text = new Text("Test");
                break;
            case "Karen":
                text = new Text("");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + NPC);
        }

        text.setX(20); text.setY(20);
        text.setFont(new Font(20));
        root.getChildren().add(text);
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