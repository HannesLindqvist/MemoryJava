import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Game implements ActionListener {
    static Cards cardDeck = new Cards(); 
    static Player player1 = new Player(true);
    static Player player2 = new Player(false);
    static BoardView boardView = new BoardView(player1, player2, cardDeck.mixDeck());
    
    static JButton lastButtonPressed = null;
    static String previousCard = null;
    static int totalPoints; 


    // Reset history
    public static void resetCardButton() {
        lastButtonPressed = null;
        previousCard = null;
        boardView.setVisibleCardCount(0);
    }


    // Add point to active player
    public static void addPoint() {
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


    // Change active player
    private static void changePlayer() {
        if (player1.active){
            player1.setActive(false);
            player2.setActive(true);
            BoardView.player1Panel.setBackground(Color.lightGray);
            BoardView.player2Panel.setBackground(Color.GREEN);
        } else {
            player1.setActive(true);
            player2.setActive(false);
            BoardView.player1Panel.setBackground(Color.GREEN);
            BoardView.player2Panel.setBackground(Color.lightGray);
        }
    }
    

    // Disable buttons/cards
    // Previous and latest pressed button is disabled
    public static void disableCards(JButton activeButton, JButton lastButtonPressed){
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                lastButtonPressed.setEnabled(false);
                activeButton.setEnabled(false);
                addPoint();
                boardView.updateScoreboard();
                resetCardButton();
            }
        });

        timer.setRepeats(false);
        timer.restart();

    }
        

    // Hide cards
    // Button icon of the previous pressed button and the latest button pressed is set to null
    public static void hideCards(JButton thisButton, JButton lastButtonPressed) {
        Timer timer = new Timer(1000, new ActionListener() {                      // A delay of 1sec is added before turn of cards
            public void actionPerformed(ActionEvent evt) {
            thisButton.setIcon(null);
            lastButtonPressed.setIcon(null);
            changePlayer();
            resetCardButton();
            }
        });

        timer.setRepeats(false);
        timer.restart();
        
    }

    
    public static void thisTurn(LinkedHashMap gameBoard, JButton activeButton) {
        Set<JButton> keys = gameBoard.keySet();
        
        // Display card on the pressed button
        // Find active button(key) in gameBoard hashmap and set its value as icon
        for (JButton key : keys) {
            if(key == activeButton){
               activeButton.setIcon((Icon) gameBoard.get(key));
            }
        }
        // Match = disable card/button
        if (gameBoard.get(activeButton).toString().equals(previousCard)) {
            disableCards(activeButton, lastButtonPressed);
        }

        // No match - hide cards
        if (previousCard != null && !gameBoard.get(activeButton).toString().equals(previousCard)){
            hideCards(activeButton, lastButtonPressed);
        }
        else{
        // Log pressed button and card flipped
            previousCard = gameBoard.get(activeButton).toString();
            lastButtonPressed = activeButton;
        }

    }
    
    // Each turn is started when a valid board button is pressed
    public void actionPerformed(ActionEvent e) {
        JButton activeButton = (JButton) e.getSource();             // This button is the same as the one being pressed

        if(activeButton.equals(Game.lastButtonPressed))             // If same button is pressed twice, do nothing
            return;

        // If two cards are visible, do not show additonal cards
        // The hideCard method resets the counter
        boardView.setVisibleCardCount(boardView.getVisibleCardCount() + 1);
        if(boardView.getVisibleCardCount() > 2)
            return;
        
        // 
        thisTurn(boardView.getGameBoard(), activeButton);
        

    }
   
    
}
