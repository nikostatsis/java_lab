// Import necessary classes
package spaceships_laserguns;
import main.MainClass;

// Define a class for a Laser
public class Laser {
	
	// Declare instance variables
	public int x;
	public int y;
	
	// Constructor for the Laser class
	Laser(int x, int y){
		// Set the initial coordinates of the laser
		this.x=x+MainClass.spaceShipWidth/2;
		this.y=y;	
	}
}

