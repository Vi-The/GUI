package com.example.gui;

public class QuestChecker {
    public boolean talkedToKaren = false;
    public boolean boughtCoffee = false;
    public boolean talkedToProfessor = false;
    public boolean talkedToBryce = false;
    public boolean talkedToFriends = false;
    public boolean boughtBikeHelmet = false;
    public static String CurrentQ = "Snak med Karen og gå ind på Gydehutten";

    void UpdateQuest(){
        String coffeeQ = "Gå i kantinen og køb kaffe fra kantinedamen";
        if(talkedToKaren)
            CurrentQ = coffeeQ;
        String professorQ = "Gå ind i klasselokalet og snak med professoren";
        if(boughtCoffee)
            CurrentQ = professorQ;
        String bryceQ = "Gå ned til Bryce i fitnesslokalet";
        if(talkedToProfessor)
            CurrentQ = bryceQ;
        String barQ = "Mød dine venner i Nedenunder. Snak med dem \n og derefter Karen";
        if(talkedToBryce)
            CurrentQ = barQ;
        String bikeQ = "Gå med Karen til Cykelhandleren eller tag hjem";
        if(talkedToFriends)
            CurrentQ = bikeQ;
        String homeQ = "Gå tilbage til hovedindgangen på SDU";
        if(boughtBikeHelmet)
            CurrentQ = homeQ;
    }
}
