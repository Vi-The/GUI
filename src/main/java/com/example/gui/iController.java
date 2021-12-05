package com.example.gui;

import javafx.event.ActionEvent;

public interface iController{
    void start(ActionEvent event);
    void addCollision();
    int STANDARD_LENGTH = 40;
    Collision collision = Keylistener.collision;
}