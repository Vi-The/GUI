package com.example.gui;

public class QuestChecker {
    public boolean talkedToKaren = false;
    public boolean boughtCoffee = false;
    public boolean talkedToProfessor = false;
    public boolean talkedToBryce = false;
    public boolean talkedToFriends = false;
    public boolean boughtBikeHelmet = false;

    private String CoffeeQ = "Gå til kantinen og køb kaffe";
    private String ProfessorQ = "Gå ind i klasselokalet og snak med professoren";
    private String BryceQ = "Gå ned til Bryce i fitnesslokalet";
    private String BarQ = "Mød dine venner i Nedenunder";
    private String BikeQ = "Gå med Karen til Cykelhandleren eller tag hjem";
    private String HomeQ = "Gå tilbage til Hovedindgangen til SDU";
    public static String CurrentQ = "Snak med Karen og gå ind på Gydehutten";

    void UpdateQuest(){
        if(talkedToKaren)
            CurrentQ = CoffeeQ;
        if(boughtCoffee)
            CurrentQ = ProfessorQ;
        if(talkedToProfessor)
            CurrentQ = BryceQ;
        if(talkedToBryce)
            CurrentQ = BarQ;
        if(talkedToFriends)
            CurrentQ = BikeQ;
        if(boughtBikeHelmet)
            CurrentQ = HomeQ;
    }
}
