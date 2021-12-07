package com.example.gui.presentation;

import com.example.gui.domain.Collision;
import com.example.gui.domain.Keylistener;
import javafx.event.ActionEvent;

public interface iController{
    void start(ActionEvent event);
    void addCollision();
    int STANDARD_LENGTH = 40;
    Collision collision = Keylistener.collision;
}