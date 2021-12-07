package com.example.gui;

import com.example.domain.Collision;
import com.example.domain.Keylistener;
import javafx.event.ActionEvent;

public interface iController{
    void start(ActionEvent event);
    void addCollision();
    int STANDARD_LENGTH = 40;
    Collision collision = Keylistener.collision;
}