package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;

public class Location {
    public static void main(String[] args) {
        Location location = new Location();
    }

    JPanel panel;
    JFrame frame;
    JLabel location, locationPic, locationText;
    JButton selectLocation;
    private static JButton homeButton, locationButton, profileButton;

    JComboBox<String> locationList;
    private static String currentLocation = "Solo Paragon Mall";

    public Location(){
        frame = new JFrame("Booking Seat");
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(800, 500);
        frame.add(panel);
        panel.setBackground(new Color(0x1C2538));
        panel.setLayout(null);


        location = new JLabel("LOCATION");
        location.setHorizontalAlignment(SwingConstants.CENTER);
        location.setBounds(-10, 0, 500, 50);
        location.setFont(new Font("Poppins", Font.BOLD, 15));
        location.setForeground(new Color(0xFFFFFF));
        location.setBackground(new Color(0x735F32));
        location.setOpaque(true);
        panel.add(location);

        String[] locations = {"Solo Paragon Mall", "Solo Grand Mall"};
        locationList = new JComboBox<>(locations);
        locationList.setBounds(45, 130, 400, 40);
        locationList.setFont(new Font("Poppins", Font.BOLD, 15));
        locationList.setForeground(new Color(0x1C2538));
        locationList.setBackground(new Color(0xFFFFFF));
        locationList.setOpaque(true);
        panel.add(locationList);


        selectLocation = new JButton("Select Location");
        selectLocation.setBounds(295, 180, 150, 40);
        selectLocation.setFont(new Font("Poppins", Font.BOLD, 15));
        selectLocation.setForeground(new Color(0xFFFFFF));
        selectLocation.setBackground(new Color(0x735F32));
        selectLocation.setOpaque(true);
        selectLocation.setMargin(new Insets(0, 0, 0, 0));
        selectLocation.setBorderPainted(false);
        selectLocation.setFocusPainted(false);
        selectLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLocation();
            }
        });
        panel.add(selectLocation);

        locationPic = new JLabel();
        URL url = getClass().getResource("../assets/"+ getCurrentLocation() +".png");
        ImageIcon icon = new ImageIcon(url);
        locationPic.setIcon(icon);
        locationPic.setBounds(45, 260, icon.getIconWidth(), icon.getIconHeight());
        panel.add(locationPic);

        locationText = new JLabel();
        locationText.setText("     Auto Location Detected: Solo");
        locationText.setBounds(45, 560, 400, 40);
        locationText.setFont(new Font("Poppins", Font.BOLD, 15));
        locationText.setForeground(new Color(0xFFFFFF));
        locationText.setBackground(new Color(0x735F32));
        locationText.setOpaque(true);
        panel.add(locationText);


        // Button ==========================================================================================
        homeButton = new JButton("Home");
        homeButton.setBounds(0, 707, 165, 60);
        homeButton.setBackground(new Color(0xC69749));
        homeButton.setForeground(new Color(0xFFFFFF));
        Border border = BorderFactory.createLineBorder(new Color(0x9E793A), 2);
        homeButton.setBorder(border);
        homeButton.setFont(new Font("Poppins", Font.BOLD, 20));
        homeButton.addActionListener(event -> {
            frame.dispose();
            if(LoginCinema.getUserStatus().equals("User")){
                new UserDashboard();
            } else {
                new MemberDashboard();
            }
        });
        panel.add(homeButton);

        locationButton = new JButton("Location");
        locationButton.setBounds(165, 707, 165, 60);
        locationButton.setBackground(new Color(0x735F32));
        locationButton.setForeground(new Color(0xFFFFFF));
        locationButton.setEnabled(false);
        locationButton.setBorder(border);
        locationButton.setFont(new Font("Poppins", Font.BOLD, 20));
        panel.add(locationButton);

        profileButton = new JButton("Profile");
        profileButton.setBounds(330, 707, 166, 60);
        profileButton.setBackground(new Color(0xC69749));
        profileButton.setForeground(new Color(0xFFFFFF));
        profileButton.setBorder(border);
        profileButton.setFont(new Font("Poppins", Font.BOLD, 20));
        profileButton.addActionListener(event -> {
            frame.dispose();
            if (LoginCinema.getUserStatus().equals("Member")) {
                new Profile("Member");
            } else {
                new Profile();
            }
        });
        panel.add(profileButton);
        //==================================================================================================



        frame.setVisible(true);
    }

    void setLocation(){
        currentLocation = (String) locationList.getSelectedItem();
        locationPic.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(
                                                            "../assets/" + currentLocation + ".png"))));
        System.out.println(currentLocation);
        System.out.println("../assets/"+ getCurrentLocation() +".png");
    }

    public static String getCurrentLocation(){
        return currentLocation;
    }
}
