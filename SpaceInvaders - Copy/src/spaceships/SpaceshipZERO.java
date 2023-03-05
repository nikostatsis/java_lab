package spaceships;
import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.MainClass;

//The following code defines a class that represents the ZERO spaceship, which extends the abstract SpaceShip class.

public class SpaceshipZERO extends SpaceShip{
	// The image of the ZERO spaceship.
	public static Image img;

	// Static block that loads the image of the ZERO spaceship.
	static {
		try {
			SpaceshipZERO.img= ImageIO.read(MainClass.class.getResource("../images/ZERO.png"));	
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	// Constructor that sets up the ZERO spaceship.
	public SpaceshipZERO(){
		super(Color.PINK);
		SpaceShipName="ZERO";
		super.SpaceShipImageIcon=new ImageIcon(SpaceshipZERO.img);
		xPace=5;
		yPace=5;
		xcord=0;
		ycord=(MainClass.cosmosHeight-MainClass.spaceShipHeight)-MainClass.yOffSet;
	}

	// Method that returns the image of the ZERO spaceship.
	@Override
	public Image getImg() {
	    return img;
	}

}


