package TicketMU.Dashboard;

import TicketMU.Login.LoginCinema;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;

public class MovieLanding {


    public static void main(String[] args) {
        MovieLanding movieLanding = new MovieLanding();
    }

    JPanel panel;
    JFrame frame;
    JLabel movieSelected, imageVector;
    JButton backBtn;
    JLabel Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    JButton monday1, tuesday1, wednesday1, thursday1, friday1, saturday1, sunday1;
    JButton monday2, tuesday2, wednesday2, thursday2, friday2, saturday2, sunday2;
    JButton monday3, tuesday3, wednesday3, thursday3, friday3, saturday3, sunday3;

    private  static String selectedHour;
    private static String selectedDay;
    private static JButton homeButton, locationButton, profileButton;

    public MovieLanding(){
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

        movieSelected = new JLabel("DECIBEL");
        movieSelected.setHorizontalAlignment(SwingConstants.CENTER);
        movieSelected.setBounds(-10, 0, 500, 50);
        movieSelected.setFont(new Font("Poppins", Font.BOLD, 15));
        movieSelected.setForeground(new Color(0xFFFFFF));
        movieSelected.setBackground(new Color(0x735F32));
        movieSelected.setOpaque(true);
        panel.add(movieSelected);

        backBtn = new JButton("<");
        backBtn.setBounds(0, 0, 50, 50);
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
                frame.dispose();
                if(LoginCinema.getUserStatus().equals("User")){
                    new UserDashboard();
                } else if (LoginCinema.getUserStatus().equals("Member")){
                    new MemberDashboard();
                } else {
                    new Dashboard();
                }
            }
        });
        panel.add(backBtn);


        imageVector = new JLabel();
        URL vector = getClass().getResource("../assets/Decibel.png");
        ImageIcon imageIcon = new ImageIcon(vector);
        imageVector.setIcon(imageIcon);
        imageVector.setBounds(25,60, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panel.add(imageVector);

        JLabel detail = new JLabel("<html>The story unfolds when a bomb that responds to sound is discovered " +
                "at the center of the city. This terror attack occurs following an incident that happened one year " +
                "ago in a submarine, and important figures such as a submarine commander, reporter, and a member of " +
                "the Defense Security Support Command come together to try and stop the bomb. Kang Do Young is a Navy " +
                "submarine commander. He’s a key figure linked to the submarine incident that was the cause of the " +
                "terror attack. </html>");
        detail.setBounds(255, 65, 225, 200);
        detail.setFont(new Font("Poppins", Font.PLAIN, 10));
        detail.setForeground(new Color(0xFFFFFF));
        panel.add(detail);

        JLabel statusText = new JLabel("""
                <html>
                <p>Also Known As: Desibel
                <p>Director: Hwang In Ho
                <p>Screenwriter: Lee Jin Hoon
                <p>Genres: Action, Thriller, Drama
                </html>
                """);
        statusText.setBounds(265, 225, 225, 160);
        statusText.setFont(new Font("Poppins", Font.PLAIN, 10));
        statusText.setForeground(new Color(0xFFFFFF));
        panel.add(statusText);

        Monday = new JLabel("Monday");
        Monday.setHorizontalAlignment(SwingConstants.CENTER);
        Monday.setBounds(25, 370, 100, 25);
        Monday.setFont(new Font("Poppins", Font.BOLD, 15));
        Monday.setForeground(new Color(0xFFFFFF));
        panel.add(Monday);

        createHour(monday1, 140, 370, "10:40", "Moday", true);
        createHour(monday2, 220, 370, "13:40", "Moday", false);
        createHour(monday3, 300, 370, "16:40", "Moday", false);

        Tuesday = new JLabel("Tuesday");
        Tuesday.setHorizontalAlignment(SwingConstants.CENTER);
        Tuesday.setBounds(25, 420, 100, 25);
        Tuesday.setFont(new Font("Poppins", Font.BOLD, 15));
        Tuesday.setForeground(new Color(0xFFFFFF));
        panel.add(Tuesday);

        createHour(tuesday1, 140, 420, "10:40", "Tuesday",true);;
        createHour(tuesday2, 220, 420, "14:45", "Tuesday",true);
        createHour(tuesday3, 300, 420, "18:50", "Tuesday",true);

        Wednesday = new JLabel("Wednesday");
        Wednesday.setHorizontalAlignment(SwingConstants.CENTER);
        Wednesday.setBounds(25, 470, 100, 25);
        Wednesday.setFont(new Font("Poppins", Font.BOLD, 15));
        Wednesday.setForeground(new Color(0xFFFFFF));
        panel.add(Wednesday);

        createHour(wednesday1, 140, 470, "10:40","Wednesday", true);
        createHour(wednesday2, 220, 470, "14:45","Wednesday", true);
        createHour(wednesday3, 300, 470, "18:50","Wednesday", true);

        Thursday = new JLabel("Thursday");
        Thursday.setHorizontalAlignment(SwingConstants.CENTER);
        Thursday.setBounds(25, 520, 100, 25);
        Thursday.setFont(new Font("Poppins", Font.BOLD, 15));
        Thursday.setForeground(new Color(0xFFFFFF));
        panel.add(Thursday);

        createHour(thursday1, 140, 520, "10:40","Thursday", true);
        createHour(thursday2, 220, 520, "14:45","Thursday", true);
        createHour(thursday3, 300, 520, "18:50","Thursday", false);

        Friday = new JLabel("Friday");
        Friday.setHorizontalAlignment(SwingConstants.CENTER);
        Friday.setBounds(25, 570, 100, 25);
        Friday.setFont(new Font("Poppins", Font.BOLD, 15));
        Friday.setForeground(new Color(0xFFFFFF));
        panel.add(Friday);

        createHour(friday1, 140, 570, "10:40","Friday", true);
        createHour(friday2, 220, 570, "14:45","Friday", true);
        createHour(friday3, 300, 570, "18:50","Friday", false);

        Saturday = new JLabel("Saturday");
        Saturday.setHorizontalAlignment(SwingConstants.CENTER);
        Saturday.setBounds(25, 620, 100, 25);
        Saturday.setFont(new Font("Poppins", Font.BOLD, 15));
        Saturday.setForeground(new Color(0xFFFFFF));
        panel.add(Saturday);

        createHour(saturday1, 140, 620, "10:40","Saturday", false);
        createHour(saturday2, 220, 620, "14:45","Saturday", true);
        createHour(saturday3, 300, 620, "18:50","Saturday", false);

        Sunday = new JLabel("Sunday");
        Sunday.setHorizontalAlignment(SwingConstants.CENTER);
        Sunday.setBounds(25, 670, 100, 25);
        Sunday.setFont(new Font("Poppins", Font.BOLD, 15));
        Sunday.setForeground(new Color(0xFFFFFF));
        panel.add(Sunday);

        createHour(sunday1, 140, 670, "10:40","Sunday", false);
        createHour(sunday2, 220, 670, "14:45","Sunday", false);
        createHour(sunday3, 300, 670, "18:50","Sunday", false);






        frame.setVisible(true);
    }

    void createHour(JButton dayHour, int x, int y, String hour, String day, boolean isAvailable){
        dayHour = new JButton(hour);
        dayHour.setBounds(x, y, 70, 25);
        dayHour.setFont(new Font("Poppins", Font.BOLD, 15));
        dayHour.setForeground(new Color(0x282A3A));

        if (isAvailable){
            dayHour.setBackground(new Color(0xA1A1A1));
        } else {
            dayHour.setBackground(new Color(0x4C4C4C));
        }
        dayHour.setOpaque(true);
        dayHour.setEnabled(isAvailable);
        dayHour.setMargin(new Insets(0, 0, 0, 0));
        dayHour.setBorderPainted(false);
        dayHour.setFocusPainted(false);
        dayHour.addActionListener(e -> {
            MovieLanding.selectedHour = hour;
            MovieLanding.selectedDay = day;
            new BookingSeat();
            frame.dispose();
        });
        panel.add(dayHour);
    }

    static String getSelectedHour(){
        return selectedHour;
    }

    static String getSelectedDay(){
        return selectedDay;
    }
}
