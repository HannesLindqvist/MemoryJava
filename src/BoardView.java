import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.ImageIcon;

public class BoardView extends JFrame {
    

    JFrame frame = new JFrame();
    JPanel boardPanel = new JPanel();
    EtchedBorder etch = new EtchedBorder();
    JPanel playersContainer = new JPanel();
    
    static JPanel player1Panel = new JPanel();
    static JPanel player2Panel = new JPanel();

    JLabel player1Label = new JLabel("Player 1");
    JLabel player2Label = new JLabel("Player 2");
     
    static JLabel player1Points = new JLabel();
    static JLabel player2Points = new JLabel();

    JLabel player1Name = new JLabel();
    JLabel player2Name = new JLabel();
    
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

    static Player player1;
    static Player player2;
    ImageIcon[] mixedCardDeck;

    LinkedHashMap<JButton, ImageIcon> buttonHashMap 
            = new LinkedHashMap<JButton, ImageIcon>();

    private int cardsVisible = 0;


    public BoardView(Player p1, Player p2, ImageIcon[] cardDeck) {
        this.player1 = p1;
        this.player2 = p2;
        this.mixedCardDeck = cardDeck;
        
        
        buttonHashMap.put(iconButton1, mixedCardDeck[0]);
		buttonHashMap.put(iconButton2, mixedCardDeck[1]);
		buttonHashMap.put(iconButton3, mixedCardDeck[2]);
		buttonHashMap.put(iconButton4, mixedCardDeck[3]);
		buttonHashMap.put(iconButton5, mixedCardDeck[4]);
		buttonHashMap.put(iconButton6, mixedCardDeck[5]);
		buttonHashMap.put(iconButton7, mixedCardDeck[6]);
		buttonHashMap.put(iconButton8, mixedCardDeck[7]);
		buttonHashMap.put(iconButton9, mixedCardDeck[8]);
		buttonHashMap.put(iconButton10, mixedCardDeck[9]);
		buttonHashMap.put(iconButton11, mixedCardDeck[10]);
		buttonHashMap.put(iconButton12, mixedCardDeck[11]);
		buttonHashMap.put(iconButton13, mixedCardDeck[12]);
		buttonHashMap.put(iconButton14, mixedCardDeck[13]);
		buttonHashMap.put(iconButton15, mixedCardDeck[14]);
		buttonHashMap.put(iconButton16, mixedCardDeck[15]);




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

        // Player1 panel settings
        player1Panel.setBackground(Color.GREEN);
        player1Panel.setPreferredSize(new Dimension(120,150));
        player1Panel.setBorder(etch);
        player1Label.setFont(new Font("Verdana", 1,20));
        player1Name.setText(player1.name);
        player1Points.setText(player1.getPoints() + " points");

        // Player2 panel settings
        player2Panel.setBackground(Color.lightGray);
        player2Panel.setPreferredSize(new Dimension(120,150));
        player2Label.setFont(new Font("Verdana", 1,20));
        player2Name.setText(player2.name);
        player2Points.setText(player2.getPoints() + " points");

        // Add Player1/Player2 components
        playersContainer.add(player1Panel);
        player1Panel.add(player1Label);
        player1Panel.add(player1Name);
        player1Panel.add(player1Points);

        playersContainer.add(player2Panel);
        player2Panel.add(player2Label);
        player2Panel.add(player2Name);
        player2Panel.add(player2Points);



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
        ActionListener listener = new Game();
        iconButton1.addActionListener(listener);
        iconButton2.addActionListener(listener);
        iconButton3.addActionListener(listener);
        iconButton4.addActionListener(listener);
        iconButton5.addActionListener(listener);
        iconButton6.addActionListener(listener);
        iconButton7.addActionListener(listener);
        iconButton8.addActionListener(listener);
        iconButton9.addActionListener(listener);
        iconButton10.addActionListener(listener);
        iconButton11.addActionListener(listener);
        iconButton12.addActionListener(listener);
        iconButton13.addActionListener(listener);
        iconButton14.addActionListener(listener);
        iconButton15.addActionListener(listener);
        iconButton16.addActionListener(listener);
        cancel.addActionListener(listener);
        newGame.addActionListener(listener);

    }

    // Reset visible card counter
    public void setCardsVisible(int count) {
        cardsVisible = count;
    }
    
    public int getCardsVisible() {
        return cardsVisible; 
    }
    
 
    // Update scoreboard with new points
    public void updateScoreboard() {

        player1Points.setText(player1.getPoints() + " points");
        player2Points.setText(player2.getPoints() + " points");
    }
    
    public LinkedHashMap getGameBoard() {
        return buttonHashMap;
            
    }

    /*
    // Each turn is started when a valid board button is pressed
    public void actionPerformed(ActionEvent e) {
        JButton activeButton = (JButton) e.getSource();                // This button is the same as the one being pressed

        // If same button is pressed twice, do nothing
        if(activeButton.equals(Game.lastButtonPressed))
            return;

        // If two cards are visible, do not show additonal cards
        // The hideCard method resets the counter
        cardsVisible += 1;
        if(cardsVisible > 2)
            return;
        
        // 
        Game.thisTurn(getGameBoard(), activeButton);
        

    }
   */ 
}