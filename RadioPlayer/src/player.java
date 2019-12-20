import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.swing.JOptionPane;

public class player  {
/**
 * 	This gets the chosen station and starts player
 * @param spec a string containing chosen radio station
 * @throws IOException
 * @throws JavaLayerException
 */
	public static void startRadio(String spec) throws IOException, JavaLayerException
    {
		try {
		// Connection
        URLConnection urlConnection = new URL (spec).openConnection ();
        // Connecting
        urlConnection.connect();
        // Playing
        Player player = new Player(urlConnection.getInputStream());
        player.play();
		}catch (Exception e) {              
			JOptionPane.showMessageDialog(null, "Check internet connection, otherwise try another station.");
			e.printStackTrace();
        }
        
    }
	
}

