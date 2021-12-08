package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interaction {
    Scene scene;
    private Group root;
    private Rectangle shape;
    private final Stage stage = new Stage();
    private final Names names = new Names();
    boolean gutterne = false;
    boolean karen = false;
    QuestChecker questChecker = iController.questChecker;
    String room;

    void openTextbox(Rectangle shape, String room) {
        this.room = room;
        this.shape = shape;

        switch (room) {
            //Lav en if-stamement for positionen af spilleren og bed programmet om at kører openWindow(room)
            case "Hovedindgangen SDU":
                if(shape.getLayoutX() == 570 && shape.getLayoutY() == 410  || shape.getLayoutX() == 530 && shape.getLayoutY() == 370 || shape.getLayoutX() == 610 && shape.getLayoutY() == 370){
                    openWindow("Karen-Hovedindgang");
                    questChecker.talkedToKaren = true;
                }
                break;
            case "Gydehutten Nord":
                break;
            case "Kantine":
                if(shape.getLayoutX() == 650 && shape.getLayoutY() == 130 ||
                        shape.getLayoutX() == 610 && shape.getLayoutY() == 170 ||
                        shape.getLayoutX() == 570 && shape.getLayoutY() == 130) {
                    openWindow("Female");
                } else if (shape.getLayoutX() == 170 && shape.getLayoutY() == 290 ||
                        shape.getLayoutX() == 130 && shape.getLayoutY() == 330 ||
                        shape.getLayoutX() == 210 && shape.getLayoutY() == 330 ||
                        shape.getLayoutX() == 210 && shape.getLayoutY() == 290) {
                    openWindow("Male");
                } else if (shape.getLayoutX() == 410 && shape.getLayoutY() == 450 ||
                        shape.getLayoutX() == 450 && shape.getLayoutY() == 410 ||
                        shape.getLayoutX() == 490 && shape.getLayoutY() == 410) {
                    openWindow("Female");
                }
                break;
            case "Klasselokale":
                if (shape.getLayoutX() == 370 && shape.getLayoutY() == 210 || shape.getLayoutX() == 410 && shape.getLayoutY() == 170) {
                    openWindow("Professor");
                    questChecker.talkedToProfessor = true;
                }
                break;
            case "Gydehutten Syd":
                break;
            case "Nedenunder":
                if (shape.getLayoutX() == 210 && shape.getLayoutY() == 290 || shape.getLayoutX() == 210 && shape.getLayoutY() == 330) {
                    openWindow("Gutterne");
                    gutterne = true;
                } else if (shape.getLayoutX() == 90 && shape.getLayoutY() == 250){
                        openWindow("Karen-Nedenunder");
                        karen = true;
                } else if (shape.getLayoutX() == 610 && shape.getLayoutY() == 130){
                    openWindow("Male");
                } else if (shape.getLayoutX() == 570 && shape.getLayoutY() == 370){
                    openWindow("Male");
                } else if (shape.getLayoutX() == 530 && shape.getLayoutY() == 370){
                    openWindow("Female");
                } else if (shape.getLayoutX() == 450 && shape.getLayoutY() == 370){
                    openWindow("Female");
                } else if (shape.getLayoutX() == 410 && shape.getLayoutY() == 330){
                    openWindow("Female");
                } else if (shape.getLayoutX() == 370 && shape.getLayoutY() == 370) {
                    openWindow("Female");
                } else if (shape.getLayoutX() == 130 && shape.getLayoutY() == 370){
                    openWindow("Male");
                } else if (shape.getLayoutX() == 90 && shape.getLayoutY() == 410){
                    openWindow("Male");
                } else if (shape.getLayoutX() == 90 && shape.getLayoutY() == 450){
                    openWindow("Male");
                } else if (shape.getLayoutX() == 610 && shape.getLayoutY() == 450){
                    openWindow("Male");
                } else if (shape.getLayoutX() == 610 && shape.getLayoutY() == 450){
                    openWindow("Male");
                }
                if(gutterne && karen)
                    questChecker.talkedToFriends = true;
                break;
            case "Fitness":
                if (shape.getLayoutX() == 130 && shape.getLayoutY() == 410 ||
                        shape.getLayoutX() == 210 && shape.getLayoutY() == 370 ||
                        shape.getLayoutX() == 170 && shape.getLayoutY() == 450
                        || shape.getLayoutX() == 210 && shape.getLayoutY() == 410
                        || shape.getLayoutX() == 210 && shape.getLayoutY() == 370) {
                    openWindow("Bryce");
                    questChecker.talkedToBryce = true;
                } else if (shape.getLayoutX() == 10 && shape.getLayoutY() == 450) {
                    openWindow("Female");
                } else if (shape.getLayoutX() == 90 && shape.getLayoutY() == 490 || shape.getLayoutX() == 90 && shape.getLayoutY() == 450) {
                    openWindow("Female");
                } else if (shape.getLayoutX() == 130 && shape.getLayoutY() == 330) {
                    openWindow("Female");
                } else if(shape.getLayoutX() == 130 && shape.getLayoutY() == 250) {
                    openWindow("Male");
                } else if (shape.getLayoutX() == 50 && shape.getLayoutY() == 170) {
                    openWindow("Male");
                } else if (shape.getLayoutX() == 450 && shape.getLayoutY() == 210) {
                    openWindow("Male");
                } else if (shape.getLayoutX() == 610 && shape.getLayoutY() == 450 || shape.getLayoutX() == 650 && shape.getLayoutY() == 450) {
                    openWindow("Male");
                }

                break;
            case "Cykelforhandler":
                if (shape.getLayoutX() == 490 && shape.getLayoutY() == 330 || shape.getLayoutX() == 530 && shape.getLayoutY() == 330 || shape.getLayoutX() == 570 && shape.getLayoutY() == 330) {
                    openWindow("Karen-Cykelhandler");
                }

                break;
        }
        questChecker.UpdateQuest();
    }

    void openWindow(String character) {
        try {
            String title = character;
            if (character == "Male")
                title = names.Males();
            else if (character == "Female")
                title = names.Females();
            root = new Group();
            Scene scene = new Scene(root, 700, 600);
            this.scene = scene;
            stage.setTitle(title);
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
            case "Karen-Cykelhandler":
            case "Professor":
            case "Karen-Hovedindgang":
            case "Bryce":
            case "Gutterne":
            case "Karen-Nedenunder":
                text = new Text(getTextFromFile(NPC));
                break;
            case "Male":
                int randomQuote = (int) (Math.random()*15);
                text = new Text(getTextFromFile(String.valueOf(randomQuote)));
                break;
            case "Female":
                randomQuote = (int) (Math.random()*15);
                text = new Text(getTextFromFile(String.valueOf(randomQuote)));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + NPC);
        }

        text.setX(20); text.setY(40);
        text.setFont(new Font(20));
        root.getChildren().add(text);
    }
    String getTextFromFile(String NPC){
        StringBuilder text = new StringBuilder();
        try {
            File file = new File("src/main/java/udtalelser.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                text.append(fileReader.nextLine());
                text.append("\n");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        int start = text.indexOf("</Start: " + NPC + "/>");
        int end = text.indexOf("</End: " + NPC + "/>");
        return text.substring(start+ NPC.length()+11, end);
    }

    void closeText() {
        try {
            scene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.T || keyEvent.getCode() == KeyCode.ESCAPE)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}