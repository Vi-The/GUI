package com.example.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Shop {
    private Rectangle shape; //player (Samuel)
    private String shopName; // Navnet på shoppen - som giver os navnet på de rum der har en shop.
    private Buttonlistener buttonlistener = new Buttonlistener(); //Hvis du trykker på en knap, så udfører den en handling. Så hvis vi klikker på et vilkårlig item i shopitem så tilføjer den det til vores inventory.
    private Group root; //Sikrer at vi kunne få fat i children til at tilføje shopmuligheder.
    Stage stage = new Stage(); //Laver et stage / nyt vindue til vores købmuligheder
    Scene shopScene; //Loader vores købsmuligheder ind i vinduet, så fx i kantinen sørger den for at vi kan købe kaffe, kage, energidrik og sandwich.
    ArrayList<String> shopItems = new ArrayList<>(); //Sikrer at vi kan tilføje købsmuligheder en en shop.


    void displayShop(Rectangle shape, String shopName) { //Denne metode viser vores shop, hvis vi står indenfor det rette koordinat. Vi har dog glemt at holde det op i mod shopnavnet. #KendtFejl
        this.shopName = shopName;
        this.shape = shape;
        if ((shape.getLayoutX() == 90 && shape.getLayoutY() == 170) || (shape.getLayoutX() == 130 && shape.getLayoutY() == 170)) { //Kantinens shopkoordinater
            openShop();
        }
        else if(shape.getLayoutX() == 450 && shape.getLayoutY() == 330){ //Bikeshops shopkoordinater
            openShop();
        }
        else if(shape.getLayoutX() == 370 && shape.getLayoutY() == 210) { //Fredagsbarens shopkoordinater
            openShop(); //Hvis man står på koordinaterne kaldes metoden så shoppen åbnes.
        }
    }

    void openShop() { //Metode der åbner vinduet og laver vores shop.
        try {
            root = new Group(); //Group sikrer at hvis vi vil tilføje både knapper, taster osv. så vi har en container der indeholder alle vores komponenter og gør at vi kan kalde denne group/dette objekt hver gang.
            Scene scene = new Scene(root, 500, 300); //Mål på vinduet
            this.shopScene = scene; //Denne shopscene er lig med vores scene så vi kan få fat i den samme scene i alle metoder.
            stage.setTitle(shopName + " Køb"); //Navnet på vinduet.
            stage.setScene(scene); //Sætter scenen
            loadShop(shopName); //Kalder metoden loadshop, finder ud af hvilken shop der er tale om og henter de shopmuligheder.
            stage.show(); //Viser vinduet
            closeShop(); //Kalder metoden closeshop som lukker vinduet når man trykker på r.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void closeShop() { //Hvis vi trykker på r, så rydder den arraylisten og lukker staget.
        try {
            shopScene.setOnKeyPressed(keyEvent -> { //-> = lambda som gør at vi ikke behøver at tjekke for alle keyevents, den ved bare at den skal gå alle ting i arrayet. Tager imod et parameter og returnere en værdi. Ligesom en metode.
                if (keyEvent.getCode() == KeyCode.R) { //Hvis keyinput er R, så lukker den staget.
                    shopItems.clear(); //Rydder arrayet.
                    stage.close();
                }
            }); //Vi har ) her fordi lambda opererer på samme måde som en metode.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadShop(String shop) { //Switch case tjekker om shoppens navn er en af de 3 cases og tilføjer tilhørende shopitems til arraylisten.
        switch (shop) {
            case "Kantine":
                shopItems.add("Kaffe");
                shopItems.add("Sandwich");
                shopItems.add("Energi Drik");
                shopItems.add("Kage");
                break;
            case "Cykelforhandler":
                shopItems.add("Cykelhjelm");
                shopItems.add("Kæde");
                shopItems.add("Cykellås");
                shopItems.add("Gul vest");
                shopItems.add("Lygter");
                break;
            case "Nedenunder":
                shopItems.add("Odense Pilsner");
                shopItems.add("Odense Classic");
                shopItems.add("Mokai");
                shopItems.add("Cult Shaker");
                shopItems.add("Flügel");
                shopItems.add("Pepsi Max");
                shopItems.add("Faxe Kondi");
                shopItems.add("Vodka Redbull");
                break;
        }
        showItems();
    }

    void showItems() { //Viser knapperne. Bestemmer hvordan de skal se ud med størrelse og position via et for-loop.
        int posX = 50;
        int posY = 50;
        for (int i = 0; i < shopItems.size(); i++) {
            Button button = new Button();
            button.setText(shopItems.get(i));
            button.setLayoutX(posX);
            button.setLayoutY(posY);
            button.setMinHeight(20);
            button.setMinWidth(150);
            button.setOnAction(e -> buttonlistener.getActionForButton(button.getText(),root)); //Gør at når man trykker på knappen går den ind i buttonlistner og tilføjer metoden til knappens action. Hver gang vi trykker på knappen så finder den ud af hvilken action den skal foretage sig.
            root.getChildren().add(button); //Tilføjer knappen til gruppen.
            posY += 30; //For at knapperne ikke står oven i hinanden.
        }
    }
}
