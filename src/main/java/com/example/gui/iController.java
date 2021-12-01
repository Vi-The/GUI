package com.example.gui;

import javafx.event.ActionEvent;
import javafx.scene.Group;

public interface iController{
    Group root = new Group();
    String path = "src/Asset/";
    void start(ActionEvent event);
    //void addImage(Parent root, int posX, int width, int posY, int height, String folderAndImage) throws FileNotFoundException;

}
