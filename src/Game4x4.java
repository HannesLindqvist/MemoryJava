import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;

import javax.swing.ImageIcon;

public class Game4x4 extends JFrame implements ActionListener{

    Player player1 = null;
    Player player2 = null;

    ImageIcon[] mixedCardDeck = Cards.mixDeck();

    JFrame frame = new JFrame();
    JPanel boardPanel = new JPanel();
    EtchedBorder etch = new EtchedBorder();
    JPanel playersContainer = new JPanel();
    
    JLabel player1Label = null;
    JLabel player2Label = null;
    
    JPanel playerPanel1 = new JPanel();
    JPanel playerPanel2 = new JPanel();
    
    JButton iconButton1 = new JButton();
    JButton iconButton2 = new JButton();
    JButton iconButton3 = new JButton();
    JButton iconButton4 = new JButton();
    JButton iconButton5 = new JButton();
    JButton iconButton6 = new JButton();
    JButton iconButton7 = new JButton();
    JButton iconButton8 = new JButton();
    JButton iconButton9 = new JButton();
    JButton iconButton10 = new JButton();
    JButton iconButton11 = new JButton();
    JButton iconButton12 = new JButton();
    JButton iconButton13 = new JButton();
    JButton iconButton14 = new JButton();
    JButton iconButton15 = new JButton();
    JButton iconButton16 = new JButton();
    
    JPanel menyPanel = new JPanel();
    JButton newGame = new JButton("Nytt Spel");
    JButton cancel = new JButton("Avsluta");

    JButton lastButtonPressed = null;
    String previousCard = null;

    private int cardsVisible = 0;
    int totalPoints = 0;





    public Game4x4(String player1Name, String player2Name) {

        player1 = new Player(player1Name);
        player2 = new Player(player2Name);

        player1Label = new JLabel("<html>Player 1<br>" + player1.name + "<br>Points :" + player1.points + "</html>");
        player2Label = new JLabel("<html>Player 2<br>" + player2.name + "<br>Points :" + player2.points + "</html>");
        startGame();

        // Grundramen till spelet.
        frame.setTitle("Detta ska bli ett memoryspel");


        // Lägger till en bild på knappen
        //frame.setIconImage(card1.getImage());


        // Koden till själva spelplanen
        frame.setLayout(new FlowLayout());
        boardPanel.setPreferredSize(new Dimension(300,300));
        boardPanel.setBackground(Color.lightGray);
        boardPanel.setLayout(new GridLayout(4,4));
        


        // Layout på knappar och paneler. Måste vara ovanför kanpparna eller panelerna för att funka.

        // Player 1 och 2 logik
        playersContainer.setLayout(new BoxLayout(playersContainer, BoxLayout.Y_AXIS));
        player1Label.setFont(new Font("Verdana", 1,20));

        player2Label.setFont(new Font("Verdana", 1,20));
        playerPanel1.setBackground(Color.GREEN);
        playerPanel2.setBackground(Color.lightGray);

        playerPanel1.setPreferredSize(new Dimension(120,150));
        playerPanel2.setPreferredSize(new Dimension(120,150));

        playerPanel1.setBorder(etch);
        playerPanel2.setBorder(etch);

        playerPanel1.add(player1Label);
        playerPanel2.add(player2Label);

        playersContainer.add(playerPanel1);
        playersContainer.add(playerPanel2);

        // Menyval
        menyPanel.add(newGame);
        menyPanel.add(cancel);

        // En viss typ av layout på knapparna, går enkelt att ändra.

        iconButton1.setBorder(etch);     iconButton5.setBorder(etch);     iconButton9.setBorder(etch);      iconButton13.setBorder(etch);
        iconButton2.setBorder(etch);     iconButton6.setBorder(etch);     iconButton10.setBorder(etch);     iconButton14.setBorder(etch);
        iconButton3.setBorder(etch);     iconButton7.setBorder(etch);     iconButton11.setBorder(etch);     iconButton15.setBorder(etch);
        iconButton4.setBorder(etch);     iconButton8.setBorder(etch);     iconButton12.setBorder(etch);     iconButton16.setBorder(etch);

        // Sätter färgen på knapparna, enkelt att ändra.

        iconButton1.setBackground(Color.orange);    iconButton9.setBackground(Color.orange);
        iconButton2.setBackground(Color.orange);    iconButton10.setBackground(Color.orange);
        iconButton3.setBackground(Color.orange);    iconButton11.setBackground(Color.orange);
        iconButton4.setBackground(Color.orange);    iconButton12.setBackground(Color.orange);
        iconButton5.setBackground(Color.orange);    iconButton13.setBackground(Color.orange);
        iconButton6.setBackground(Color.orange);    iconButton14.setBackground(Color.orange);
        iconButton7.setBackground(Color.orange);    iconButton15.setBackground(Color.orange);
        iconButton8.setBackground(Color.orange);    iconButton16.setBackground(Color.orange);

        // Addar knappar till panelen som ligger på boarden. boardPanelvariabeln är själva spelplanen.

        boardPanel.add(iconButton1); boardPanel.add(iconButton2); boardPanel.add(iconButton3); boardPanel.add(iconButton4);
        boardPanel.add(iconButton5); boardPanel.add(iconButton6); boardPanel.add(iconButton7); boardPanel.add(iconButton8);
        boardPanel.add(iconButton9); boardPanel.add(iconButton10); boardPanel.add(iconButton11); boardPanel.add(iconButton12);
        boardPanel.add(iconButton13); boardPanel.add(iconButton14); boardPanel.add(iconButton15); boardPanel.add(iconButton16);

        // Avgör sizen på framen och att den programmet avslutas när man stänger ner det.

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(450,400);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.add(playersContainer);
        frame.add(boardPanel);
        frame.add(menyPanel);


        // Logik till knapparna
        iconButton1.addActionListener(this);
        iconButton2.addActionListener(this);
        iconButton3.addActionListener(this);
        iconButton4.addActionListener(this);
        iconButton5.addActionListener(this);
        iconButton6.addActionListener(this);
        iconButton7.addActionListener(this);
        iconButton8.addActionListener(this);
        iconButton9.addActionListener(this);
        iconButton10.addActionListener(this);
        iconButton11.addActionListener(this);
        iconButton12.addActionListener(this);
        iconButton13.addActionListener(this);
        iconButton14.addActionListener(this);
        iconButton15.addActionListener(this);
        iconButton16.addActionListener(this);
        cancel.addActionListener(this);
        newGame.addActionListener(this);

    }


    // Player 1 active
    public void startGame() {
        player1.setActive(true);
    }

    // reset history
    public void resetCardButton() {
        lastButtonPressed = null;
        previousCard = null;
        cardsVisible = 0;
    }

    // hide cards
    public void hideCards(JButton thisButton) {

        Timer timer = new Timer(1000, new ActionListener() {
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

    // disable buttons/cards
    public void disableCards(JButton thisButton){
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                  // flip cards
                lastButtonPressed.setEnabled(false);
                thisButton.setEnabled(false);
                addPoint();
                updateScoreboard();
                resetCardButton();
            }
        });

        timer.setRepeats(false);
        timer.restart();
        
    }
    
    // change active player
    public void changePlayer() {
        if (player1.active){
            player1.setActive(false);
            player2.setActive(true);
            playerPanel1.setBackground(Color.lightGray);
            playerPanel2.setBackground(Color.GREEN);
        } else {
            player1.setActive(true);
            player2.setActive(false);
            playerPanel1.setBackground(Color.GREEN);
            playerPanel2.setBackground(Color.lightGray);
        }
    }
    
    // add point to active player
    public void addPoint() {
        if (player1.active){
            player1.addPoints();
        } else{
            player2.addPoints();
        }
        totalPoints = player1.points + player2.points;
        if (totalPoints == 8){
            frame.dispose();
            new GameOverClass();
        }
    }


    // Update scoreboard with new points
    public void updateScoreboard() {
        player1Label.setText("<html>Player 1<br>" + player1.name + "<br>Points :" + player1.points + "</html>");
        player2Label.setText("<html>Player 2<br>" + player2.name + "<br>Points :" + player2.points + "</html>");
    }


    public void actionPerformed(ActionEvent e) {
        cardsVisible += 1;
        JButton activeButton = (JButton) e.getSource();                // This button is the same as the one being pressed

        // If same button is pressed twice, do nothing
        if(activeButton.equals(lastButtonPressed))
            return;

        
        if(cardsVisible > 2)
            return;

        //////////////////////////////////////////////////////////////////////
        // iconButton1                                                      //
        // Each button has its own if-statements but the logic is the same  // 
        // Card shown on button when button is pressed                      //
        // Cards disabled if matched                                        // 
        // Cards hides if no match                                          // 
        // The selected Button and Card is saved to variables               //
        //////////////////////////////////////////////////////////////////////
        if (activeButton.equals(iconButton1)) {
            iconButton1.setIcon(mixedCardDeck[0]);
            if(mixedCardDeck[0].toString().equals(previousCard)) {
                this.disableCards(iconButton1);
                return;
            }
            if (previousCard != null && !mixedCardDeck[0].toString().equals(previousCard)){
                this.hideCards(iconButton1);

            }
            else{
                previousCard = mixedCardDeck[0].toString();
                lastButtonPressed = activeButton;
            }

        }
        // iconButton2
        else if (activeButton.equals(iconButton2)) {
            iconButton2.setIcon(mixedCardDeck[1]);
            if(mixedCardDeck[1].toString().equals(previousCard)) {
                this.disableCards(iconButton2);
                return;
            }
            if (previousCard != null && !mixedCardDeck[1].toString().equals(previousCard)){
                this.hideCards(iconButton2);
            }
            else{
                previousCard = mixedCardDeck[1].toString();
                lastButtonPressed = activeButton;
            }
        }

        // iconButton3
        else if (activeButton.equals(iconButton3)) {
            iconButton3.setIcon(mixedCardDeck[2]);
            if(mixedCardDeck[2].toString().equals(previousCard)) {
                this.disableCards(iconButton3);
                return;
            }
            if (previousCard != null && !mixedCardDeck[2].toString().equals(previousCard)){
                this.hideCards(iconButton3);
            }
            else{
                previousCard = mixedCardDeck[2].toString();
                lastButtonPressed = activeButton;
            }
        }

        // iconButton4
        else if (activeButton.equals(iconButton4)) {
            iconButton4.setIcon(mixedCardDeck[3]);
            if(mixedCardDeck[3].toString().equals(previousCard)) {
                this.disableCards(iconButton4);
                return;
            }
            if (previousCard != null && !mixedCardDeck[3].toString().equals(previousCard)){
                this.hideCards(iconButton4);
            }
            else{

                previousCard = mixedCardDeck[3].toString();
                lastButtonPressed = activeButton;
            }


            previousCard = mixedCardDeck[3].toString();
            lastButtonPressed = activeButton;
            } 


        // iconButton5 
        else if (activeButton.equals(iconButton5)) {
            iconButton5.setIcon(mixedCardDeck[4]);
            if(mixedCardDeck[4].toString().equals(previousCard)) {
                this.disableCards(iconButton5);
                return;
            }
            if (previousCard != null && !mixedCardDeck[4].toString().equals(previousCard)){
                this.hideCards(iconButton5);
            }
            else{
            previousCard = mixedCardDeck[4].toString();
            lastButtonPressed = activeButton;
            }
        }

        // iconButton6 
        else if (activeButton.equals(iconButton6)) {
            iconButton6.setIcon(mixedCardDeck[5]);
            if(mixedCardDeck[5].toString().equals(previousCard)) {
                this.disableCards(iconButton6);
                return;
            }
            if (previousCard != null && !mixedCardDeck[5].toString().equals(previousCard)){
                this.hideCards(iconButton6);
            }
            else{
            previousCard = mixedCardDeck[5].toString();
            lastButtonPressed = activeButton;
            }
        } 

        // iconButton7
        else if (activeButton.equals(iconButton7)) {
            iconButton7.setIcon(mixedCardDeck[6]);
            if(mixedCardDeck[6].toString().equals(previousCard)) {
                this.disableCards(iconButton7);
                return;
            }
            if (previousCard != null && !mixedCardDeck[6].toString().equals(previousCard)){
                this.hideCards(iconButton7);
            }
            else{
            previousCard = mixedCardDeck[6].toString();
            lastButtonPressed = activeButton;
            }
        } 


        // iconButton8
        else if (activeButton.equals(iconButton8)) {
            iconButton8.setIcon(mixedCardDeck[7]);
            if(mixedCardDeck[7].toString().equals(previousCard)) {
                this.disableCards(iconButton8);
                return;
            }
            if (previousCard != null && !mixedCardDeck[7].toString().equals(previousCard)){
                this.hideCards(iconButton8);
            }
            else{
            previousCard = mixedCardDeck[7].toString();
            lastButtonPressed = activeButton;
            }
        }

        // iconButton9
        else if (activeButton.equals(iconButton9)) {
            iconButton9.setIcon(mixedCardDeck[8]);
            if(mixedCardDeck[8].toString().equals(previousCard)) {
                this.disableCards(iconButton9);
                return;
            }
            if (previousCard != null && !mixedCardDeck[8].toString().equals(previousCard)){
                this.hideCards(iconButton9);
            }
            else{
            previousCard = mixedCardDeck[8].toString();
            lastButtonPressed = activeButton;
            }
        } 

        // iconButton10
        else if (activeButton.equals(iconButton10)) {
            iconButton10.setIcon(mixedCardDeck[9]);
            if(mixedCardDeck[9].toString().equals(previousCard)) {
                this.disableCards(iconButton10);
                return;
            }
            if (previousCard != null && !mixedCardDeck[9].toString().equals(previousCard)){
                this.hideCards(iconButton10);
            }
            else{
            previousCard = mixedCardDeck[9].toString();
            lastButtonPressed = activeButton;
            }
        } 

        // iconButton11
        else if (activeButton.equals(iconButton11)) {
            iconButton11.setIcon(mixedCardDeck[10]);
            if(mixedCardDeck[10].toString().equals(previousCard)) {
                this.disableCards(iconButton11);
                return;
            }
            if (previousCard != null && !mixedCardDeck[10].toString().equals(previousCard)){
                this.hideCards(iconButton11);
            }
            else{
            previousCard = mixedCardDeck[10].toString();
            lastButtonPressed = activeButton;
            }
        }
        
        // iconButton12
        else if (activeButton.equals(iconButton12)) {
            iconButton12.setIcon(mixedCardDeck[11]);
            if(mixedCardDeck[11].toString().equals(previousCard)) {
                this.disableCards(iconButton12);
                return;
            }
            if (previousCard != null && !mixedCardDeck[11].toString().equals(previousCard)){
                this.hideCards(iconButton12);
            }
            else{
            previousCard = mixedCardDeck[11].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // iconButton13
        else if (activeButton.equals(iconButton13)) {
            iconButton13.setIcon(mixedCardDeck[12]);
            if(mixedCardDeck[12].toString().equals(previousCard)) {
                this.disableCards(iconButton13);
                return;
            }
            if (previousCard != null && !mixedCardDeck[12].toString().equals(previousCard)){
                this.hideCards(iconButton13);
            }
            else{
            previousCard = mixedCardDeck[12].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // iconButton14
        else if (activeButton.equals(iconButton14)) {
            iconButton14.setIcon(mixedCardDeck[13]);
            if(mixedCardDeck[13].toString().equals(previousCard)) {
                this.disableCards(iconButton14);
                return;
            }
            if (previousCard != null && !mixedCardDeck[13].toString().equals(previousCard)){
                this.hideCards(iconButton14);
            }
            else{
            previousCard = mixedCardDeck[13].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // iconButton15
        else if (activeButton.equals(iconButton15)) {
            iconButton15.setIcon(mixedCardDeck[14]);
            if(mixedCardDeck[14].toString().equals(previousCard)) {
                this.disableCards(iconButton15);
                return;
            }
            if (previousCard != null && !mixedCardDeck[14].toString().equals(previousCard)){
                this.hideCards(iconButton15);
            }
            else{
            previousCard = mixedCardDeck[14].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // iconButton16
        else if (activeButton.equals(iconButton16)) {
            iconButton16.setIcon(mixedCardDeck[15]);
            if(mixedCardDeck[15].toString().equals(previousCard)) {
                this.disableCards(iconButton16);
                return;
            }
            if (previousCard != null && !mixedCardDeck[15].toString().equals(previousCard)){
                this.hideCards(iconButton16);
            }
            else{
            previousCard = mixedCardDeck[15].toString();
            lastButtonPressed = activeButton;
            }
        }

            // Logic for newgame button and Exit
        if (activeButton.equals(newGame)){
            frame.dispose();
            SwingUtilities.invokeLater(new LaunchMenu());
        }

        if (activeButton.equals(cancel)){
            frame.dispose();
        }
    }
}