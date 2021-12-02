package com.example.gui;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Collision {
    private boolean disableCollision = false;
    ArrayList<Rectangle> collisionContainer = new ArrayList<Rectangle>();

    void addCollision(int startX, int startY, int Width, int Height) {
        collisionContainer.add(new Rectangle(startX, startY, Width, Height));
    }

    boolean checkCollisionY(double dir, double noChange) {
        boolean checker = false;
        for (int i = 0; i < collisionContainer.size(); i++) {
            if(dir == collisionContainer.get(i).getY() && noChange == collisionContainer.get(i).getX()){
                checker = true;
            }
        }
        return checker;
    }
    boolean checkCollisionX(double dir, double noChange) {
        boolean checker = false;
        for (int i = 0; i < collisionContainer.size(); i++) {
            if(dir == collisionContainer.get(i).getX() && noChange == collisionContainer.get(i).getY()){
                checker = true;
            }
        }
        return checker;
    }

    void showCollisionAreas(Group group) {
        for (int i = 0; i < collisionContainer.size(); i++) {
            group.getChildren().add(collisionContainer.get(i));
        }
    }

    void showCollisionAreas(AnchorPane group) {
        for (int i = 0; i < collisionContainer.size(); i++) {
            group.getChildren().add(collisionContainer.get(i));
        }
    }

    void setDisableCollision(boolean notCollision) {
        disableCollision = notCollision;
    }
}
