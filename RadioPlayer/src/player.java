import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class player  {
	
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
