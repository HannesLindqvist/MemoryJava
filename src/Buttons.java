import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Buttons extends JFrame {




    public Buttons() {


                // Grundramen till spelet.
                JFrame frame = new JFrame();
                frame.setTitle("Detta ska bli ett memoryspel");


        //      frame.setLayout(new FlowLayout(FlowLayout.LEFT));
                JPanel player1 = new JPanel();
                player1.setLayout(new FlowLayout(FlowLayout.CENTER));
                player1.setPreferredSize(new Dimension(50,50));
                player1.setBackground(Color.LIGHT_GRAY);




                // Lägger till en bild på knappen
                ImageIcon image = new ImageIcon("Svamp.jpg");
                frame.setIconImage(image.getImage());


                // Koden till själva spelplanen
                JPanel boardPanel = new JPanel();
                frame.setLayout(new FlowLayout(FlowLayout.TRAILING));
                boardPanel.setPreferredSize(new Dimension(300,300));
                boardPanel.setBackground(Color.lightGray);
                boardPanel.setLayout(new GridLayout(4,4));



                JButton button1 = new JButton();
                button1.setIcon(image);

                JButton button2 = new JButton();
                JButton button3 = new JButton();
                JButton button4 = new JButton("");
                JButton button5 = new JButton("");
                JButton button6 = new JButton();
                JButton button7 = new JButton("");
                JButton button8 = new JButton("");
                JButton button9 = new JButton("");
                JButton button10 = new JButton("");
                button10.setIcon(image);

                JButton button11 = new JButton("");
                JButton button12 = new JButton("");
                JButton button13 = new JButton("");
                JButton button14 = new JButton("");
                JButton button15 = new JButton("");
                JButton button16 = new JButton("");






                EtchedBorder etch = new EtchedBorder();

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



                // Avgör sizen på framen och att den programmet avslutas när man stänger ner det.

                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(450,350);
                frame.add(boardPanel);
                frame.add(player1);
                frame.setVisible(true);




                // Logik till knapparna

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == button1){
                            System.out.println("Bruh");
                        }

                    }


                });
    }



}