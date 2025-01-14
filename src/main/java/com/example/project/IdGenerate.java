package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // initializes the current ID to 99
    private static String currentID = "99";

    // empty private constructor
    private IdGenerate() {}

    // returns the currentID variable
    public static String getCurrentId() {
        return currentID;
    }

    // resets the currentID variable to 99
    public static void reset() {
        currentID = "99";
    }

    //generates a new id (incremented by 1).
    public static void generateID(){
        // parses an int out of the String currentID, increments it, and then converts it back to a String
        currentID = "" + (Integer.valueOf(currentID) + 1);
    }
}