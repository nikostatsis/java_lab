// Import necessary classes
package spaceships_laserguns;
import java.awt.Color;
import java.util.LinkedList;

// Define a class for a Lasergun
public class Lasergun {
	
	// Declare instance variables
	public Color lasercolor;
	public LinkedList<Laser> laserShootersLinkedList=new LinkedList<Laser>();
	
	// Constructor for the Lasergun class
	public Lasergun(Color lasercolor){
		// Set the color of the laser gun
		this.lasercolor=lasercolor;
	}
	
	// Method for firing the laser gun
	public void fire(int x, int y) {
		// Add a new laser to the linked list of lasers at the specified coordinates
		laserShootersLinkedList.add(laserShootersLinkedList.size(),new Laser(x,y));
	}
}

