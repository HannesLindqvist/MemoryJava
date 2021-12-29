import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LaunchMenu extends JFrame implements Runnable, ActionListener {
    JLabel label;
    JFrame frame;
    Border border;
    ImageIcon image1,image2;
    JButton playButton;
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
        label = new JLabel();
        label.setText("Memory Game!");
        label.setHorizontalTextPosition(JLabel.CENTER); // adds label to center of logo
        label.setVerticalTextPosition(JLabel.TOP); // adds label to top on logo
        label.setForeground(Color.GREEN); // Font color
        label.setFont(new Font("MV Boli",Font.PLAIN,30)); // Sets Font Charastatics

            //JPanel
        panel = new JPanel();
        panel.setBackground(Color.magenta);
        panel.setSize(1800,1100);

            //Border
        border = BorderFactory.createLineBorder(Color.CYAN,20);
        label.setBorder(border); // add a border around frame

            // Logo
        image1 = new ImageIcon("MemoryLogo.png"); // adds logo
        frame.setIconImage(image1.getImage());
        image2 = new ImageIcon("MemoryLogo.png");
        label.setIcon(image2);

            //JButton
        playButton = new JButton("PLaY");
        playButton.setFocusable(false);
        playButton.setBounds(750,750,300,50);

        frame.add(playButton); // playbutton must come first or it will hide beneath panel.
        frame.add(panel);
        panel.add(label);

        frame.setVisible(true); // visibility
        frame.setResizable(false);


        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==playButton){
                    frame.dispose();
                    Buttons theGame = new Buttons();
                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
