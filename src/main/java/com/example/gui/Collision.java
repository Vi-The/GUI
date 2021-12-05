package com.example.gui;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Collision {
    private boolean disableCollision;
    private final ArrayList<Rectangle> collisionContainer = new ArrayList<Rectangle>();

    void addCollision(int startX, int startY) {
        collisionContainer.add(new Rectangle(startX, startY, iController.STANDARD_LENGTH, iController.STANDARD_LENGTH));
    }
    boolean checkCollision_Yaxis(double dir, double noChange) {
        boolean checker = false;
        for (Rectangle rectangle : collisionContainer) {
            if (dir == rectangle.getY() && noChange == rectangle.getX()) {
                checker = true;
            }
        }
        return !checker;
    }
    boolean checkCollision_Xaxis(double dir, double noChange) {
        boolean checker = false;
        for (Rectangle rectangle : collisionContainer) {
            if (dir == rectangle.getX() && noChange == rectangle.getY()) {
                checker = true;
            }
        }
        return !checker;
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
