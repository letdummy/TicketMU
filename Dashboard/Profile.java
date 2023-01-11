package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;

public class Profile {
    public static void main(String[] args) {
        Profile profile = new Profile();
        System.out.println(LoginCinema.getUser() + LoginCinema.mailDomain);
    }

    JPanel panel;
    JFrame frame;
    JLabel profile;
    JLabel email, emailText, username, usernameText, payment, paymentText;
    JLabel userStatus, userStatusText;

    JButton logoutButton;


    private static JButton homeButton, locationButton, profileButton;

    public Profile(){
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

        profile = new JLabel("PROFILE");
        profile.setHorizontalAlignment(SwingConstants.CENTER);
        profile.setBounds(-10, 0, 500, 50);
        profile.setFont(new Font("Poppins", Font.BOLD, 15));
        profile.setForeground(new Color(0xFFFFFF));
        profile.setBackground(new Color(0x735F32));
        profile.setOpaque(true);
        panel.add(profile);

        email = new JLabel("   Email");
        email.setBounds(45, 130, 400, 40);
        email.setFont(new Font("Poppins", Font.BOLD, 15));
        email.setForeground(new Color(0xFFFFFF));
        email.setBackground(new Color(0x735F32));
        email.setOpaque(true);
        panel.add(email);

        emailText = new JLabel();
        emailText.setText("   "+ LoginCinema.getUser() + LoginCinema.mailDomain);
        emailText.setBounds(45, 170, 400, 40);
        emailText.setFont(new Font("Poppins", Font.BOLD, 15));
        emailText.setForeground(new Color(0x1C2538));
        emailText.setBackground(new Color(0xEEEEEE));
        emailText.setOpaque(true);
        panel.add(emailText);

        username = new JLabel("   Username");
        username.setBounds(45, 230, 400, 40);
        username.setFont(new Font("Poppins", Font.BOLD, 15));
        username.setForeground(new Color(0xFFFFFF));
        username.setBackground(new Color(0x735F32));
        username.setOpaque(true);
        panel.add(username);

        usernameText = new JLabel();
        usernameText.setText("   "+ LoginCinema.getUser());
        usernameText.setBounds(45, 270, 400, 40);
        usernameText.setFont(new Font("Poppins", Font.BOLD, 15));
        usernameText.setForeground(new Color(0x1C2538));
        usernameText.setBackground(new Color(0xEEEEEE));
        usernameText.setOpaque(true);
        panel.add(usernameText);

        payment = new JLabel("   Payment");
        payment.setBounds(45, 330, 400, 40);
        payment.setFont(new Font("Poppins", Font.BOLD, 15));
        payment.setForeground(new Color(0xFFFFFF));
        payment.setBackground(new Color(0x735F32));
        payment.setOpaque(true);
        panel.add(payment);

        paymentText = new JLabel();
        paymentText.setText("   DANAID(+62 xxx 7890)");
        paymentText.setBounds(45, 370, 400, 40);
        paymentText.setFont(new Font("Poppins", Font.BOLD, 15));
        paymentText.setForeground(new Color(0x1C2538));
        paymentText.setBackground(new Color(0xEEEEEE));
        paymentText.setOpaque(true);
        panel.add(paymentText);


        logoutButton = new JButton("Logout");
        logoutButton.setBounds(45, 550, 400, 40);
        logoutButton.setFont(new Font("Poppins", Font.BOLD, 15));
        logoutButton.setForeground(new Color(0xEEEEEE));
        logoutButton.setBackground(new Color(0xD10000));
        logoutButton.setFocusPainted(false);
        logoutButton.setBorderPainted(false);
        logoutButton.setOpaque(true);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginCinema loginCinema = new LoginCinema();
            }
        });
        panel.add(logoutButton);



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
        profileButton.setBackground(new Color(0x735F32));
        profileButton.setForeground(new Color(0xFFFFFF));
        profileButton.setEnabled(false);
        profileButton.setBorder(border);
        profileButton.setFont(new Font("Poppins", Font.BOLD, 20));
        profileButton.addActionListener(event -> {
            frame.dispose();
        });
        panel.add(profileButton);
        //==================================================================================================


        frame.setVisible(true);
    }

    public Profile(String status){
        this();
        userStatus = new JLabel("   User Status");
        userStatus.setBounds(45, 430, 400, 40);
        userStatus.setFont(new Font("Poppins", Font.BOLD, 15));
        userStatus.setForeground(new Color(0xFFFFFF));
        userStatus.setBackground(new Color(0x735F32));
        userStatus.setOpaque(true);
        panel.add(userStatus);

        userStatusText = new JLabel();
        userStatusText.setText("   Platinum  Member  Subscription");
        userStatusText.setBounds(45, 470, 400, 40);
        userStatusText.setFont(new Font("Poppins", Font.BOLD, 15));
        userStatusText.setForeground(new Color(0x1C2538));
        userStatusText.setBackground(new Color(0xEEEEEE));
        userStatusText.setOpaque(true);
        panel.add(userStatusText);

    }
}
