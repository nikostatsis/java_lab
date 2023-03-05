package spaceships;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.MainClass;

/**
 * This class represents the Beta spaceship in the game.
 * It extends the SpaceShip class and overrides its methods.
 */
public class SpaceshipBETA extends SpaceShip{
	
	public static Image img;
	
	// Static block to load the spaceship image from resources
	static {
		try {
			SpaceshipBETA.img= ImageIO.read(MainClass.class.getResource("../images/BETA.png"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Constructor for the SpaceshipBETA class.
	 * Sets the initial values for the spaceship's properties.
	 */
	public SpaceshipBETA(){
		super(Color.BLUE);
		super.SpaceShipImageIcon=new ImageIcon(SpaceshipBETA.img);
		SpaceShipName="BETA";
		xPace=20;
		yPace=20;
		xcord=0;
		ycord=(MainClass.cosmosHeight-MainClass.spaceShipHeight)-MainClass.yOffSet;
	}
	
	/**
	 * Overrides the getImg method from the SpaceShip class.
	 * @return The image of the SpaceshipBETA.
	 */
    @Override
    public Image getImg() {
        return img;
    }
}
