package com.example.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {
    @FXML
    Button Startbutton; //Vi laver en knap med navnet/fxid: startbutton
    @FXML
    Button Featured; //Vi laver en knap med navnet/fxid: featured
    //metode - er bundet til startknappen og den åbner et nyt vindue som starter spillet.
    public void clickStart() throws Exception { //throws Exception sørger får, at hvis vi får en fejlmelding, skriver den det til os i terminalen og viser hvor fejlen er.
        Parent root = FXMLLoader.load(getClass().getResource("OUTSIDESDU.fxml")); //Starter en ny fxml fil. Henter koden fra filen i getResources - her OutsideSDU.
        Stage window = (Stage) Startbutton.getScene().getWindow(); // Stage = vindue. Linker til den nye fxml fil. Kobler sig til vores startknap.
        window.setScene(new Scene(root, 700, 700)); // målene på vores vindue. Sætter scenen med det den får fra rooten og så med de mål vi definerer.
        window.setTitle("Hovedindgangen SDU"); //Titlen på vinduet.
        window.setResizable(false); //Sørger for vi ikke kan trække i vinduet.
    }
    public void clickFeatured() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Featured.fxml"));
        Stage window = (Stage) Startbutton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 700));
        window.setTitle("Test kaniner");
        window.setResizable(false);
    }

}