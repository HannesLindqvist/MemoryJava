import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Game {
    static JButton lastButtonPressed = null;
    static String previousCard = null;
    static int totalPoints; 

    // add point to active player
    public static void addPoint(Player player1, Player player2) {
        if (player1.active){
            player1.addPoints();
        } else{
            player2.addPoints();
        }
        totalPoints = player1.getPoints() + player2.getPoints();
        if (totalPoints == 8){
            new GameOverClass();
        }
    }


    // change active player
    private void changePlayer(BoardView boardView, Player player1, Player player2) {
        if (player1.active){
            player1.setActive(false);
            player2.setActive(true);
            boardView.player1Panel.setBackground(Color.lightGray);
            boardView.player2Panel.setBackground(Color.GREEN);
        } else {
            player1.setActive(true);
            player2.setActive(false);
            boardView.player1Panel.setBackground(Color.GREEN);
            boardView.player2Panel.setBackground(Color.lightGray);
        }
    }

    public static void nextTurn(LinkedHashMap gameBoard, JButton activeButton) {
        Set<JButton> keys = gameBoard.keySet();
        for (JButton key : keys) {
            // Show card by setting buttons icon to key value
            if(key == activeButton){
               activeButton.setIcon((Icon) gameBoard.get(key)); 
            }
                
            //System.out.println(key == activeButton);
        }

    }

    public static void main(String[] args) { 
        
        Player player1 = new Player(true, "Kalle");
        Player player2 = new Player(false, "Lisa");
        BoardView boardView = new BoardView(player1, player2, Cards.mixDeck());
    

        
        
        //SwingUtilities.invokeLater(new LaunchMenu());
        //new GameOverClass();

    }
    
    
    
}
