//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.awt.event.ActionEvent;

public class userInterface{
	// Sets a default choice
	String userChoice = "http://fm02-ice.stream.khz.se/fm02_mp3";
	String userChoose = "Bandit Rock";
	
	public userInterface(){
		JFrame guiFrame = new JFrame();
		//Options for the JComboBox
		String[] radioOptions = {"Bandit Rock", "StarFM", "Pirate Rock"
				,"Gamla Favoriter", "One Hit Wonders", "Rix Fm"};
		//Make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Sets title of app
		guiFrame.setTitle("RadioPlayer");
		//Sets size
		guiFrame.setSize(300,100);
		
		//This will center the JFrame in the middle of the screen
		guiFrame.setLocationRelativeTo(null);
	
		//The first JPanel contains a JLabel and JCombobox
		final JPanel comboPanel = new JPanel();
		JLabel comboLbl = new JLabel("Radiokanaler:");
		JComboBox radio = new JComboBox(radioOptions);
		comboPanel.add(comboLbl);
		comboPanel.add(radio);
		//Adds two buttons for start/stop
		JButton radioPlay = new JButton( "< Play >");
		JButton radioStop = new JButton( "< Stop >");
		
		//The JFrame uses the BorderLayout layout manager.
		//Put the two JPanels and JButtons in different areas.
		guiFrame.add(comboPanel, BorderLayout.NORTH);
		guiFrame.add(radioPlay,BorderLayout.WEST);
		guiFrame.add(radioStop,BorderLayout.EAST);
				
		//make sure the JFrame is visible
		guiFrame.setVisible(true);
			
			//The ActionListener class is used to handle the
			//event that happens when the user clicks the start button.
			
			
			radioPlay.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent event){
					//Starts a new thread for playing music
					 Music music = new Music();
					 music.start();
					 // Handle event when user clicks stop
					 radioStop.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent event){
								//Kills the playing thread
								music.stop();
							}
					});
					 // Handle different choices in ComboBox and sets new stream to be played
					 radio.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//Gets users choice from ComboBox
								userChoose = radio.getSelectedItem().toString();
								// Kills playing thread to prevent from two streams playing at once
								music.stop();
								//Set new stream to listen to
								switch (userChoose) {
								case "StarFM":
									userChoice = "http://fm05-ice.stream.khz.se/fm05_mp3";
									break;
								case "Pirate Rock":
									userChoice = "http://stream.piraterock.se:8101/webradio";
									break;
								case "Gamla Favoriter":
									userChoice = "http://wr09-ice.stream.khz.se/wr09_mp3";
									break;
								case "One Hit Wonders":
									userChoice = "http://wr18-ice.stream.khz.se/wr18_mp3";
									break;
								case "Rix Fm":
									userChoice = "http://fm01-ice.stream.khz.se/fm01_mp3";
									break;
								case "Bandit Rock":
									userChoice = "http://fm02-ice.stream.khz.se/fm02_mp3";
									break;
									}
							}
							
						});
				}
			});
	}
	
class Music extends Thread{	
		public void run(){  
				try{
				// Calls the play action if media player and handles exceptions 	
				player.startRadio(userChoice);
				}catch ( IOException e ){
					e.printStackTrace ();
				}catch ( JavaLayerException e )
				{
					e.printStackTrace ();
				}
			
		}
	}
}
