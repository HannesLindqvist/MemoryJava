import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MenuPage());


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
