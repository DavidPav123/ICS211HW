/**
 * Class that sets up the gui and runs the rock paper scissors program
 * Creates the gui using JFrames
 * Handles events, like a button being clicked, using awt events
 * Creates and writes scores into a file using java input/output
 * @author    David Pavlicek
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class RPSGUIFile extends JFrame {

    //Setting up variables
    private int wins = 0;
    private int loss = 0;
    private int ties = 0;
    private int computerRPS = 0;
    private int totalGames = 0;
    private boolean start = true;

    //Setting up labels
    private JLabel label = new JLabel(" Rock-Paper-Scissors Vs. Computer ");
    private JLabel helpText0 = new JLabel(" HOW TO PLAY ");
    private JLabel helpText1 = new JLabel(" Press the Rock, Paper, or Scissors button then the computer will generate a random response ");
    private JLabel helpText2 = new JLabel(" What the computer chose and if you won/lost/tied will be displayed and it will be added to the total on the bottom of the screen");
    private JLabel helpText3 = new JLabel(" When finished playing, click the \"done\" button to close the game ");
    private JLabel helpText4 = new JLabel(" A scores file named scores.txt will then be made in the same folder this program is in which records all of your matches and total wins/losses/ties  ");
    private JLabel midText = new JLabel(" ");
    private JLabel Wins = new JLabel(" Win: ");
    private JLabel Loss = new JLabel(" Loss: ");
    private JLabel Ties = new JLabel(" Tie: ");
    private JLabel winTotal = new JLabel(Integer.toString(wins));
    private JLabel lossTotal = new JLabel(Integer.toString(loss));
    private JLabel tieTotal = new JLabel(Integer.toString(ties));

    //Gui size constants
    private final int WIDTH = 900;
    private final int HEIGHT = 600;

    //Setting up file to be written in
    File f = new File("Scores.txt");
    FileWriter fw = new FileWriter(f);
    PrintWriter pw = new PrintWriter(fw);

    //Setting up buttons
    //How to play Button
    private JButton buttonHelp = new JButton( new AbstractAction("?") {
        public void actionPerformed( ActionEvent e ) {
            winTotal.setVisible(false);
            lossTotal.setVisible(false);
            tieTotal.setVisible(false);
            Wins.setVisible(false);
            Loss.setVisible(false);
            Ties.setVisible(false);
            buttonDone.setVisible(false);
            buttonHelp.setVisible(false);
            buttonRock.setVisible(false);
            buttonPaper.setVisible(false);
            buttonScissors.setVisible(false);
            label.setVisible(false);
            midText.setVisible(false);
            helpText0.setVisible(true);
            helpText1.setVisible(true);
            helpText2.setVisible(true);
            helpText3.setVisible(true);
            helpText4.setVisible(true);
            buttonReturn.setVisible(true);
        }
    });
    //Finish button
    private JButton buttonDone = new JButton( new AbstractAction("Done") {
        public void actionPerformed( ActionEvent e ) {
            pw.println("Win: " + wins + ", Loss: " + loss + ",  Tie: "+ ties); //Print out totals and end of file
            pw.close(); //Close File
            close(); //Exit the gui
        }
    });
    //Rock Button
    private JButton buttonRock = new JButton( new AbstractAction("Rock") {
        public void actionPerformed( ActionEvent e ) {
            Random rand = new Random();
            computerRPS = rand.nextInt(3);
            if(computerRPS == 1){
                midText.setText("The Computer threw paper, you lost!");
                loss++;
                lossTotal.setText(Integer.toString(loss));
                totalGames++;
                pw.println(totalGames + ", Rock, " + " Paper, " + "Loss");
            }
            else if(computerRPS == 2){
                midText.setText("The Computer threw scissors, you won!");
                wins++;
                winTotal.setText(Integer.toString(wins));
                totalGames++;
                pw.println(totalGames + ", Rock, " + " Scissors, " + "Win");
            }
            else{
                midText.setText("The Computer threw rock, you tied!");
                ties++;
                tieTotal.setText(Integer.toString(ties));
                totalGames++;
                pw.println(totalGames + ", Rock, " + " Rock, " + "Tie");
            }
        }
    });
    //Paper Button
    private JButton buttonPaper = new JButton( new AbstractAction("Paper") {
        public void actionPerformed( ActionEvent e ) {
            Random rand = new Random();
            computerRPS = rand.nextInt(3);
            if(computerRPS == 0){
                midText.setText("The Computer threw rock, you win!");
                wins++;
                winTotal.setText(Integer.toString(wins));
                totalGames++;
                pw.println(totalGames + ", Paper, " + " Rock, " + "Win");
            }
            else if(computerRPS == 2){
                midText.setText("The Computer threw scissors, you lost!");
                loss++;
                lossTotal.setText(Integer.toString(loss));
                totalGames++;
                pw.println(totalGames + ", Paper, " + " Scissors, " + "Loss");
            }
            else{
                midText.setText("The Computer threw paper, you tied!");
                ties++;
                tieTotal.setText(Integer.toString(ties));
                totalGames++;
                pw.println(totalGames + ", Paper, " + " Paper, " + "Tie");
            }
        }
    });
    //Scissors Button
    private JButton buttonScissors = new JButton( new AbstractAction("Scissors") {
        public void actionPerformed( ActionEvent e ) {
            Random rand = new Random();
            computerRPS = rand.nextInt(3);
            if(computerRPS == 1){
                midText.setText("The Computer threw paper, you won!");
                wins++;
                winTotal.setText(Integer.toString(wins));
                totalGames++;
                pw.println(totalGames + ", Scissors, " + " Paper, " + "Win");
            }
            else if(computerRPS == 0){
                midText.setText("The Computer threw rock, you lost!");
                loss++;
                lossTotal.setText(Integer.toString(loss));
                totalGames++;
                pw.println(totalGames + ", Scissors, " + " Rock, " + "Loss");
            }
            else{
                midText.setText("The Computer threw scissors, you tied!");
                ties++;
                tieTotal.setText(Integer.toString(ties));
                totalGames++;
                pw.println(totalGames + ", Scissors, " + " Scissors, " + "Tie");
            }
        }
    });
    //Return button
    private JButton buttonReturn = new JButton( new AbstractAction("Return") {
        public void actionPerformed( ActionEvent e ) {
            winTotal.setVisible(true);
            lossTotal.setVisible(true);
            tieTotal.setVisible(true);
            Wins.setVisible(true);
            Loss.setVisible(true);
            Ties.setVisible(true);
            buttonDone.setVisible(true);
            buttonHelp.setVisible(true);
            buttonRock.setVisible(true);
            buttonPaper.setVisible(true);
            buttonScissors.setVisible(true);
            label.setVisible(true);
            midText.setVisible(true);
            helpText0.setVisible(false);
            helpText1.setVisible(false);
            helpText2.setVisible(false);
            helpText3.setVisible(false);
            helpText4.setVisible(false);
            buttonReturn.setVisible(false);
        }
    });

    //Gui settings
    public RPSGUIFile( ) throws IOException {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Rock-Paper-Scissors");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    //Putting all elements onto the gui
    public void initializeGUI( ) throws Exception{
        JPanel Container = new JPanel( );
        Container.setLayout(new BorderLayout( ));

        JPanel top = new JPanel( );
        top.add(buttonDone);
        top.add(label);
        top.add(buttonHelp);
        Container.add(top,BorderLayout.PAGE_START);

        JPanel center = new JPanel( );
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        center.add(buttonRock);
        buttonRock.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(buttonPaper);
        buttonPaper.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(buttonScissors);
        buttonScissors.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(midText);
        midText.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(helpText0);
        helpText0.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpText0.setVisible(false);
        center.add(helpText1);
        helpText1.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpText1.setVisible(false);
        center.add(helpText2);
        helpText2.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpText2.setVisible(false);
        center.add(helpText3);
        helpText3.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpText3.setVisible(false);
        center.add(helpText4);
        helpText4.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpText4.setVisible(false);
        center.add(buttonReturn);
        buttonReturn.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonReturn.setVisible(false);
        Container.add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel( );
        bottom.add(Wins);
        bottom.add(winTotal);
        bottom.add(Loss);
        bottom.add(lossTotal);
        bottom.add(Ties);
        bottom.add(tieTotal);
        Container.add(bottom, BorderLayout.PAGE_END);

        this.add(Container);

        if(start == true){ //If statment so that the top line isn't printed again
            pw.println("Match Number, Player Choice, Computer Choice, Win/Loss/Tie"); //Top line of the file
            start = false;
        }
    }

    //Funciton to close the gui
    public void close(){
        this.dispose();
    }
}