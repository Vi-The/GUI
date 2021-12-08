package com.example.gui;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Buttonlistener {

    private final Inventory inventory = Keylistener.inventory;
    void getActionForButton(String button, Group group) {
        inventory.addInv(button);
        Rectangle rectangle = new Rectangle(375,240,100,20);
        rectangle.setFill(Color.WHITE);
        group.getChildren().add(rectangle);
        Text text = new Text("Du har købt 1 "+button);
        System.out.println(text.getText());
        text.setX(300); text.setY(250);
        group.getChildren().add(text);
    }
}
