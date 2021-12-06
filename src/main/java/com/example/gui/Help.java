package com.example.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Help {

    Scene scene;
    private Group root;
    private Stage stage = new Stage();
    ArrayList<String> help = new ArrayList<String>();

    Help(){
        help.add("E: Opens and closes players inventory");
        help.add("M: Shows players coordinates");
        help.add("R: Opens and closes shops");
        help.add("N: Shows location");
        help.add("H: Shows this menu");
        help.add("\n");
        help.add("   Quest:   ");
        help.add("1. Køb en kaffe");
        help.add("2. Tag til foreslæsningen");
        help.add("3. Tag ned og træn i SDU Fitness");
        help.add("4. Smut forbi Nedenunder");
        help.add("5. Gå ned til cykelhandleren med Karen");
    }



    void openHelp() {
        try {
            root = new Group();
            Scene scene = new Scene(root, 450, 320);
            this.scene = scene;
            stage.setTitle("Help");
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
                if(keyEvent.getCode() == KeyCode.H)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showHelp() {
        int posX = 20; int posY = 30;
        for(int i = 0; i < help.size(); i ++)
        {
            Text text = new Text(help.get(i));
            text.setX(posX); text.setY(posY);
            text.setFont(new Font(20));
            root.getChildren().add(text);
            posY += 25;
            if(posY == 300){
                posX += 110; posY = 30;
            }
        }

    }

    void addHelp(String item) {
        help.add(item);
    }

}
