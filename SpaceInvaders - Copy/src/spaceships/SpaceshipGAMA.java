package spaceships;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.MainClass;

//This class represents a specific type of Spaceship called SpaceshipGAMA.
public class SpaceshipGAMA extends SpaceShip{
	
	// The image of the spaceship.
	public static Image img;
	
	// Static initialization block to load the spaceship image.
	static {
		try {
			SpaceshipGAMA.img= ImageIO.read(MainClass.class.getResource("../images/GAMA.png"));
		}catch(Exception e) {
			// Prints an error message if the image cannot be loaded.
			System.out.println(e);
		}
	}
	
	// Constructor for the SpaceshipGAMA class.
	public SpaceshipGAMA(){
		// Calls the parent class constructor and sets the color of the spaceship.
		super(Color.YELLOW);
		
		// Sets the name of the spaceship.
		SpaceShipName="GAMA";
		
		// Sets the spaceship's image icon.
		super.SpaceShipImageIcon=new ImageIcon(SpaceshipGAMA.img);
		
		// Sets the X and Y paces of the spaceship.
		xPace=30;
		yPace=30;
		
		// Sets the initial coordinates of the spaceship.
		xcord=0;
		ycord=(MainClass.cosmosHeight-MainClass.spaceShipHeight)-MainClass.yOffSet;
	}
	
	// Overrides the getImg() method to return the spaceship image.
 @Override
 public Image getImg() {
     return img;
 }

}

