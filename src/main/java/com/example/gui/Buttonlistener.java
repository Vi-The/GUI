package com.example.gui;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Buttonlistener {

    private final Inventory inventory = Keylistener.inventory; //Sørger for at inventoryet er det samme.
    void getActionForButton(String button, Group group) { // tilføjer en handling til vores knap i shoppen.
        inventory.addInv(button);
        Rectangle rectangle = new Rectangle(375,240,100,20); //Dovent fix til at når vi har købt noget, så tilføjer den en firkant og tilføjer ny tekst. Som en stor sandwich
        rectangle.setFill(Color.WHITE);
        group.getChildren().add(rectangle); //Tilføjer firkant til den specifikke group
        Text text = new Text("Du har købt 1 "+button);
        text.setX(300); text.setY(250);
        group.getChildren().add(text);
    }
}
