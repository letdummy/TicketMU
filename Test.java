package LearnGUI;

import javax.swing.*;
import java.awt.*;

public class Test extends javax.swing.JFrame{
    public Test(){
        super("Belajar membuat GUI");
        setSize(800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void main(String[] args) {
        Test test = new Test();
        JPanel panel = new JPanel();
        setContentPane(panel);
        JButton jbtOK = new JButton("OK");
        jbtOK.setBounds(400, 10, 100, 100);
    }
}
