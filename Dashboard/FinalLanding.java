package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

public class FinalLanding {
    public static void main(String[] args) {
        FinalLanding finalLanding = new FinalLanding();
    }

    JPanel panel;
    JFrame frame;

    JLabel paymentStatus, status, statusText;

    JButton toDashboard;


    public FinalLanding() {
        frame = new JFrame("Final Landing");
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(800, 500);
        frame.add(panel);
        panel.setBackground(new Color(0x1C2538));
        panel.setLayout(null);

        paymentStatus = new JLabel("Status");
        paymentStatus.setHorizontalAlignment(SwingConstants.CENTER);
        paymentStatus.setBounds(-10, 0, 500, 50);
        paymentStatus.setFont(new Font("Poppins", Font.BOLD, 15));
        paymentStatus.setForeground(new Color(0xFFFFFF));
        paymentStatus.setBackground(new Color(0x735F32));
        paymentStatus.setOpaque(true);
        panel.add(paymentStatus);

        status = new JLabel();
        URL url = getClass().getResource("../assets/finished.png");
        ImageIcon imageIcon = new ImageIcon(url);
        status.setIcon(imageIcon);
        status.setHorizontalAlignment(SwingConstants.CENTER);
        status.setBounds(90, 150, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panel.add(status);

        statusText = new JLabel("Payment Success!");
        statusText.setHorizontalAlignment(SwingConstants.CENTER);
        statusText.setBounds(-10, 400, 500, 50);
        statusText.setFont(new Font("Poppins", Font.BOLD, 20));
        statusText.setForeground(new Color(0xFFFFFF));
        panel.add(statusText);

        toDashboard = new JButton("Back to Dashboard");
        toDashboard.setBounds(100, 500, 300, 50);
        toDashboard.setFont(new Font("Poppins", Font.BOLD, 15));
        toDashboard.setForeground(new Color(0xFFFFFF));
        toDashboard.setBackground(new Color(0x735F32));
        toDashboard.setOpaque(true);
        toDashboard.setBorderPainted(false);
        toDashboard.setFocusPainted(false);
        toDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (LoginCinema.getUserStatus().equals("User")) {
                    new UserDashboard();
                } else if (LoginCinema.getUserStatus().equals("Member")) {
                    new MemberDashboard();
                } else {
                    UserDashboard userDashboard = new UserDashboard();
                }
            }
        });
        panel.add(toDashboard);


        frame.setVisible(true);
    }
}
