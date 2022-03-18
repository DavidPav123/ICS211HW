/**
 * Driver class for my Rock-Paper-Scissors game
 * Creates an instance of the RPSGui class and makes the gui visible 
 * @author    David Pavlicek
 */

public class RPS {
    public static void main(String[] args) throws Exception {
        RPSGUIFile gui = new RPSGUIFile( );
        gui.initializeGUI( );
        gui.setVisible(true);
    }
}


