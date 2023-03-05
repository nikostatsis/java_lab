package spaceships;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Random;
import main.MainClass;

//This class represents a specific type of Spaceship called SpaceshipENEMY.
public class SpaceshipENEMY extends SpaceShip{
	
	// The image of the spaceship.
	public static Image img;
	
	// Static initialization block to load and scale the spaceship image.
	static {
		try {
			// Loads the spaceship image from a file.
			SpaceshipENEMY.img= ImageIO.read(MainClass.class.getResource("../images/ENEMY.png"));
			
			// Scales the spaceship image to the desired width and height.
			SpaceshipENEMY.img =SpaceshipENEMY.img.getScaledInstance(MainClass.spaceShipWidth,MainClass.spaceShipHeight, 0);
		}catch(Exception e) {
			// Prints an error message if the image cannot be loaded or scaled.
			System.out.println(e);
		}
	}
	
	// Constructor for the SpaceshipENEMY class.
	public SpaceshipENEMY(){
		// Calls the parent class constructor and sets the color of the spaceship.
		super(Color.MAGENTA);
		
		// Sets the spaceship's image icon.
		super.SpaceShipImageIcon=new ImageIcon(SpaceshipENEMY.img);
		
		// Sets the name of the spaceship.
		SpaceShipName="ENEMY";
		
		// Sets the X and Y paces of the spaceship.
		xPace=-15;
		yPace=-15;
		
		// Sets the initial coordinates of the spaceship.
		xcord=MainClass.cosmosWidth-MainClass.spaceShipWidth;
		ycord=MainClass.yOffSet;
	}
	
	// Method to hunt the user's spaceship.
	public void huntUserSpaceShip(SpaceShip s) {
		// Creates a new random number generator.
		Random rand =new Random();
		
		// Generates a random number between 0 and 9.
 	int mv = rand.nextInt(10);
 	
 	// Fires the gun if the random number is 0.
 	if(mv == 0)this.gun.fire(this.getX(),this.getY()+100);
 	
 	// Moves left if the user's spaceship is to the right of the enemy spaceship.
 	if(s.xcord>this.xcord)this.xcord=this.moveLEFT();
 	
 	// Moves right if the user's spaceship is to the left of the enemy spaceship.
 	else this.xcord=this.moveRIGHT();
 	
 	// Generates a random number between 0 and 3.
		int nextmove=rand.nextInt(4);
		
		// Moves left if the random number is 2.
		if(nextmove==2)this.moveLEFT();
		
		// Moves right if the random number is 3.
		if(nextmove==3)this.moveRIGHT();
	}
	
	// Overrides the getImg() method to return the spaceship image.
 @Override
 public Image getImg() {
     return img;
 }

}

