package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


//The following code defines a class that represents the end game screen, which displays when the player wins the game.

public class EndGameScreen extends JPanel {
	// Generated serial version UID.
	private static final long serialVersionUID = 1L;

	// Constructor that sets up the end game screen panel.
	EndGameScreen(){   	
		this.setVisible(true);
		this.setSize(400,400);
		this.setLayout(new BorderLayout(30,30));
		this.add(top(),BorderLayout.NORTH);
		this.add(center(),BorderLayout.CENTER);
		this.setBackground( Color.BLACK );
	}

	// Method that sets up the top panel of the end game screen.
	private JPanel top() {
		 JPanel npanel=new JPanel();
		 JLabel label1=new JLabel("YOU WON");
		 label1.setFont(new Font("Arcade Classic", Font.PLAIN, 50));
		 npanel.setBackground( Color.BLACK );
		 npanel.add(label1);
		 return npanel;
	}

	// Method that sets up the center panel of the end game screen.
	private JPanel center() {
		 JPanel npanel=new JPanel();
		 JButton tryagain=new JButton("TRY AGAIN");
		 JButton exit=new JButton("EXIT");
		 tryagain.addActionListener(new handler("TRY AGAIN"));
		 exit.addActionListener(new handler("EXIT"));
		 npanel.setBackground( Color.BLACK );
		 npanel.add(tryagain);
		 npanel.add(exit);
		 return npanel;
	}

	// Inner class that handles button clicks on the end game screen.
	 private class handler implements ActionListener{
		 String name;
		 public handler(String n) {
			 name=n;
		 }
		 public void actionPerformed(ActionEvent event) {
			 // If the "TRY AGAIN" button is clicked, go back to the game screen.
			 if(name.equalsIgnoreCase("TRY AGAIN"))
			 	SpaceFrame.cardLayout.first(SpaceFrame.spaceFramePanel);
			 // If the "EXIT" button is clicked, exit the game.
			 if(name.equalsIgnoreCase("EXIT"))
			 	System.exit(0);
		 }
	 }

}
