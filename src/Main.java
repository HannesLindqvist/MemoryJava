import javax.swing.*;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new LaunchMenu());
        //new GameOverClass();

    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    
    
}
