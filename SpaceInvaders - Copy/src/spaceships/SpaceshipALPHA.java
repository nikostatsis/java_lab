package spaceships;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import main.MainClass;


public class SpaceshipALPHA extends SpaceShip{
	// Load image for this spaceship type
	public static Image img;
	static {
		try {
			SpaceshipALPHA.img= ImageIO.read(MainClass.class.getResource("../images/ALPHA.png"));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// Constructor to initialize the spaceship properties
	public SpaceshipALPHA(){
		super(Color.RED);
		SpaceShipName="ALPHA";
		super.SpaceShipImageIcon=new ImageIcon(SpaceshipALPHA.img);
		xPace=10;
		yPace=10;
		xcord=0;
		ycord=(MainClass.cosmosHeight-MainClass.spaceShipHeight)-MainClass.yOffSet;
	}
	
    @Override
    public Image getImg() {
        return img;
    }
}
