package com.example.gui;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Keylistener {
    private final boolean shopChecker;
    private final String roomString;
    private Rectangle shape;
    static Collision collision = new Collision();
    static Inventory inventory = new Inventory();
    private final Shop shop = new Shop();

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
            case H -> help();
            case E -> openInventory();
            case R -> {if(shopChecker){shop.displayShop(shape, roomString);}}
            case M -> System.out.println("Player location: X: "+shape.getLayoutX()+" Y: "+shape.getLayoutY());
            case N -> System.out.println("Current room: "+roomString);
        }
    }
    public void help() {
        System.out.println("E: Opens and closes players inventory");
        System.out.println("M: Shows players coordinates");
        System.out.println("R: Opens and closes shops");
        System.out.println("N: Shows location");
        System.out.println("H: Shows this menu");
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
}