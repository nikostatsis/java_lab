package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import spaceships.*;

/**

This class represents the game play screen where the actual gameplay occurs.

It extends JPanel and implements KeyListener.
*/
public class GamePlayScreen extends JPanel implements KeyListener{
private static final long serialVersionUID = 1L;
	
	private SpaceShip userSpaceShip;
	private SpaceshipENEMY enemySpaceShip;
	
	/**

    Constructs a new GamePlayScreen object.
    Initializes the panel and creates a daemon for repainting the panel at regular intervals.
    */
	GamePlayScreen(){   	
     	addKeyListener(this);
    	this.setVisible(true); 
    	this.setBackground( Color.BLACK );
    	createDaemon();
    }
	/**

    Creates a daemon for repainting the panel at regular intervals.
    */
	private void createDaemon() {
		Timer timer = new Timer();
        TimerTask task = new monitorDeamonGame();  
        timer.schedule(task, 100, 100);
    }

  //  An inner class representing the daemon for repainting the panel at regular intervals.
 
    class monitorDeamonGame extends TimerTask {
        //The run method for the daemon.
        //Repaints the panel every time the timer expires.
	        public void run(){
	        repaint();
	        }
        }

/**

    The overridden method for painting the component.
    Paints the user's spaceship, enemy spaceship, and the laser shootings.
    */
    @Override
    public void paintComponent (Graphics g) {
	    super.paintComponent(g);
	    enemySpaceShip.huntUserSpaceShip(userSpaceShip);
	    userSpaceShip.getIcon().paintIcon(this, g, userSpaceShip.getX(), userSpaceShip.getY());
	    enemySpaceShip.getIcon().paintIcon(this, g, enemySpaceShip.getX(), enemySpaceShip.getY());
	    showLaserShootings(g);
    }

/**

    Displays the laser shootings on the panel.
    */
    private void showLaserShootings(Graphics g) {
	    userSpaceShip.gun.laserShootersLinkedList.forEach((tmp) -> {
		    g.setColor(userSpaceShip.gun.lasercolor);
		    g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y-15);
		    tmp.y=tmp.y-15; //move the line up
	    });
	    enemySpaceShip.gun.laserShootersLinkedList.forEach((tmp) -> {
		    g.setColor(enemySpaceShip.gun.lasercolor);
		    g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y+15);
		    tmp.y=tmp.y+15;
	    });
    }

/**

    The overridden method for handling the key press events.

    Moves the user's spaceship, fires laser on space key press, and navigates to the next screen on 'B' and 'UP' key press.
    */
    @Override
    public void keyPressed (KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_UP) userSpaceShip.moveUP();
	    if (e.getKeyCode() == KeyEvent.VK_DOWN) userSpaceShip.moveDOWN();
	    if (e.getKeyCode() == KeyEvent.VK_LEFT) userSpaceShip.moveLEFT();
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT) userSpaceShip.moveRIGHT();
	    if (e.getKeyCode() == KeyEvent.VK_SPACE) userSpaceShip.gun.fire(userSpaceShip.getX(),userSpaceShip.getY());
	    if (e.getKeyCode() == KeyEvent.VK_B)SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
	    if (e.getKeyCode() == KeyEvent.VK_UP && userSpaceShip.getY()==30)SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);;
	
	    this.repaint();
    }

	@Override
	public void keyReleased (KeyEvent e) {} 
	
	@Override
	public void keyTyped (KeyEvent e){}
	
	void setUserSpaceShip(SpaceShip usel) {
		userSpaceShip=usel;
		enemySpaceShip= new SpaceshipENEMY();
	}

}
