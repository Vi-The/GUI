package com.example.gui;

public class QuestChecker {
    public boolean talkedToKaren = false;
    public boolean boughtCoffee = false;
    public boolean talkedToProfessor = false;
    public boolean talkedToBryce = false;
    public boolean boughtBeer = false;
    public boolean boughtBikeHelmet = false;

    public String CoffeeQ = "Gå til kantinen og køb kaffe";
    public String ProffessorQ = "Gå ind i klasselokalet og snak med professoren";
    public String BryceQ = "Gå ned til Bryce i fitnesslokalet";
    public static String CurrentQ = "Snak med Karen og gå ind på Gydehutten";
   /* public boolean name = false;
    public boolean name = false;
    public boolean name = false;*/
    void UpdateQuest(){
        if(talkedToKaren)
            CurrentQ = CoffeeQ;
        if(boughtCoffee)
            CurrentQ = ProffessorQ;
        if(talkedToProfessor)
            CurrentQ = BryceQ;
    }
}
