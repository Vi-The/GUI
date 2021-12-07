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
    QuestChecker questChecker = iController.questChecker;
    String room;

    void openTextbox(Rectangle shape, String room) {
        this.room = room;
        this.shape = shape;

        switch (room) {
            //Lav en if-stamement for positionen af spilleren og bed programmet om at kører openWindow(room)
            case "Hovedindgangen SDU":
                if(shape.getLayoutX() == 570 && shape.getLayoutY() == 410){
                    openWindow("Karen");
                    questChecker.talkedToKaren = true;
                    questChecker.UpdateQuest();
                }
                break;
            case "Gydehutten Nord":
                break;
            case "Kantine":
                break;
            case "Klasselokale":
                if (shape.getLayoutX() == 370 && shape.getLayoutY() == 210) {
                    openWindow("Professor");
                    questChecker.talkedToProfessor = true;
                    questChecker.UpdateQuest();
                }
                break;
            case "Gydehutten Syd":
                break;
            case "Nedenunder":
                break;
            case "Fitness":
                if (shape.getLayoutX() == 130 && shape.getLayoutY() == 410 ) {
                    openWindow("Bryce");
                }
                break;
            case "Cykelforhandler":
                break;
        }
    }

    void openWindow(String character) {
        try {
            String title = character;
            if (character == "Male")
                title = names.Males();
            else if (character == "Female")
                title = names.Females();
            root = new Group();
            Scene scene = new Scene(root, 700, 450);
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
            case "Professor":
            case "Karen":
            case "Bryce":
                text = new Text(getTextFromFile(NPC));
                break;
            case "Male":
                int randomQuote = (int) (1*Math.random()*13);
                text = new Text(getTextFromFile(String.valueOf(randomQuote)));
                break;
            case "Female":
                randomQuote = (int) (1+Math.random()*15);
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