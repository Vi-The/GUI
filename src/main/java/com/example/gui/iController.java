package com.example.gui;

import javafx.event.ActionEvent;

public interface iController{ //Sørger for at alle controlleres har disse metoder og attributter.
    void start(ActionEvent event);
    void addCollision();
    int STANDARD_LENGTH = 40; //Da vi lavede collisions første gang så skrev vi 40 og længden af collisions, men nu kan vi skrive standard_lenght i stedet. Behøver ikke være her.
    Collision collision = Keylistener.collision;
    QuestChecker questChecker = new QuestChecker();
}