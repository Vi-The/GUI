package com.example.gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;

public interface iController{
    Group root = new Group();
    String path = "src/Asset/";
    void start(ActionEvent event);
    void addCollision();
}
