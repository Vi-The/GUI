package com.example.gui;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Keylistener {
    private Rectangle shape;
    private AnchorPane scene;

    Keylistener(AnchorPane scene)
    {
        this.scene = scene;
    }

    public void checkKeyInput(KeyEvent event, Rectangle shape)
    {
        this.shape = shape;
        switch (event.getCode()){
            case W -> moveUp();
            case S -> moveDown();
            case A -> moveLeft();
            case D -> moveRight();
            case M -> System.out.println(shape.getLayoutX()+ " " + shape.getLayoutY());
        }
    }
    public void moveUp(){
        shape.setLayoutY(shape.getLayoutY()-40);
    }
    public void moveDown(){
        shape.setLayoutY(shape.getLayoutY()+40);
    }
    public void moveLeft(){
        shape.setLayoutX(shape.getLayoutX()-40);
    }
    public void moveRight(){
        shape.setLayoutX(shape.getLayoutX()+40);
    }

}
