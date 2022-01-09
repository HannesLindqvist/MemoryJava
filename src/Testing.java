import java.util.Arrays;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Testing {
    Game4x4 game = new Game4x4("Kalle", "Lisa");
    ImageIcon[] mixedCardDeck = Cards.mixDeck();
    Cards cardDeck = new Cards();

    @Test
    public void testCards() {
        
    }
        
    @Test
    public void changeActivePlayer() {
        // game stats with player1 active and player2 inactive
        // changePlayer() is called
        // player2 is active and player1 is inactive 
        
        Assertions.assertTrue(game.player1.active);
        Assertions.assertFalse(game.player2.active);

        game.changePlayer();

        Assertions.assertFalse(game.player1.active);
        Assertions.assertTrue(game.player2.active);

    }
    
    @Test
    public void addPoints() {
        // player1 starts with 0 points
        // addPoint() is called
        // player1 has 1 point
        
        Assertions.assertEquals(0, game.player1.getPoints());
        game.addPoint();
        Assertions.assertEquals(1, game.player1.getPoints());

    }

    @Test
    public void disableCards() {
        // lastButtonPressed and thisButton starts as enabled
        // disableCards() is called
        // lastButtonPressed and thisButton is disabled enabled
        // 2sec delay added so value has time to update 

        game.lastButtonPressed = game.iconButton1;
        Assertions.assertTrue(game.lastButtonPressed.isEnabled());
        Assertions.assertTrue(game.iconButton2.isEnabled());       // thisButton

        game.disableCards(game.iconButton2);

        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Assertions.assertFalse(game.lastButtonPressed.isEnabled());
                Assertions.assertFalse(game.iconButton2.isEnabled());
            }
        });

        timer.setRepeats(false);
        timer.restart();
        
    }

    @Test
    public void hideCards() {
        // lastButtonPressed and thisButton has icon (flipped)
        // hideCards() is called
        // lastButtonPressed and this button has no icon/null (hidden)
        // 2sec delay added so value has time to update

        game.lastButtonPressed = game.iconButton1;
        
        //game.lastButtonPressed.setIcon(mixedCardDeck[0]);
        //game.iconButton2.setIcon(mixedCardDeck[1]);                 // represents latest clicked button

        Assertions.assertNotNull(game.lastButtonPressed.getIcon()); // check if icon exist
        Assertions.assertNotNull(game.lastButtonPressed.getIcon()); // check if icon exist
        
        game.hideCards(game.iconButton2);

        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Assertions.assertNull(game.lastButtonPressed.getIcon());    // check if icon is null
                Assertions.assertNull(game.iconButton2.getIcon());          // check if icon is null
            }
            });

        timer.setRepeats(false);
        timer.restart();

    }
    
    @Test
    public void resetCardButton() {
        // values added to variables
        // resetCardButton() is called
        // variables set to null and "0"

        game.lastButtonPressed = game.iconButton1;
        game.previousCard = "cherry.png"; 
        game.cardsVisible = 2;
        
        game.resetCardButton();

        Assertions.assertNull(game.lastButtonPressed); 
        Assertions.assertNull(game.previousCard);
        Assertions.assertEquals(0, game.cardsVisible);

    }

}

