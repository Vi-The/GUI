package com.example.gui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Items {
    Parent root;
    private final ArrayList<Rectangle> itemList = new ArrayList<>();
    Items(Parent root){
        this.root = root;
    }
    @FXML
    void placeItem(int posX, int posY, String URL) {
        try {
            Image i = new Image(new FileInputStream(URL));
            Rectangle rectangle = new Rectangle(posX,posY,iController.STANDARD_LENGTH,iController.STANDARD_LENGTH);
            rectangle.setFill(new ImagePattern(i));
            root.getChildrenUnmodifiable().add(rectangle);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
