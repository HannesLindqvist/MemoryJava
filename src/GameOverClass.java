import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverClass implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    JPanel Container = new JPanel();

    JButton button = new JButton("New Game");
    JButton button2 = new JButton("Quit");


    GameOverClass(){
        Container.setLayout(new FlowLayout());
        Container.setBackground(Color.BLACK);
        Container.setBounds(100,300,200,40);



        button.setBackground(Color.GRAY);
        button2.setBackground(Color.GRAY);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new LaunchMenu());
                frame.dispose();
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        Container.add(button);
        Container.add(button2);


        ImageIcon image = new ImageIcon("GameOverPic.png");
        label.setBounds(10,10,390,300);
        label.setIcon(image);


        frame = new JFrame();
        frame.add(label);
        frame.add(Container);
        frame.getContentPane().setBackground((Color.BLACK));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("SLUT"); // Title Headline
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430,380);
        frame.setResizable(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

