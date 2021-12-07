package com.example.gui;

public class QuestChecker {
    public boolean talkedToKaren = false;
    public boolean boughtCoffee = false;
    public boolean talkedToProfessor = false;
    public boolean talkedToBryce = false;
    public boolean boughtBeer = false;
    public boolean boughtBikeHelmet = false;

    public String CoffeeQ = "Gå til kantinen og køb kaffe";
    public String ProfessorQ = "Gå ind i klasselokalet og snak med professoren";
    public String BryceQ = "Gå ned til Bryce i fitnesslokalet";
    public String BarQ = "Mød dine venner i Nedenunder";
    public String BikeQ = "Gå med Karen til Cykelhandleren eller tag hjem";
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
        if(boughtBeer)
            CurrentQ = BikeQ;
    }
}
