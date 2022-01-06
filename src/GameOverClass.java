import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverClass implements ActionListener {


    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel labelScore = new JLabel();

    JPanel Container = new JPanel();
    JPanel scorePanel = new JPanel();

    JButton buttonNewGame = new JButton("New Game");
    JButton buttonQuit = new JButton("Quit");

    Player player1,player2;

    GameOverClass(Player player1, Player player2){

        this.player1 = player1;
        this.player2 = player2;

        Container.setLayout(new FlowLayout());
        Container.setBackground(Color.BLACK);
        scorePanel.setBackground(Color.GREEN);
        Container.setBounds(100,400,200,40);
        scorePanel.setBounds(10,300,400,70);


        buttonQuit.setBackground(Color.GRAY);
        buttonNewGame.setBackground(Color.GRAY);

        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new LaunchMenu());
                frame.dispose();

            }
        });


        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        Container.add(buttonNewGame);
        Container.add(buttonQuit);



        ImageIcon image = new ImageIcon("GameOverPic.png");
        label.setBounds(10,10,600,300);
        label.setIcon(image);

        labelScore.setText("<html>Score : <br> " +
                            player1.name + ": " + player1.points + "<br>" + player2.name + ": " + player2.points +  "</html>");
        labelScore.setBounds(0,0,100,100);

        frame = new JFrame();

        frame.add(label);
        frame.add(Container);
        frame.add(scorePanel);
        scorePanel.add(labelScore);

        frame.getContentPane().setBackground((Color.BLACK));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("SLUT"); // Title Headline
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440,500);
        frame.setResizable(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

