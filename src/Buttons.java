import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Buttons extends JFrame implements ActionListener {
    ImageIcon[] mixedCardDeck = Cards.mixDeck();

    JFrame frame = new JFrame();
    JPanel boardPanel = new JPanel();

    EtchedBorder etch = new EtchedBorder();
    JPanel container = new JPanel();

    JLabel player1 = new JLabel("Player 1");
    JLabel player2 = new JLabel("Player 2");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();
    JButton button10 = new JButton();
    JButton button11 = new JButton();
    JButton button12 = new JButton();
    JButton button13 = new JButton();
    JButton button14 = new JButton();
    JButton button15 = new JButton();
    JButton button16 = new JButton();

    JButton lastButtonPressed = null;
    String previousCard = null;


    public Buttons() {


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
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        player1.setFont(new Font("Verdana", 1,20));

        player2.setFont(new Font("Verdana", 1,20));
        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.GREEN);

        panel1.setPreferredSize(new Dimension(120,150));
        panel2.setPreferredSize(new Dimension(120,150));

        panel1.setBorder(etch);
        panel2.setBorder(etch);

        panel1.add(player1);
        panel2.add(player2);

        container.add(panel1);
        container.add(panel2);


        // Knappar/kort till memorybrädet.

        button1.setIcon(mixedCardDeck[0]);
        button2.setIcon(mixedCardDeck[1]);
        button3.setIcon(mixedCardDeck[2]);
        button4.setIcon(mixedCardDeck[3]);
        button5.setIcon(mixedCardDeck[4]);
        button6.setIcon(mixedCardDeck[5]);
        button7.setIcon(mixedCardDeck[6]);
        button8.setIcon(mixedCardDeck[7]);
        button9.setIcon(mixedCardDeck[8]);
        button10.setIcon(mixedCardDeck[9]);
        button11.setIcon(mixedCardDeck[10]);
        button12.setIcon(mixedCardDeck[11]);
        button13.setIcon(mixedCardDeck[12]);
        button14.setIcon(mixedCardDeck[13]);
        button15.setIcon(mixedCardDeck[14]);
        button16.setIcon(mixedCardDeck[15]);

        // Menyval
        JPanel meny = new JPanel();
        JButton newGame = new JButton("Nytt Spel");
        JButton cancel = new JButton("Avsluta");
        meny.add(newGame);
        meny.add(cancel);



        // En viss typ av layout på knapparna, går enkelt att ändra.

        button1.setBorder(etch);     button5.setBorder(etch);     button9.setBorder(etch);      button13.setBorder(etch);
        button2.setBorder(etch);     button6.setBorder(etch);     button10.setBorder(etch);     button14.setBorder(etch);
        button3.setBorder(etch);     button7.setBorder(etch);     button11.setBorder(etch);     button15.setBorder(etch);
        button4.setBorder(etch);     button8.setBorder(etch);     button12.setBorder(etch);     button16.setBorder(etch);

        // Sätter färgen på knapparna, enkelt att ändra.

        button1.setBackground(Color.orange);    button9.setBackground(Color.orange);
        button2.setBackground(Color.orange);    button10.setBackground(Color.orange);
        button3.setBackground(Color.orange);    button11.setBackground(Color.orange);
        button4.setBackground(Color.orange);    button12.setBackground(Color.orange);
        button5.setBackground(Color.orange);    button13.setBackground(Color.orange);
        button6.setBackground(Color.orange);    button14.setBackground(Color.orange);
        button7.setBackground(Color.orange);    button15.setBackground(Color.orange);
        button8.setBackground(Color.orange);    button16.setBackground(Color.orange);

        // Addar knappar till panelen som ligger på boarden. boardPanelvariabeln är själva spelplanen.

        boardPanel.add(button1); boardPanel.add(button2); boardPanel.add(button3); boardPanel.add(button4);
        boardPanel.add(button5); boardPanel.add(button6); boardPanel.add(button7); boardPanel.add(button8);
        boardPanel.add(button9); boardPanel.add(button10); boardPanel.add(button11); boardPanel.add(button12);
        boardPanel.add(button13); boardPanel.add(button14); boardPanel.add(button15); boardPanel.add(button16);

        button1.setEnabled(true);


        // Avgör sizen på framen och att den programmet avslutas när man stänger ner det.

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(450,400);
        frame.setResizable(false);
        frame.add(container);
        frame.add(boardPanel);
        frame.add(meny);
        frame.setVisible(true);


        // Logik till knapparna
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        button16.addActionListener(this);

                /*
                button1.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == button1){

                        }
                        else {
                        }

                    }



                });*/
    }

    public void resetCardButton() {
        lastButtonPressed = null;
        previousCard = null;
    }

    public void hideCards(JButton thisButton) {
        System.out.println("No match!");
        lastButtonPressed.setIcon(null);
        thisButton.setIcon(null);



        
        this.sleep(); 

        this.resetCardButton();
    }

    public void disableCards(JButton thisButton){
        System.out.println("Match!");

        lastButtonPressed.setEnabled(false);
        thisButton.setEnabled(false);

        this.resetCardButton();
    }

    public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void actionPerformed(ActionEvent e) {
        JButton activeButton = (JButton) e.getSource();                // This button is the same as the one being pressed

        // If same button is pressed twice, do nothing
        if(activeButton.equals(lastButtonPressed)){
            return;

        }
        //////////////////////////////////////////////////////////////////////
        // Button1                                                          //
        // Each button has its own if-statements but the logic is the same  // 
        // Card shown on button when button is pressed                      //
        // Cards disabled if matched                                        // 
        // Cards hides if no match                                          // 
        // The selected Button and Card is saved to variables               //
        //////////////////////////////////////////////////////////////////////
        if (activeButton.equals(button1)) {
            button1.setIcon(mixedCardDeck[0]);
            if(mixedCardDeck[0].toString().equals(previousCard)) {
                this.disableCards(button1);
                return;
            }
            if (previousCard != null && !mixedCardDeck[0].toString().equals(previousCard)){
                this.hideCards(button1);

            }
            else{
                previousCard = mixedCardDeck[0].toString();
                lastButtonPressed = activeButton;
            }

        }
        // Button2
        else if (activeButton.equals(button2)) {
            button2.setIcon(mixedCardDeck[1]);
            if(mixedCardDeck[1].toString().equals(previousCard)) {
                this.disableCards(button2);
                return;
            }
            if (previousCard != null && !mixedCardDeck[1].toString().equals(previousCard)){
                this.hideCards(button2);
            }
            else{
                previousCard = mixedCardDeck[1].toString();
                lastButtonPressed = activeButton;
            }
        }

        // Button3
        else if (activeButton.equals(button3)) {
            button3.setIcon(mixedCardDeck[2]);
            if(mixedCardDeck[2].toString().equals(previousCard)) {
                this.disableCards(button3);
                return;
            }
            if (previousCard != null && !mixedCardDeck[2].toString().equals(previousCard)){
                this.hideCards(button3);
            }
            else{
                previousCard = mixedCardDeck[2].toString();
                lastButtonPressed = activeButton;
            }
        }

        // Button4
        else if (activeButton.equals(button4)) {
            button4.setIcon(mixedCardDeck[3]);
            if(mixedCardDeck[3].toString().equals(previousCard)) {
                this.disableCards(button4);
                return;
            }
            if (previousCard != null && !mixedCardDeck[3].toString().equals(previousCard)){
                this.hideCards(button4);
            }
            else{

                previousCard = mixedCardDeck[3].toString();
                lastButtonPressed = activeButton;
            }


            previousCard = mixedCardDeck[3].toString();
            lastButtonPressed = activeButton;
            } 


        // Button5 
        else if (activeButton.equals(button5)) {
            button5.setIcon(mixedCardDeck[4]);
            if(mixedCardDeck[4].toString().equals(previousCard)) {
                this.disableCards(button5);
                return;
            }
            if (previousCard != null && !mixedCardDeck[4].toString().equals(previousCard)){
                this.hideCards(button5);
            }
            else{
            previousCard = mixedCardDeck[4].toString();
            lastButtonPressed = activeButton;
            }
        }

        // Button6 
        else if (activeButton.equals(button6)) {
            button6.setIcon(mixedCardDeck[5]);
            if(mixedCardDeck[5].toString().equals(previousCard)) {
                this.disableCards(button6);
                return;
            }
            if (previousCard != null && !mixedCardDeck[5].toString().equals(previousCard)){
                this.hideCards(button6);
            }
            else{
            previousCard = mixedCardDeck[5].toString();
            lastButtonPressed = activeButton;
            }
        } 

        // Button7
        else if (activeButton.equals(button7)) {
            button7.setIcon(mixedCardDeck[6]);
            if(mixedCardDeck[6].toString().equals(previousCard)) {
                this.disableCards(button7);
                return;
            }
            if (previousCard != null && !mixedCardDeck[6].toString().equals(previousCard)){
                this.hideCards(button7);
            }
            else{
            previousCard = mixedCardDeck[6].toString();
            lastButtonPressed = activeButton;
            }
        } 


        // Button8
        else if (activeButton.equals(button8)) {
            button8.setIcon(mixedCardDeck[7]);
            if(mixedCardDeck[7].toString().equals(previousCard)) {
                this.disableCards(button8);
                return;
            }
            if (previousCard != null && !mixedCardDeck[7].toString().equals(previousCard)){
                this.hideCards(button8);
            }
            else{
            previousCard = mixedCardDeck[7].toString();
            lastButtonPressed = activeButton;
            }
        }

        // Button9
        else if (activeButton.equals(button9)) {
            button9.setIcon(mixedCardDeck[8]);
            if(mixedCardDeck[8].toString().equals(previousCard)) {
                this.disableCards(button9);
                return;
            }
            if (previousCard != null && !mixedCardDeck[8].toString().equals(previousCard)){
                this.hideCards(button9);
            }
            else{
            previousCard = mixedCardDeck[8].toString();
            lastButtonPressed = activeButton;
            }
        } 

        // Button10
        else if (activeButton.equals(button10)) {
            button10.setIcon(mixedCardDeck[9]);
            if(mixedCardDeck[9].toString().equals(previousCard)) {
                this.disableCards(button10);
                return;
            }
            if (previousCard != null && !mixedCardDeck[9].toString().equals(previousCard)){
                this.hideCards(button10);
            }
            else{
            previousCard = mixedCardDeck[9].toString();
            lastButtonPressed = activeButton;
            }
        } 

        // Button11
        else if (activeButton.equals(button11)) {
            button11.setIcon(mixedCardDeck[10]);
            if(mixedCardDeck[10].toString().equals(previousCard)) {
                this.disableCards(button11);
                return;
            }
            if (previousCard != null && !mixedCardDeck[10].toString().equals(previousCard)){
                this.hideCards(button11);
            }
            else{
            previousCard = mixedCardDeck[10].toString();
            lastButtonPressed = activeButton;
            }
        }
        
        // Button12
        else if (activeButton.equals(button12)) {
            button12.setIcon(mixedCardDeck[11]);
            if(mixedCardDeck[11].toString().equals(previousCard)) {
                this.disableCards(button12);
                return;
            }
            if (previousCard != null && !mixedCardDeck[11].toString().equals(previousCard)){
                this.hideCards(button12);
            }
            else{
            previousCard = mixedCardDeck[11].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // Button13
        else if (activeButton.equals(button13)) {
            button13.setIcon(mixedCardDeck[12]);
            if(mixedCardDeck[12].toString().equals(previousCard)) {
                this.disableCards(button13);
                return;
            }
            if (previousCard != null && !mixedCardDeck[12].toString().equals(previousCard)){
                this.hideCards(button13);
            }
            else{
            previousCard = mixedCardDeck[12].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // Button14
        else if (activeButton.equals(button14)) {
            button14.setIcon(mixedCardDeck[13]);
            if(mixedCardDeck[13].toString().equals(previousCard)) {
                this.disableCards(button14);
                return;
            }
            if (previousCard != null && !mixedCardDeck[13].toString().equals(previousCard)){
                this.hideCards(button14);
            }
            else{
            previousCard = mixedCardDeck[13].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // Button15
        else if (activeButton.equals(button15)) {
            button15.setIcon(mixedCardDeck[14]);
            if(mixedCardDeck[14].toString().equals(previousCard)) {
                this.disableCards(button15);
                return;
            }
            if (previousCard != null && !mixedCardDeck[14].toString().equals(previousCard)){
                this.hideCards(button15);
            }
            else{
            previousCard = mixedCardDeck[14].toString();
            lastButtonPressed = activeButton;
            }
        } 
        
        // Button16
        else if (activeButton.equals(button16)) {
            button16.setIcon(mixedCardDeck[15]);
            if(mixedCardDeck[15].toString().equals(previousCard)) {
                this.disableCards(button16);
                return;
            }
            if (previousCard != null && !mixedCardDeck[15].toString().equals(previousCard)){
                this.hideCards(button16);
            }
            else{
            previousCard = mixedCardDeck[15].toString();
            lastButtonPressed = activeButton;
            }
        }
        
    }










}