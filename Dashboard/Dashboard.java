package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.Border;

public class Dashboard{
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
    }

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel welcomeLabel, userStatus, statusText;
    private static JButton homeButton, locationButton, profileButton, logoutButton;
    private static JTextField textField;
    private static JPasswordField passwordField;


    public Dashboard() {
        frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(500, 800);
        frame.add(panel);
        panel.setBackground(new Color(0x1C2538));
        panel.setLayout(null);

        // Welcome handler==================================================================================
        welcomeLabel = new JLabel("Welcome,  " + LoginCinema.getUser());
        welcomeLabel.setBounds(20, 20, 500, 30);
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        welcomeLabel.setForeground(new Color(0xFFFFFF));
        panel.add(welcomeLabel);

        statusText = new JLabel("You're logged in as ");
        statusText.setBounds(20, 50, 500, 30);
        statusText.setFont(new Font("Poppins", Font.BOLD, 20));
        statusText.setForeground(new Color(0xFFFFFF));
        panel.add(statusText);

        userStatus = new JLabel(LoginCinema.getUserStatus());
        userStatus.setBounds(220, 50, 500, 30);
        userStatus.setFont(new Font("Poppins", Font.BOLD, 20));
        if (LoginCinema.getUserStatus().equals("User")) {
            userStatus.setForeground(new Color(0x1BA0E2));
        } else if (LoginCinema.getUserStatus().equals("Member")){
            userStatus.setForeground(new Color(0xF5BC5D));
        }else {
            userStatus.setForeground(new Color(0xFF0000));
        }
        panel.add(userStatus);

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
