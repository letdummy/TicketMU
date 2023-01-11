package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Payment {
    public static void main(String[] args) {
        Payment payment = new Payment();
    }
    JPanel panel;
    JFrame frame;
    JLabel paymentTitle, order, qr, totalAmount;
    JLabel memberBenefit;
    public Payment(){
        frame = new JFrame("Payment");
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(800, 500);
        frame.add(panel);
        panel.setBackground(new Color(0x1C2538));
        panel.setLayout(null);


        paymentTitle = new JLabel("PAYMENT");
        paymentTitle.setHorizontalAlignment(SwingConstants.CENTER);
        paymentTitle.setBounds(-10, 0, 500, 50);
        paymentTitle.setFont(new Font("Poppins", Font.BOLD, 15));
        paymentTitle.setForeground(new Color(0xFFFFFF));
        paymentTitle.setBackground(new Color(0x735F32));
        paymentTitle.setOpaque(true);
        panel.add(paymentTitle);

        order = new JLabel("Your Selected Seat(s)");
        order.setHorizontalAlignment(SwingConstants.CENTER);
        order.setBounds(-10, 70, 500, 50);
        order.setFont(new Font("Poppins", Font.PLAIN, 15));
        order.setForeground(new Color(0xFFFFFF));
        panel.add(order);

        JLabel seatArray = new JLabel(BookingSeat.seatArray.getText());
        seatArray.setHorizontalAlignment(SwingConstants.CENTER);
        seatArray.setBounds(-10, 120, 500, 50);
        seatArray.setFont(new Font("Poppins", Font.BOLD, 20));
        seatArray.setForeground(new Color(0xFFFFFF));
        panel.add(seatArray);

        totalAmount = new JLabel(BookingSeat.finalAmount());
        totalAmount.setHorizontalAlignment(SwingConstants.CENTER);
        totalAmount.setBounds(-10, 680, 500, 50);
        totalAmount.setFont(new Font("Poppins", Font.BOLD, 20));
        totalAmount.setForeground(new Color(0xFFFFFF));
        panel.add(totalAmount);

        if (LoginCinema.getUserStatus().equals("Member")) {
            memberBenefit = new JLabel("Member Benefit: 10% Discount");
            memberBenefit.setHorizontalAlignment(SwingConstants.CENTER);
            memberBenefit.setBounds(-10, 700, 500, 50);
            memberBenefit.setFont(new Font("Poppins", Font.PLAIN, 15));
            memberBenefit.setForeground(new Color(0xFFFFFF));
            panel.add(memberBenefit);
        }


        qr = new JLabel();
        URL url = getClass().getResource("../assets/qr.png");
        ImageIcon icon = new ImageIcon(url);
        qr.setIcon(icon);
        qr.setBounds(45, 180, icon.getIconWidth(), icon.getIconHeight());
        panel.add(qr);


        JButton payButton = new JButton("PAY");
        payButton.setBounds(120, 620, 250, 40);
        payButton.setFont(new Font("Poppins", Font.BOLD, 15));
        payButton.setForeground(new Color(0xFFFFFF));
        payButton.setBackground(new Color(0x735F32));
        payButton.setOpaque(true);
        payButton.setFocusPainted(false);
        payButton.setBorderPainted(false);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new FinalLanding();
            }
        });
        panel.add(payButton);


        frame.setVisible(true);
    }
}
