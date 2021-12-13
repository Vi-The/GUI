package com.example.gui;

public class Names { //Laver et array af navne og returer et tilfældigt navn.
    String Females() {
        String[] names = {
                "Emma",
                "Alma",
                "Freja",
                "Clara",
                "Agnes",
                "Anna",
                "Sofia",
                "Ella",
                "Karla",
                "Ida",
                "Nora",
                "Ellie",
                "Josefine",
                "Luna",
                "Olivia",
        };
        return names[(int) (Math.random()* names.length-1)];
    }
    String Males() {
        String[] names = {
                "William",
                "Oscar",
                "Alfred",
                "Oliver",
                "Carl",
                "Lucas",
                "Noah",
                "Valdemar",
                "Malthe",
                "Aksel",
                "Elias",
                "Emil",
                "Arthur",
                "August",
                "Magnus",
        };
        return names[(int) (Math.random()* names.length-1)];
    }
}
