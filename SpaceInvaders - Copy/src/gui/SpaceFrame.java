package gui;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
//This class represents the main frame of a space-themed game simulation.
public class SpaceFrame extends JFrame{
	
	// Unique serial version ID for this class.
	private static final long serialVersionUID = 1L;
	
	// The width and height of the frame.
	static int width;
	static int height;
	
	// Three different screens of the game.
	static SelectSpaceShipScreen selectSpaceShipScreen=new SelectSpaceShipScreen();
	static GamePlayScreen gamePlayScreen=new GamePlayScreen();
	static EndGameScreen endGame= new EndGameScreen();
	
	// The card layout manager to switch between screens.
	static CardLayout cardLayout=new CardLayout();
	
	// The panel containing the different screens.
	static JPanel spaceFramePanel=new JPanel();
	
	// Constructor that takes width and height as arguments.
	public SpaceFrame(int width, int height) {
		// Sets the width and height of the frame.
		SpaceFrame.width=width;
		SpaceFrame.height=height;
		
		// Sets the size and title of the JFrame.
		this.setSize(width, height);	
		this.setTitle("[ECE_Y325] astra game simulation");
		
		// Sets the default close operation, location, and focusability of the JFrame.
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setLocationRelativeTo(null); 		
		this.setFocusable(true);
		
		// Sets up the master panel with the card layout manager.
		setupMasterPanel();
		
		// Sets the JFrame to not be resizable and visible.
		setResizable(false);
		this.setVisible(true); 		
	}
	
	// Sets up the master panel with the card layout manager and adds the different screens.
	void setupMasterPanel() {
		spaceFramePanel.setLayout(cardLayout);
		spaceFramePanel.add(selectSpaceShipScreen);
		spaceFramePanel.add(gamePlayScreen);
		spaceFramePanel.add(endGame);
		this.add(spaceFramePanel);
	}
}

