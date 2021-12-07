package com.example.gui;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Keylistener {
    private final boolean shopChecker;
    private final String roomString;
    private Rectangle shape;
    static Collision collision = new Collision();
    static Inventory inventory = new Inventory();
    private final Help help = new Help();
    private final Shop shop = new Shop();
    private final Map map = new Map();
    private final Interaction interaction = new Interaction();

    Keylistener(boolean shop, String roomString)
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
            case H -> openH();
            case E -> openInventory();
            case R -> {if(shopChecker){shop.displayShop(shape, roomString);}}
            case C -> System.out.println("Spillerens lokation: X: "+shape.getLayoutX()+" Y: "+shape.getLayoutY());
            case N -> System.out.println("Nuværende rum: "+roomString);
            case T -> interaction.openTextbox(shape,roomString);
            case M -> openMap();
        }
    }


    private void moveUp(){
        if(collision.checkCollision_Yaxis(shape.getLayoutY() - 40, shape.getLayoutX()))
            shape.setLayoutY(shape.getLayoutY()-40);
    }
    private void moveDown(){
        if(collision.checkCollision_Yaxis(shape.getLayoutY() + 40, shape.getLayoutX()))
            shape.setLayoutY(shape.getLayoutY()+40);
    }
    private void moveLeft(){
        if(collision.checkCollision_Xaxis(shape.getLayoutX() - 40, shape.getLayoutY()))
            shape.setLayoutX(shape.getLayoutX()-40);
    }
    private void moveRight(){
        if(collision.checkCollision_Xaxis(shape.getLayoutX() + 40, shape.getLayoutY()))
            shape.setLayoutX(shape.getLayoutX()+40);
    }

    private void openInventory() {
        try {
            inventory.openInv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void openH () {
        try {
            help.openHelp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void openMap() {
        try {
            map.openMap();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}