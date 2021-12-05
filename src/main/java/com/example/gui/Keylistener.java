package com.example.gui;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Keylistener {
    private boolean shopChecker;
    private String roomString;
    private Rectangle shape;
    static Collision collision = new Collision();
    private final Inventory inventory = new Inventory();
    private final Shop shop = new Shop();

    Keylistener(AnchorPane scene, boolean shop, String roomString)
    {
        this.roomString = roomString;
        this.shopChecker = shop;
    }

    public void checkKeyInput(KeyEvent event, Rectangle shape)
    {
        this.shape = shape;
        switch (event.getCode()){
            case W -> moveUp();
            case S -> moveDown();
            case A -> moveLeft();
            case D -> moveRight();
            case M -> System.out.println("X: "+shape.getLayoutX()+" Y: "+shape.getLayoutY());
            case I -> openInventory();
            case K -> {if(shopChecker){shop.displayShop(shape, roomString);}}
        }
    }
    public void moveUp(){
        if(collision.checkCollision_Yaxis(shape.getLayoutY() - 40, shape.getLayoutX()))
            shape.setLayoutY(shape.getLayoutY()-40);
    }
    public void moveDown(){
        if(collision.checkCollision_Yaxis(shape.getLayoutY() + 40, shape.getLayoutX()))
            shape.setLayoutY(shape.getLayoutY()+40);
    }
    public void moveLeft(){
        if(collision.checkCollision_Xaxis(shape.getLayoutX() - 40, shape.getLayoutY()))
            shape.setLayoutX(shape.getLayoutX()-40);
    }
    public void moveRight(){
        if(collision.checkCollision_Xaxis(shape.getLayoutX() + 40, shape.getLayoutY()))
            shape.setLayoutX(shape.getLayoutX()+40);
    }

    public void openInventory() {
        try {
            inventory.openInv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}