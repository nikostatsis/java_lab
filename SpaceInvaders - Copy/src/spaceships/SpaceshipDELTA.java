package spaceships;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.MainClass;

public class SpaceshipDELTA extends SpaceShip{
	public static Image img;
	// Load image for SpaceshipDELTA
	static {
		try {
			SpaceshipDELTA.img= ImageIO.read(MainClass.class.getResource("../images/DELTA.png"));
			
		}catch(Exception e) {System.out.println(e);}
	}

	public SpaceshipDELTA(){
		super(Color.GREEN);
		super.SpaceShipImageIcon=new ImageIcon(SpaceshipDELTA.img);
		SpaceShipName="DELTA";
		xPace=40;
		yPace=40;
		xcord=0;
		ycord=(MainClass.cosmosHeight-MainClass.spaceShipHeight)-MainClass.yOffSet;
	}
	
    @Override
    public Image getImg() {
        return img;
    }

}

