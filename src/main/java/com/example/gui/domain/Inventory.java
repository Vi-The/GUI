package com.example.gui.domain;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Inventory {

    Scene scene;
    private Group root;
    private Stage stage = new Stage();
    ArrayList<String> inventory = new ArrayList<String>();

    Inventory(){
        inventory.add("Student ID");
        inventory.add("Books");
        inventory.add("Phone");
        inventory.add("Laptop");
    }

    void openInv() {
        try {
            root = new Group();
            Scene scene = new Scene(root,450,300);
            this.scene = scene;
            stage.setTitle("Inventory");
            stage.setScene(scene);
            showInv();
            stage.show();
            closeInv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void closeInv() {
        try {
            scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.E)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showInv() {
        int posX = 20; int posY = 25;
        for(int i = 0; i < inventory.size(); i ++)
        {
            Text text = new Text(inventory.get(i));
            text.setX(posX); text.setY(posY);
            text.setFont(new Font(20));
            root.getChildren().add(text);
            posY += 25;
            if(posY == 300){
                posX += 110; posY = 25;
            }
        }
    }
    void addInv(String item) {
        inventory.add(item);
    }
    void removeInv(String item) {
        inventory.remove(item);
    }
}
