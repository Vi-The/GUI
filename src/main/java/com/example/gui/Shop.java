package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Shop {
    private Rectangle shape;
    private String shopName;
    private Buttonlistener buttonlistener = new Buttonlistener();
    private Group root;
    Stage stage = new Stage();
    Scene shopScene;
    ArrayList<String> shopItems = new ArrayList<>();


    void displayShop(Rectangle shape, String shopName) {
        this.shopName = shopName;
        this.shape = shape;
        if ((shape.getLayoutX() == 90 && shape.getLayoutY() == 170) || (shape.getLayoutX() == 130 && shape.getLayoutY() == 170)) {
            openShop();
        }
        else if(shape.getLayoutX() == 450 && shape.getLayoutY() == 330){
            openShop();
        }
        else if(shape.getLayoutX() == 370 && shape.getLayoutY() == 210) {
            openShop();
        }
    }

    void openShop() {
        try {
            root = new Group();
            Scene scene = new Scene(root, 500, 300);
            this.shopScene = scene;
            stage.setTitle(shopName + " Køb");
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
                if (keyEvent.getCode() == KeyCode.R) {
                    shopItems.clear();
                    stage.close();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadShop(String shop) {
        switch (shop) {
            case "Kantine":
                shopItems.add("Kaffe");
                shopItems.add("Sandwich");
                shopItems.add("Energi Drik");
                shopItems.add("Kage");
                break;
            case "Cykelforhandler":
                shopItems.add("Cykelhjelm");
                shopItems.add("Kæde");
                shopItems.add("Cykellås");
                shopItems.add("Gul vest");
                shopItems.add("Lygter");
                break;
            case "Nedenunder":
                shopItems.add("Odense Pilsner");
                shopItems.add("Odense Classic");
                shopItems.add("Mokai");
                shopItems.add("Cult Shaker");
                shopItems.add("Flügel");
                shopItems.add("Pepsi Max");
                shopItems.add("Faxe Kondi");
                shopItems.add("Vodka Redbull");
                break;
        }
        showItems();
    }

    void showItems() {
        int posX = 50;
        int posY = 50;
        for (int i = 0; i < shopItems.size(); i++) {
            Button button = new Button();
            button.setText(shopItems.get(i));
            button.setLayoutX(posX);
            button.setLayoutY(posY);
            button.setMinHeight(20);
            button.setMinWidth(150);
            button.setOnAction(e -> buttonlistener.getActionForButton(button.getText(),root));
            root.getChildren().add(button);
            posY += 30;
        }
    }
}
