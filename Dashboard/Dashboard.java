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
    private static JLabel welcomeLabel, userStatus, statusText, movie1, movie2;
    private static JButton watchMovie1, watchMovie2;
    private static JButton xxi, cgv, cinepolis, comingSoon;
    private static JButton homeButton, locationButton, profileButton;


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

        // Theater Handler =====================================================================================
        xxi = new JButton("XXI");
        xxi.setBounds(20, 100, 60, 25);
        xxi.setFont(new Font("Poppins", Font.BOLD, 15));
        xxi.setForeground(new Color(0xFFFFFF));
        xxi.setBackground(new Color(0x735F32));
        xxi.setOpaque(true);
        xxi.setBorderPainted(false);
        xxi.setFocusPainted(false);
        xxi.setMargin(new Insets(0, 0, 0, 0));
        panel.add(xxi);

        cgv = new JButton("CGV");
        cgv.setBounds(90, 100, 60, 25);
        cgv.setFont(new Font("Poppins", Font.BOLD, 15));
        cgv.setForeground(new Color(0xFFFFFF));
        cgv.setBackground(new Color(0x4D4D4D));
        cgv.setEnabled(false);
        cgv.setOpaque(true);
        cgv.setBorderPainted(false);
        cgv.setFocusPainted(false);
        cgv.setMargin(new Insets(0, 0, 0, 0));
        panel.add(cgv);

        cinepolis = new JButton("Cinepolis");
        cinepolis.setBounds(160, 100, 100, 25);
        cinepolis.setFont(new Font("Poppins", Font.BOLD, 15));
        cinepolis.setForeground(new Color(0xFFFFFF));
        cinepolis.setBackground(new Color(0x4D4D4D));
        cinepolis.setEnabled(false);
        cinepolis.setOpaque(true);
        cinepolis.setBorderPainted(false);
        cinepolis.setFocusPainted(false);
        cinepolis.setMargin(new Insets(0, 0, 0, 0));
        panel.add(cinepolis);



        //==================================================================================================
        // Movie handler=====================================================================================
        movie1 = new JLabel();
        URL mov1 = getClass().getResource("../assets/movie1.png");
        ImageIcon mov1Icon = new ImageIcon(mov1);
        movie1.setIcon(mov1Icon);
        movie1.setBounds(50, 160, mov1Icon.getIconWidth(), mov1Icon.getIconHeight());
        panel.add(movie1);

        watchMovie1 = new JButton("Watch Now");
        watchMovie1.setBounds(50, 580, 309, 30);
        watchMovie1.setBackground(new Color(0x1BA0E2));
        watchMovie1.setForeground(new Color(0xFFFFFF));
        watchMovie1.setFont(new Font("Poppins", Font.BOLD, 15));
        watchMovie1.setFocusPainted(false);
        watchMovie1.setBorderPainted(false);
        watchMovie1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieLanding();
                frame.dispose();
            }
        });
        panel.add(watchMovie1);

        comingSoon = new JButton();
        comingSoon.setBounds(400, 180, 137, 385);
        comingSoon.setBackground(new Color(0x4D4D4D));
        comingSoon.setOpaque(true);
        comingSoon.setBorderPainted(false);
        comingSoon.setFocusPainted(false);
        comingSoon.setMargin(new Insets(0, 0, 0, 0));
        comingSoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Coming Soon");
            }
        });
        panel.add(comingSoon);

        // Button ==========================================================================================
        homeButton = new JButton("Home");
        homeButton.setBounds(0, 707, 165, 60);
        homeButton.setBackground(new Color(0x735F32));
        homeButton.setForeground(new Color(0xFFFFFF));
        homeButton.setEnabled(false);
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
        locationButton.addActionListener(event -> {
            frame.dispose();
            new Location();
        });

        panel.add(locationButton);

        profileButton = new JButton("Profile");
        profileButton.setBounds(330, 707, 166, 60);
        profileButton.setBackground(new Color(0xC69749));
        profileButton.setForeground(new Color(0xFFFFFF));
        profileButton.setBorder(border);
        profileButton.setFont(new Font("Poppins", Font.BOLD, 20));
        profileButton.addActionListener(event -> {
            frame.dispose();
            new Profile();
        });
        panel.add(profileButton);
        //==================================================================================================




        frame.setVisible(true);
    }


}
