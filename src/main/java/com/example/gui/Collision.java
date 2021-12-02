package com.example.gui;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class Collision {
    private boolean disableCollision;
    private AnchorPane currentRoom;
    ArrayList<Rectangle> collisionContainer = new ArrayList<Rectangle>();
    HashMap<AnchorPane, ArrayList<Rectangle>> collisionMap = new HashMap<>();

    void addCollision(int startX, int startY, int Width, int Height) {
        collisionContainer.add(new Rectangle(startX, startY, Width, Height));
    }
    boolean checkCollisionY(double dir, double noChange) {
        boolean checker = false;
        for (Rectangle rectangle : collisionContainer) {
            if (dir == rectangle.getY() && noChange == rectangle.getX()) {
                checker = true;
            }
        }
        return !checker;
    }
    boolean checkCollisionX(double dir, double noChange) {
        boolean checker = false;
        for (Rectangle rectangle : collisionContainer) {
            if (dir == rectangle.getX() && noChange == rectangle.getY()) {
                checker = true;
            }
        }
        return !checker;
    }

    void showCollisionAreas(Group group) {
        for (Rectangle rectangle : collisionContainer) {
            group.getChildren().add(rectangle);
        }
    }

    void showCollisionAreas(AnchorPane group) {
        for (Rectangle rectangle : collisionContainer) {
            group.getChildren().add(rectangle);
        }
    }

    void setDisableCollision(boolean notCollision) {
        disableCollision = notCollision;
    }
    void removeCollision() {
        collisionContainer.clear();
    }
}
