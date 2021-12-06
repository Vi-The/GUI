package com.example.gui;

public class Names {
    String Females() {
        String[] names = {
                "Viktoria",
                "Sofie",
                "Kim",
                "Kiley",
                "Riley",
                "Katleen",
                "Olivia",
                "Emma",
                "Anna",
                "Hanna",
                "Hannah",
                "Emma",
                "Cille",
                "Sille",
                "Zille",
                "Xille",
        };
        return names[(int) (Math.random()*names.length-1)];
    }

    String Males() {
        String[] names = {
                "Harun",
                "Harum",
                "Hassan",
                "Hasan",
                "Bob",
                "Ib",
                "Ole",
                "Bo",
                "Benny",
                "Børge",
                "Lars",
                "Mads",
                "Mazz",
                "Karl",
                "Kim",
                "Nick",
                "Samuel"
        };
        return names[(int) (Math.random()*names.length-1)];
    }
}
