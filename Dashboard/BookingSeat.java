package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class BookingSeat {
    public static void main(String[] args) {
        BookingSeat bookingSeat = new BookingSeat();
    }

    //array to collect selected seat
    private static final String[] selectedSeat = new String[4];
    private static int selectedSeatCount = 0;

    public static int finalPrice;
    private String currentPrice;

    JFrame frame;
    JPanel panel;
    JButton A1, A2, A3, A4, A5, A6, A7;
    JButton B1, B2, B3, B4, B5, B6, B7;
    JButton C1, C2, C3, C4, C5, C6, C7;
    JButton D1, D2, D3, D4, D5, D6, D7;
    JButton E1, E2, E3, E4, E5, E6, E7;

    JButton confirmButton;
    JButton backBtn, unavailable, available, selected;
    JLabel date, screen, unavailableLabel, availableLabel, selectedLabel;
    static JLabel priceLabel, price, selectedSeatLabel, seatArray;
    //boolean isSelect = false;

    public BookingSeat() {
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

        date = new JLabel("            "+ MovieLanding.getSelectedDay() +" | " + MovieLanding.getSelectedHour());
        date.setBounds(0, 0, 500, 40);
        date.setFont(new Font("Poppins", Font.BOLD, 15));
        date.setForeground(new Color(0xFFFFFF));
        date.setBackground(new Color(0x735F32));
        date.setOpaque(true);
        panel.add(date);

        backBtn = new JButton("<");
        backBtn.setBounds(0, 0, 40, 40);
        backBtn.setFont(new Font("Poppins", Font.BOLD, 15));
        backBtn.setForeground(new Color(0xFFFFFF));
        backBtn.setBackground(new Color(0x735F32));
        backBtn.setOpaque(true);
        backBtn.setMargin(new Insets(0, 0, 0, 0));
        backBtn.setBorderPainted(false);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieLanding();
                frame.dispose();
            }
        });
        panel.add(backBtn);

        screen = new JLabel("Screen");
        screen.setBounds(0, 40, 500, 40);
        screen.setFont(new Font("Poppins", Font.BOLD, 15));
        screen.setForeground(new Color(0xFFFFFF));
        screen.setBackground(new Color(0xC69749));
        screen.setOpaque(true);
        //set screen to center
        screen.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(screen);


        createSeat(A1, "A1", 50, 150);
        createSeat(A2, "A2", 100, 150);
        createSeat(A3, "A3", 150, 150);
        createSeat(A4, "A4", 230, 150);
        createSeat(A5, "A5", 280, 150);
        createSeat(A6, "A6", 330, 150);
        createSeat(A7, "A7", 380, 150);

        createSeat(B1, "B1", 50, 200);
        createSeat(B2, "B2", 100, 200);
        createSeat(B3, "B3", 150, 200);
        createSeat(B4, "B4", 230, 200);
        createSeat(B5, "B5", 280, 200);
        createSeat(B6, "B6", 330, 200);
        createSeat(B7, "B7", 380, 200);

        createSeat(C1, "C1", 50, 250);
        createSeat(C2, "C2", 100, 250);
        createSeat(C3, "C3", 150, 250);
        createSeat(C4, "C4", 230, 250);
        createSeat(C5, "C5", 280, 250);
        createSeat(C6, "C6", 330, 250);
        createSeat(C7, "C7", 380, 250);

        createSeat(D1, "D1", 50, 300);
        createSeat(D2, "D2", 100, 300);
        createSeat(D3, "D3", 150, 300);
        createSeat(D4, "D4", 230, 300);
        createSeat(D5, "D5", 280, 300);
        createSeat(D6, "D6", 330, 300);
        createSeat(D7, "D7", 380, 300);

        createSeat(E1, "E1", 50, 350);
        createSeat(E2, "E2", 100, 350);
        createSeat(E3, "E3", 150, 350);
        createSeat(E4, "E4", 230, 350);
        createSeat(E5, "E5", 280, 350);
        createSeat(E6, "E6", 330, 350);
        createSeat(E7, "E7", 380, 350);


        unavailable = new JButton();
        unavailable.setBounds(62, 510, 20, 20);
        unavailable.setBackground(new Color(0x4D4D4D));
        unavailable.setBorderPainted(false);
        unavailable.setFont(new Font("Poppins", Font.PLAIN, 15));
        unavailable.setMargin(new Insets(0, 0, 0, 0));
        panel.add(unavailable);

        unavailableLabel = new JLabel("Unavailable");
        unavailableLabel.setBounds(87, 510, 100, 20);
        unavailableLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        unavailableLabel.setForeground(new Color(0xA1A1A1));
        panel.add(unavailableLabel);

        available = new JButton();
        available.setBounds(202, 510, 20, 20);
        available.setBackground(new Color(0xA1A1A1));
        available.setBorderPainted(false);
        available.setFont(new Font("Poppins", Font.PLAIN, 15));
        available.setMargin(new Insets(0, 0, 0, 0));
        panel.add(available);

        availableLabel = new JLabel("Available");
        availableLabel.setBounds(227, 510, 100, 20);
        availableLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        availableLabel.setForeground(new Color(0xA1A1A1));
        panel.add(availableLabel);

        selected = new JButton();
        selected.setBounds(322, 510, 20, 20);
        selected.setBackground(new Color(0x32C000));
        selected.setBorderPainted(false);
        selected.setFont(new Font("Poppins", Font.PLAIN, 15));
        panel.add(selected);

        selectedLabel = new JLabel("Selected");
        selectedLabel.setBounds(347, 510, 100, 20);
        selectedLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        selectedLabel.setForeground(new Color(0xA1A1A1));
        panel.add(selectedLabel);

        priceLabel = new JLabel("PRICE");
        priceLabel.setBounds(0, 570, 245, 120);
        priceLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        priceLabel.setForeground(new Color(0xffffff));
        priceLabel.setBackground(new Color(0x735F32));
        priceLabel.setOpaque(true);
        priceLabel.setHorizontalAlignment(JLabel.CENTER);
        priceLabel.setVerticalAlignment(JLabel.NORTH);
        panel.add(priceLabel);

        price = new JLabel();
        price.setBounds(0, 590, 245, 100);
        price.setFont(new Font("Poppins", Font.PLAIN, 30));
        price.setForeground(new Color(0xFFFFFF));
        price.setBackground(new Color(0x735F32));
        price.setOpaque(true);
        price.setHorizontalAlignment(JLabel.CENTER);
        priceLabel.add(price);
        panel.add(price);

        selectedSeatLabel = new JLabel("Selected Seats");
        selectedSeatLabel.setBounds(250, 570, 250, 120);
        selectedSeatLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        selectedSeatLabel.setForeground(new Color(0xffffff));
        selectedSeatLabel.setHorizontalAlignment(JLabel.CENTER);
        selectedSeatLabel.setVerticalAlignment(JLabel.NORTH);
        selectedSeatLabel.setBackground(new Color(0x735F32));
        selectedSeatLabel.setOpaque(true);
        panel.add(selectedSeatLabel);

        seatArray = new JLabel();
        seatArray.setBounds(250, 590, 250, 100);
        seatArray.setFont(new Font("Poppins", Font.PLAIN, 30));
        seatArray.setForeground(new Color(0xFFFFFF));
        seatArray.setBackground(new Color(0x735F32));
        seatArray.setOpaque(true);
        seatArray.setHorizontalAlignment(JLabel.CENTER);
        selectedSeatLabel.add(seatArray);
        panel.add(seatArray);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(-10, 690, 500, 75);
        confirmButton.setFont(new Font("Poppins", Font.BOLD, 20));
        confirmButton.setForeground(new Color(0xFFFFFF));
        confirmButton.setBackground(new Color(0xC69749));
        confirmButton.setMargin(new Insets(0, 0, 0, 0));
        confirmButton.setOpaque(true);
        confirmButton.setBorderPainted(false);
        confirmButton.addActionListener(event -> {
            if (seatArray.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please select a seat");
            } else {
                new Payment();
                frame.dispose();
            }
        });
        panel.add(confirmButton);


        frame.setVisible(true);
    }

    void createSeat(JButton seat, String seatName, int x, int y){
        seat = new JButton(seatName);
        seat.setBounds(x, y, 40, 40);
        seat.setBackground(new Color(0xA1A1A1));
        seat.setForeground(new Color(0xFFFFFF));
        seat.setFont(new Font("Poppins", Font.PLAIN, 15));
        seat.setMargin(new Insets(0, 0, 0, 0));
        JButton finalSeat = seat;
        seat.addActionListener(event -> {
            seatLogic(finalSeat, seatName);
        });
        panel.add(seat);
    }

    void seatLogic(JButton seat, String seatName) {
        if (selectedSeatCount < 4) {
            if (Objects.equals(seat.getBackground(), new Color(0xA1A1A1))) {
                seat.setBackground(new Color(0x32C000));
                seat.setForeground(new Color(0xFFFFFF));
                //add to array
                selectedSeat[selectedSeatCount] = seatName;
                selectedSeatCount++;
                calculatePrice();
                setSeat();
            } else {
                seat.setBackground(new Color(0xA1A1A1));
                seat.setForeground(new Color(0xFFFFFF));
                //remove from array
                for (int i = 0; i < selectedSeat.length; i++) {
                    if (Objects.equals(selectedSeat[i], seatName)) {
                        selectedSeat[i] = null;
                        selectedSeatCount--;
                        calculatePrice();
                        removeSeat(seatName);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You can only select 4 seats per transaction");
            //automatically deselect seat
            seat.setBackground(new Color(0xA1A1A1));
            seat.setForeground(new Color(0xFFFFFF));
            for (int i = 0; i < selectedSeat.length; i++) {
                if (Objects.equals(selectedSeat[i], seatName)) {
                    selectedSeat[i] = null;
                    selectedSeatCount--;
                    removeSeat(seatName);
                }
            }
        }
    }
    void setSeat(){
        for (int i = 0; i < selectedSeat.length; i++) {
            //obly add seat to label if it is not null and not duplicate
            if (selectedSeat[i] != null) {
                if (!seatArray.getText().contains(selectedSeat[i])) {
                    //add space if there is already a seat in the label
                    seatArray.setText(seatArray.getText() + selectedSeat[i] + " ");
                }
            }
        }
    }

    void removeSeat(String seatName){
        //only remove selected seatName from label
        if (seatArray.getText().contains(seatName)) {
            //take seatArray text and replace target label with nothing (simply remove it)
            seatArray.setText(seatArray.getText().replace(seatName + " ", ""));
        } else if (seatArray.getText().contains(seatName + " ")) {
            //same as above but with a space after the seatName
            seatArray.setText(seatArray.getText().replace(seatName + " ", ""));
        }
    }

    void calculatePrice(){
        price.setText("RP " + (selectedSeatCount * 50_000));
        finalPrice = selectedSeatCount * 50_000;
        if (LoginCinema.getUserStatus().equals("Member")) {
            finalPrice = (int) (selectedSeatCount * 50_000 * 0.9);
        }
    }

    static String finalAmount(){
        String total =  String.valueOf(finalPrice);
        total = "Rp" + total;
        return total;
    }
}
