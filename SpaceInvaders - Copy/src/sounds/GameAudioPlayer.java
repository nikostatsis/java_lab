// Import necessary classes for handling audio playback
package sounds;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import main.MainClass;

// Define a class for playing game audio
public class GameAudioPlayer {
	
	// Declare instance variables
	private AudioInputStream audioInputStream;
	private Clip clip;
	
	// Constructor for the GameAudioPlayer class
	public GameAudioPlayer(){
		// Load the space ambient audio file when a new instance of GameAudioPlayer is created
		loadSpaceAmbient();
   }
	
	// Method for loading and playing the space ambient audio file
	void loadSpaceAmbient() {
		try{
			// Load the audio file from the specified path as an AudioInputStream
			audioInputStream = AudioSystem.getAudioInputStream(MainClass.class.getResource("../audio/space-ambience.wav"));
			
			// Create a new Clip and set its audio stream to the loaded AudioInputStream
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			
			// Set the clip to loop continuously
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			// Set the volume of the clip to -15 decibels
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	      	gainControl.setValue(-15.0f);
	      	
	      	// Start playing the clip
	      	clip.start();
		}
		// Handle any exceptions that occur during the loading or playing of the audio file
		catch (Exception ex) {
			System.out.println(ex);
		}	
	}	
}

