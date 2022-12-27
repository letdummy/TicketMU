package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;

public class MovieDetail extends JFrame{
    public static void main(String[] args) {
        MovieDetail movieDetail = new MovieDetail();
    }

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel welcomeLabel, userStatus, statusText, imageVector;
    private static JButton homeButton, locationButton, profileButton, logoutButton;
    private static JTextField textField;
    private static JPasswordField passwordField;

    public MovieDetail(){


        frame = new JFrame("Movie Detail");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(500, 800);
        frame.add(panel);
        panel.setBackground(new Color(0x1C2538));
        panel.setLayout(null);

        imageVector = new JLabel();
        URL vector = getClass().getResource("../assets/Decibel.png");
        ImageIcon imageIcon = new ImageIcon(vector);
        imageVector.setIcon(imageIcon);
        imageVector.setBounds(25,60, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panel.add(imageVector);

        // Welcome handler==================================================================================

        JLabel detail = new JLabel("<html>The story unfolds when a bomb that responds to sound is discovered at the center of the city. This terror attack occurs following an incident that happened one year ago in a submarine, and important figures such as a submarine commander, reporter, and a member of the Defense Security Support Command come together to try and stop the bomb. Kang Do Young is a Navy submarine commander. He’s a key figure linked to the submarine incident that was the cause of the terror attack. Oh Dae Oh is a passionate reporter. Cha Young Han is a member of the Defense Security Support Command.</html>");
        detail.setBounds(255, 65, 225, 160);
        detail.setFont(new Font("Poppins", Font.BOLD, 8));
        detail.setForeground(new Color(0xFFFFFF));
        panel.add(detail);

        statusText = new JLabel("""
                <html>
                <p>Native Title: 데시벨
                <p>Also Known As: Desibel
                <p>Director: Hwang In Ho
                <p>Screenwriter: Lee Jin Hoon
                <p>Genres: Action, Thriller, Drama
                </html>
                """);
        statusText.setBounds(265, 215, 225, 160);
        statusText.setFont(new Font("Poppins", Font.BOLD, 10));
        statusText.setForeground(new Color(0xFFFFFF));
        panel.add(statusText);

        //==================================================================================================

        // Button ==========================================================================================
        homeButton = new JButton("Home");
        homeButton.setBounds(0, 707, 165, 60);
        homeButton.setBackground(new Color(0xC69749));
        homeButton.setForeground(new Color(0xFFFFFF));
        Border border = BorderFactory.createLineBorder(new Color(0x9E793A), 2);
        homeButton.setBorder(border);
        homeButton.setFont(new Font("Poppins", Font.BOLD, 20));
        panel.add(homeButton);

        locationButton = new JButton("Location");
        locationButton.setBounds(165, 707, 165, 60);
        locationButton.setBackground(new Color(0xC69749));
        locationButton.setForeground(new Color(0xFFFFFF));
        locationButton.setBorder(border);
        locationButton.setFont(new Font("Poppins", Font.BOLD, 20));
        panel.add(locationButton);

        profileButton = new JButton("Profile");
        profileButton.setBounds(330, 707, 166, 60);
        profileButton.setBackground(new Color(0xC69749));
        profileButton.setForeground(new Color(0xFFFFFF));
        profileButton.setBorder(border);
        profileButton.setFont(new Font("Poppins", Font.BOLD, 20));
        panel.add(profileButton);
        //==================================================================================================




        frame.setVisible(true);
    }

}
