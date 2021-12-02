package com.example.gui;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Keylistener {
    private Rectangle shape;
    private AnchorPane scene;
    static Collision collision = new Collision();

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
            case I -> openInventory();
        }
    }
    public void moveUp(){
        if(!collision.checkCollisionY(shape.getLayoutY()-40, shape.getLayoutX()))
            shape.setLayoutY(shape.getLayoutY()-40);
    }
    public void moveDown(){
        if(!collision.checkCollisionY(shape.getLayoutY()+40, shape.getLayoutX()))
            shape.setLayoutY(shape.getLayoutY()+40);
    }
    public void moveLeft(){
        if(!collision.checkCollisionX( shape.getLayoutX()-40, shape.getLayoutY()))
            shape.setLayoutX(shape.getLayoutX()-40);
    }
    public void moveRight(){
        if(!collision.checkCollisionX(shape.getLayoutX()+40, shape.getLayoutY()))
            shape.setLayoutX(shape.getLayoutX()+40);
    }

    public void openInventory() {
        try {
            Inventory inventory = new Inventory();
            inventory.openInv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
