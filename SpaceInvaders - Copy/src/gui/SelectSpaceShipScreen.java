package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import spaceships.SpaceShip;
import spaceships.SpaceshipALPHA;
import spaceships.SpaceshipBETA;
import spaceships.SpaceshipDELTA;
import spaceships.SpaceshipGAMA;
import spaceships.SpaceshipZERO;

//This is a Java Swing class called SelectSpaceShipScreen which extends JPanel 
//and provides a screen for the user to select a spaceship to use in a game.

public class SelectSpaceShipScreen extends JPanel {
 // A serial version UID to support serialization and deserialization
 private static final long serialVersionUID = 1L;
 
 // A constant font for the label
 private static final Font LABEL_FONT = new Font("Arcade Classic", Font.PLAIN, 25);
 
 // A constant size for the south panel
 private static final int SOUTH_PANEL_SIZE = 200;
 
 // A map of spaceship names and their corresponding objects
 private static final Map<String, SpaceShip> SPACESHIPS = new HashMap<>();
 static {
     // Adding the spaceships to the map
     SPACESHIPS.put("salpha", new SpaceshipALPHA());
     SPACESHIPS.put("sbeta", new SpaceshipBETA());
     SPACESHIPS.put("sdelta", new SpaceshipDELTA());
     SPACESHIPS.put("sgama", new SpaceshipGAMA());
     SPACESHIPS.put("szero", new SpaceshipZERO());
 }
 
 // Constructor for the SelectSpaceShipScreen class
 public SelectSpaceShipScreen() {
     // Making the panel visible
     this.setVisible(true);
     
     // Setting the panel's size
     this.setSize(400,400);
     
     // Setting the layout for the panel
     this.setLayout(new BorderLayout(30,30));
     
     // Adding the north panel to the SelectSpaceShipScreen
     this.add(northpanel(), BorderLayout.NORTH);
     
     // Adding the center panel to the SelectSpaceShipScreen
     this.add(centerpanel(), BorderLayout.CENTER);
     
     // Adding the south panel to the SelectSpaceShipScreen
     this.add(southpanel(), BorderLayout.SOUTH);
     
     // Setting the background color of the panel
     this.setBackground(Color.BLACK);
 }
 
 // Method to create and return the north panel
 private JPanel northpanel() {
     // Creating the north panel
     JPanel npanel = new JPanel();
     
     // Creating a label for the north panel
     JLabel label1 = new JLabel("Choose spaceship");
     
     // Setting the font for the label
     label1.setFont(LABEL_FONT);
     
     // Setting the background and foreground colors for the panel
     this.setBackground(Color.BLACK);
     this.setForeground(Color.WHITE);
     
     // Adding the label to the north panel
     npanel.add(label1);
     
     // Returning the north panel
     return npanel;
 }
 
 // Method to create and return the center panel
 private JPanel centerpanel() {
     // Creating the center panel
     JPanel cpanel = new JPanel();
     
     // Setting the layout for the center panel
     cpanel.setLayout(new GridLayout());
     
     // Setting the background color for the center panel
     cpanel.setBackground(Color.BLACK);
     
     // Adding a button for each spaceship available in the game
     for (String name : SPACESHIPS.keySet()) {
         JButton button = new JButton();
         
         // Adding an ActionListener to each button
         button.addActionListener(new Handler(name));
         
         // Setting the icon for the button to the image of the spaceship
         button.setIcon(new ImageIcon(SPACESHIPS.get(name).getImg()));
         
         // Making the button transparent
         settransparent(button);
         
         // Adding the button to the center panel
         cpanel.add(button);
     }
     
     // Returning the center panel
     return cpanel;
 }
    
	 /**
	
	 A private helper method to set the button's background to black and make it transparent.
	 @param btn the button to set transparency for
	 */
	 private void settransparent(JButton btn) {
		 btn.setBackground(Color.BLACK);
		 btn.setOpaque(false);
		 btn.setContentAreaFilled(false);
		 btn.setBorderPainted(false);
		 btn.setFocusPainted(false);
		 btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 }

	 /**

	 An inner class that implements the ActionListener interface to handle button clicks.
	 It switches to the game play screen, sets focus to the game play screen, and sets the user's selected spaceship.
	 */
	 private class Handler implements ActionListener {
		 private final String name;
		 public Handler(String n) {
		 name = n;
	 }
	 public void actionPerformed(ActionEvent event) {
		 SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
		 SpaceFrame.gamePlayScreen.setFocusable(true);
		 SpaceFrame.gamePlayScreen.requestFocus();
		 SpaceFrame.gamePlayScreen.setUserSpaceShip(SPACESHIPS.get(name));
		 }
 }

	/**
	
	 A private helper method to create and return the south panel.
	 @return the south panel
	 */
	 private JPanel southpanel() {
		 JPanel spanel = new JPanel();
		 spanel.setPreferredSize(new Dimension(100, SOUTH_PANEL_SIZE));
		 spanel.setBackground(Color.BLACK);
		 return spanel;
	 }
}
