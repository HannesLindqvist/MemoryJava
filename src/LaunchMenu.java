import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LaunchMenu extends JFrame implements Runnable {
    JLabel label1;
    JFrame frame;
    Border border;
    ImageIcon image1,image2,image3;
    JPanel panel;

    @Override
    public void run() {

        //Frame
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Memory Game"); // Title Headline
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800,1100);
        frame.getContentPane().setBackground(new Color(246, 17, 243, 255)); // change color rgb scale

        // label
        label1 = new JLabel();
        label1.setText("Memory Game!");
        label1.setHorizontalTextPosition(JLabel.CENTER); // adds label to center of logo
        label1.setVerticalTextPosition(JLabel.TOP); // adds label to top on logo
        label1.setForeground(Color.GREEN); // Font color
        label1.setFont(new Font("MV Boli",Font.PLAIN,30)); // Sets Font Charastatics

        //JPanel
        panel = new JPanel();
        panel.setBackground(Color.magenta);
        panel.setSize(1800,1100);

        //Border
        border = BorderFactory.createLineBorder(Color.CYAN,20);
        label1.setBorder(border); // add a border around frame

        // Logo
        image1 = new ImageIcon("MemoryLogo.png"); // adds logo
        frame.setIconImage(image1.getImage());
        image2 = new ImageIcon("MemoryLogo.png");
        label1.setIcon(image2);

        frame.add(panel);
        panel.add(label1);

        frame.setVisible(true); // visibility
        frame.setResizable(false);

        image3 = new ImageIcon("logo_mem.png");
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
            new Buttons();
        } else {
            frame.dispose();
            new Game6x6();}

    }
}


