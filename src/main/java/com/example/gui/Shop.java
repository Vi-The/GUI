package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Shop {
    private Rectangle shape;
    private String shopName;
    private AnchorPane scene;
    private Group root;
    Stage stage = new Stage();
    Scene shopScene;
    ArrayList<String> shopItems = new ArrayList<>();


    void displayShop(Rectangle shape, String shopName) {
        this.shopName = shopName;
        this.shape = shape;
        if (shape.getLayoutX() == 450 && shape.getLayoutY() == 330) {
            openShop();
        }
    }

    void openShop() {
        try {
            root = new Group();
            Scene scene = new Scene(root, 500, 300);
            this.shopScene = scene;
            stage.setTitle(shopName+" Shop");
            stage.setScene(scene);
            loadShop(shopName);
            stage.show();
            closeShop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void closeShop() {
        try {
            shopScene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.K)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadShop(String shop) {
        switch (shop) {
            case "OutsideSDU":
                shopItems.add("Kaffe");
                shopItems.add("Sandwich");
                shopItems.add("Energi Drik");
                shopItems.add("Kage");
        }
        showItems();
    }
    void showItems() {
        int posX = 50; int posY = 50;
        for(int i = 0; i < shopItems.size(); i ++)
        {
            Text text = new Text(shopItems.get(i));
            text.setX(posX); text.setY(posY);
            text.setFont(new Font(20));
            root.getChildren().add(text);
            posY += 30;
        }
    }
}
