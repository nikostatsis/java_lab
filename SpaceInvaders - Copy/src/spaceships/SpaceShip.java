package spaceships;

import javax.swing.ImageIcon;
import java.awt.Image;
import main.MainClass;

import spaceships_laserguns.Lasergun;

import java.awt.Color;

/**

Abstract class representing a generic spaceship that implements the Navigation interface
*/
abstract public class SpaceShip implements Navigation {

	// Instance variables
	protected String SpaceShipName; // Name of the spaceship
	protected ImageIcon SpaceShipImageIcon; // ImageIcon representing the spaceship
	protected int xPace; // The pace at which the spaceship moves horizontally
	protected int yPace; // The pace at which the spaceship moves vertically
	protected int xcord; // X coordinate of the spaceship
	protected int ycord; // Y coordinate of the spaceship
	public Lasergun gun; // The spaceship's laser gun

	/**
    Constructor for the Spaceship class
    @param clr The color of the spaceship's laser
    */
    SpaceShip(Color clr) {
    	gun = new Lasergun(clr);
    }

    /**
    Moves the spaceship up and handles out of bounds cases
    @return The new Y coordinate of the spaceship
    */
    @Override
    public int moveUP() {
	    ycord -= yPace;
	    if ("ENEMY".equals(SpaceShipName)) {
	    	if (ycord >= MainClass.cosmosHeight - MainClass.spaceShipHeight) {
	    			System.out.println("out of bounds");
	    			ycord = MainClass.cosmosHeight - MainClass.spaceShipHeight;
	    	}
	    } else if (ycord <= MainClass.yOffSet) {
	    	System.out.println("out of bounds");
	    	ycord = MainClass.yOffSet;
	    }
    return ycord;
    }

/**
    Moves the spaceship down and handles out of bounds cases
    @return The new Y coordinate of the spaceship
    */
    @Override
    public int moveDOWN() {
	    ycord += yPace;
	    if ("ENEMY".equals(SpaceShipName)) {
	    	if (ycord <= MainClass.yOffSet + MainClass.spaceShipHeight) {
	    		System.out.println("out of bounds");
	    		ycord = MainClass.spaceShipHeight + MainClass.yOffSet;
	    	}
	    } else if (ycord >= MainClass.cosmosHeight - MainClass.spaceShipHeight) {
	    	System.out.println("out of bounds");
	    	ycord = MainClass.cosmosHeight - MainClass.spaceShipHeight - MainClass.yOffSet;
	    }
    return ycord;
    }

/**
    Moves the spaceship left and handles out of bounds cases
    @return The new X coordinate of the spaceship
    */
    @Override
    public int moveLEFT() {
	    xcord -= xPace;
	    if ("ENEMY".equals(SpaceShipName)) {
	    	if (xcord >= MainClass.cosmosWidth) {
	    		System.out.println("out of bounds");
	    		xcord = MainClass.cosmosWidth;
	    	}
	    } else if (xcord <= 0) {
	    	System.out.println("out of bounds");
	    	xcord = 0;
	    }
    return xcord;
    }

    /**
    Moves the spaceship right and handles out of bounds cases
    @return The new X coordinate of the spaceship
    */
    @Override
    public int moveRIGHT() {
	    xcord += xPace;
	    if ("ENEMY".equals(SpaceShipName)) {
	    	if (xcord <= 0) {
	    		System.out.println("out of bounds");
	    		xcord = 0;
	    	}
	    } else if (xcord >= MainClass.cosmosWidth - MainClass.spaceShipWidth) {
	    	System.out.println("out of bounds");
	    	xcord = MainClass.cosmosWidth - MainClass.spaceShipWidth;
	    }
    return xcord;
    }

 // Method that returns a string representation of the spaceship's name and coordinates.
    @Override
    public String toString() {
        return SpaceShipName + " Xcord:" + xcord + " Ycords:" + ycord;
    }

    // Method that returns the spaceship's image icon.
    public ImageIcon getIcon() {
        return SpaceShipImageIcon;
    }

    // Method that returns the spaceship's x coordinate.
    public int getX() {
        return xcord;
    }

    // Method that returns the spaceship's y coordinate.
    public int getY() {
        return ycord;
    }

    // Abstract method that should be implemented by subclasses to return the spaceship's image.
    public abstract Image getImg();
}
