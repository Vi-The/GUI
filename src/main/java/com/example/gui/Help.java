package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Help {

    Scene scene;
    private Group root;
    private final Stage stage = new Stage();
    ArrayList<String> help = new ArrayList<String>();

    Help() {
        help.add("E: Åbner og lukker Samuels inventarliste");
        help.add("M: Viser et kort over spillet");
        help.add("R: Åbner og lukker dine købsmuligheder");
        help.add("N: Viser hvilket rum du befinder dig i");
        help.add("H: Åbner denne hjælpe menu");
        help.add("T: Sådan taler du med folk");
        help.add("\n");
        help.add("   Opgaver:   ");
        help.add(QuestChecker.CurrentQ);
    }

    void openHelp() {
        try {
            root = new Group();
            Scene scene = new Scene(root, 450, 420);
            this.scene = scene;
            stage.setTitle("Hjælpemenu");
            stage.setScene(scene);
            showHelp();
            stage.show();
            closeHelp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void closeHelp() {
        try {
            scene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.H)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showHelp() {
        int posX = 20;
        int posY = 40;
        for (int i = 0; i < help.size(); i++) {
            Text text = new Text(help.get(i));
            text.setX(posX);
            text.setY(posY);
            text.setFont(new Font(20));
            root.getChildren().add(text);
            posY += 25;
            if (posY == 300) {
                posX += 110;
                posY = 40;
            }
        }
    }
}