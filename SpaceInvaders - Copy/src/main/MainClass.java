package main;

import gui.SpaceFrame;


//The following code defines a main class for a shooting game, which sets up the game's dimensions and launches the game frame.
public class MainClass {

	// Values for the width and height of the game frame and the player's spaceship, as well as the y offset for the spaceship.    public static int cosmosWidth=800;
    public static int cosmosHeight=600;
    public static int cosmosWidth=800;
    public static int spaceShipWidth=100;
    public static int spaceShipHeight=100;
    public static int yOffSet=30;
    // Instance variable to hold the game frame.
    public static SpaceFrame myshootingGame;
    // Main method that creates a new game frame and launches the game.
    public static void main(String[] args) {
    	myshootingGame= new SpaceFrame(cosmosWidth,cosmosHeight);
    }
}
