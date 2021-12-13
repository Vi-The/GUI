package com.example.gui;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Collision {
    ArrayList<Rectangle> collisionContainer = new ArrayList<Rectangle>();

    void addCollision(int startX, int startY) { //Metode der tilføjer collisions til arraylisten.
        collisionContainer.add(new Rectangle(startX, startY, iController.STANDARD_LENGTH, iController.STANDARD_LENGTH)); //iController står to gange fordi vi skal bruge både højde og bredde. Ellers tror den det er farver.
    }
    boolean checkCollision_Yaxis(double dir, double noChange) { //Tjekker for collisions på y-aksen
        boolean checker = false;
        for (Rectangle rectangle : collisionContainer) {
            if (dir == rectangle.getY() && noChange == rectangle.getX()) { //dir = den direction vi bevæger os i og noChange er et supportpoint.
                checker = true;
            }
        }
        return !checker;
    }
    boolean checkCollision_Xaxis(double dir, double noChange) { //Tjekker for collisions på x-aksen
        boolean checker = false;
        for (Rectangle rectangle : collisionContainer) {
            if (dir == rectangle.getX() && noChange == rectangle.getY()) {
                checker = true;
            }
        }
        return !checker;
    }

    void showCollisionAreas(AnchorPane group) { //Metode som viser hvor vi har tilføjet collisions. Rent visuelt.
        for (Rectangle rectangle : collisionContainer) {
            group.getChildren().add(rectangle);
        }
    }

    void setDisableCollision(boolean notCollision) { //Hvis vi gerne ville fjerne collisions i et rum.
    }
    void removeCollision() {
        collisionContainer.clear();
    } //Fjerner dem.
}
