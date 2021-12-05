package com.example.gui;

public class Buttonlistener {

    private Inventory inventory = Keylistener.inventory;
    void getActionForButton(String button) {
        inventory.addInv(button);
    }
}
