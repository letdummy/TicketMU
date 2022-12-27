package TicketMU.Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seat {
    private static JButton seatLabel;

    boolean isSelect = false;

    public Seat(String seat, int x, int y, boolean isBooked) {
        seatLabel = new JButton(seat);
        seatLabel.setBounds(x, y, 25, 25);
        seatLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        seatLabel.setMargin(new Insets(0, 0, 0, 0));

        if (isBooked) {
            seatLabel.setBackground(new Color(0x4C4C4C));
            seatLabel.setForeground(new Color(0xFFFFFF));
        } else {
            seatLabel.addActionListener(new selectSeat());
        }
    }

    public class selectSeat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isSelect == false) {
                seatLabel.setBackground(new Color(0x32C000));
                seatLabel.setForeground(new Color(0xFFFFFF));
                isSelect = true;
            } else {
                seatLabel.setBackground(new Color(0xA1A1A1));
                seatLabel.setForeground(new Color(0xFFFFFF));
                isSelect = false;
            }
        }
    }
}