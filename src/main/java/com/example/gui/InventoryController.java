package com.example.gui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class InventoryController {

    Scene scene;
    private Stage stage = new Stage();
    void openInv() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InventoryController.fxml"));
            Scene scene = new Scene(root,250,300);
            this.scene = scene;
            stage.setScene(scene);
            stage.setTitle("Inventory");
            stage.show();
            closeInv();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void closeInv() {
        try {
            scene.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.I)
                    stage.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
