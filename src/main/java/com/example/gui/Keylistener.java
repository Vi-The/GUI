package com.example.gui;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Keylistener {
    private final boolean shopChecker; //Tjekker om der er mulighed for at shoppe/købe noget i det rum man befinder sig i.
    private final String roomString; //Navnet på rummet i en stringform, da det var nemmere at bruge som reference.
    private Rectangle shape; //Player (Samuel)
    static Collision collision = new Collision(); //Laver et objekt af klassen collision, så vi kan lave collision i de forskellige rum. Den er static for så har kontrolleren samme collision som keylistner.
    static Inventory inventory = new Inventory(); //Samme princip som med collisions...
    private final Help help = new Help(); //Laver et objekt af help og den er final fordi så kan vi ikke ændre på den. Den endelige help menu.
    private final Shop shop = new Shop(); //Samme som med help
    private final Map map = new Map(); //Samme som help
    private final Interaction interaction = new Interaction(); //Samme princip som help. Sørger for vi kan tale med alle NCP'er. Tjekker om spillerens position er et interaction point med en NCP.

    Keylistener(boolean shop, String roomString) //Konstruktoren har to argumenter. 1. en string som giver navnet på rummet (så når man bruger keylistner så tjekker den om rummet er en shop og 2. er en boolean. Tjekker om der er en shop i det givende rum.
    {
        this.roomString = roomString;
        this.shopChecker = shop;
    }

    public void checkKeyInput(KeyEvent event, Rectangle shape) //Metode som tjekker om det keyinput vi får er et vi bruger. KeyEvent event er en javafx variabel.
    {
        this.shape = shape; //Referer til at det er den shape som vi har defineret længere oppe også er den vi bruger.
        switch (event.getCode()){ //.getCode() gør det nemmere for programmøren at se hvilken knap der er tale om.
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


    private void moveUp(){ //Hvis næste position ikke har en collision, så kan vi rykke opad. Vi bruger - 40 fordi vores player er 40 pixels. Det er en void metode fordi den ikke skal returere noget og det er ikke nødvendigt at de andre klasser kan tilgå den.
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

    private void openInventory() { //Åbner inventory. Vi har sat den i en try catch for at gøre det simplere at kunne læse koden, for ellers skal throwes den samme exception alle steder metoden bruges og så er det svært at finde ud af hvor fejlen er.
        try {
            inventory.openInv();
        } catch (Exception e) {
            e.printStackTrace(); //Er en metode der printer linjenummer og klasse ud, så vi kan finde fejlen.
        }
    }


    private void openH () { //Samme princip som inventory
        try {
            help.openHelp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void openMap() { //Samme princip som inventory
        try {
            map.openMap();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}