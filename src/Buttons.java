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


                // Lägger till en bild på knappen
                ImageIcon image = new ImageIcon("Svamp.jpg");
                frame.setIconImage(image.getImage());


                // Koden till själva spelplanen
                JPanel boardPanel = new JPanel();
                frame.setLayout(new FlowLayout());
                boardPanel.setPreferredSize(new Dimension(300,300));
                boardPanel.setBackground(Color.lightGray);
                boardPanel.setLayout(new GridLayout(4,4));


                // Layout på knappar och paneler. Måste vara ovanför kanpparna eller panelerna för att funka.
                EtchedBorder etch = new EtchedBorder();

                // Player 1 och 2 logik
                JPanel container = new JPanel();
                container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
                JLabel player1 = new JLabel("Player 1");
                player1.setFont(new Font("Verdana", 1,20));

                JLabel player2 = new JLabel("Player 2");
                player2.setFont(new Font("Verdana", 1,20));
                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel();

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
                JButton button1 = new JButton();
                button1.setIcon(image);

                JButton button2 = new JButton();
                JButton button3 = new JButton();
                JButton button4 = new JButton();
                JButton button5 = new JButton();
                JButton button6 = new JButton();
                JButton button7 = new JButton();
                JButton button8 = new JButton();
                JButton button9 = new JButton();
                JButton button10 = new JButton();
                button10.setIcon(image);

                JButton button11 = new JButton();
                JButton button12 = new JButton();
                JButton button13 = new JButton();
                JButton button14 = new JButton();
                JButton button15 = new JButton();
                JButton button16 = new JButton();

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



                // Avgör sizen på framen och att den programmet avslutas när man stänger ner det.

                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(450,400);
                frame.add(container);
                frame.add(boardPanel);
                frame.add(meny);
               


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