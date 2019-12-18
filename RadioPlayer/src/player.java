import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class player  {
/**
 * 	This set the chosen station and starts player
 * @param spec a string containing chosen radiostation
 * @throws IOException
 * @throws JavaLayerException
 */
	public static void startRadio(String spec) throws IOException, JavaLayerException
    {
		// Connection
        URLConnection urlConnection = new URL (spec).openConnection ();
        // Connecting
        urlConnection.connect();
        // Playing
        Player player = new Player(urlConnection.getInputStream());
        player.play();
        
    }

	
}

