package com.example.gui;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Collision {
    ArrayList<Rectangle> collisionContainer = new ArrayList<Rectangle>();

    void addCollisionVertically(int startX, int startY, int Width, int Height) {
        collisionContainer.add(new Rectangle(startX, startY, Width, Height));
    }
    void addCollisionHorizontally(int startX, int startY, int Width, int Height) {
        collisionContainer.add(new Rectangle(startX, startY, Width, Height+150));
    }

    boolean checkColliisonY(double yAxis, double xAxis) {
        boolean checker = false;
        for (int i = 0; i < collisionContainer.size(); i++) {
            if(xAxis > collisionContainer.get(i).getX()-40 && xAxis <= collisionContainer.get(i).getWidth()+40) {
                if(yAxis > collisionContainer.get(i).getY()-40 && yAxis <= collisionContainer.get(i).getHeight()+40) {
                    System.out.println("collision");
                    checker = true;
                }
            }
        }
        return checker;
    }

    boolean checkColliisonX(double xAxis, double yAxis) {
        boolean checker = false;
        for(int i = 0; i < collisionContainer.size(); i++) {
            if(yAxis > collisionContainer.get(i).getY()-40 && yAxis <= collisionContainer.get(i).getHeight()+40){
                if(xAxis > collisionContainer.get(i).getX()-40 && xAxis <= collisionContainer.get(i).getWidth()+40){
                    System.out.println("collision");
                    checker = true;
                }
            }
        }
        return checker;
    }
}
