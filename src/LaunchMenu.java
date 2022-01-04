import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LaunchMenu extends JFrame implements Runnable, ActionListener {
    JLabel logoLabel,player1Label,player2Label;
    JFrame frame;
    Border border;
    ImageIcon gameLogo;
    JPanel logoPanel,playersPanel;
    JButton nameButton1,nameButton2,playButton,exitButton;
    JTextField player1Text,player2Text;

    @Override
    public void run() {

        //Frame
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Memory Game"); // Title Headline
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,1000);
        frame.getContentPane().setBackground(new Color(37, 189, 250, 255)); // change color rgb scale

        // label
        logoLabel = new JLabel();
        logoLabel.setText("Memory Game!");
        logoLabel.setHorizontalTextPosition(JLabel.CENTER); // adds label to center of logo
        logoLabel.setVerticalTextPosition(JLabel.TOP); // adds label to top on logo
        logoLabel.setForeground(Color.GREEN); // Font color
        logoLabel.setFont(new Font("MV Boli",Font.PLAIN,30)); // Sets Font Charastatics

        //JPanel
        logoPanel = new JPanel();
        logoPanel.setBackground(Color.magenta);
        logoPanel.setBounds(200,0,800,800);

        //Border
        border = BorderFactory.createLineBorder(Color.CYAN,20);
        logoLabel.setBorder(border); // add a border around frame

        // Logo

        gameLogo = new ImageIcon("MemoryLogo.png");
        logoLabel.setIcon(gameLogo);
        logoPanel.add(logoLabel);

        playersPanel = new JPanel();
        playersPanel.setPreferredSize(new Dimension(600,400));
        playersPanel.setBackground(Color.ORANGE);

        player1Label = new JLabel("Player 1 name: ");
        player1Text = new JTextField();
        player1Text.setPreferredSize(new Dimension(200,25));
        playersPanel.add(player1Label);
        playersPanel.add(player1Text);

        player2Label = new JLabel("Player 2 name: ");
        player2Text = new JTextField();
        player2Text.setPreferredSize(new Dimension(200,30));
        playersPanel.add(player2Label);
        playersPanel.add(player2Text);

        nameButton1 = new JButton("Submit player1 name");
        nameButton2 = new JButton("Submit player2 name");
        playButton = new JButton("Press Play");
        exitButton = new JButton("Exit");

        playButton.setBounds(400,400,200,30);


        playButton.setPreferredSize(new Dimension(200,40));
        exitButton.setPreferredSize(new Dimension(200,40));
        nameButton1.setPreferredSize(new Dimension(200,40));
        nameButton2.setPreferredSize(new Dimension(200,40));

        JLabel iconlabel = new JLabel();
        ImageIcon icon = new ImageIcon("yoshi.png");


        playButton.setIcon(icon);
        frame.add(logoPanel);
        logoPanel.add(playersPanel);
        playersPanel.add(nameButton1);
        playersPanel.add(nameButton2);
        playersPanel.add(playButton);
        playersPanel.add(exitButton);



        playersPanel.add(iconlabel);
        nameButton1.addActionListener(this);
        nameButton2.addActionListener(this);
        playButton.addActionListener(this);
        exitButton.addActionListener(this);


        frame.setVisible(true); // visibility
        frame.setResizable(false);


        /*String[] optionsToChoose = {"4x4 Game", "6x6 Game"};
        String gameSize = (String) JOptionPane.showInputDialog(
                null,
                "Memory Game",
                "Choose Game Size ",
                JOptionPane.QUESTION_MESSAGE,s
                image3,
                optionsToChoose,
                optionsToChoose[0]);

         */

        /*image3 = new ImageIcon("logo_mem.png");
        String[] optionsToChoose = {"4x4 Game", "6x6 Game"};
        String gameSize = (String) JOptionPane.showInputDialog(
                null,
                "Memory Game",
                "Choose Game Size ",
                JOptionPane.QUESTION_MESSAGE,
                image3,
                optionsToChoose,
                optionsToChoose[0]);

        if (gameSize.equals(optionsToChoose[0])){
            frame.dispose(); // Quits frame
            Game4x4 game4x4 = new Game4x4();
            game4x4.startGame();
        } else {
            frame.dispose();
            new Game6x6();}


         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==nameButton1){
            player1Text.getText();
            System.out.println(player1Text.getText());
        }
        if (e.getSource()==nameButton2){
            player2Text.getText();
            System.out.println(player2Text.getText());
        }
        if (e.getSource()==playButton){
            new Game4x4();
            frame.dispose();
        }
        if (e.getSource()==exitButton){
            frame.dispose();
        }

    }
}


