package TicketMU.Login;

import TicketMU.Dashboard.MemberDashboard;
import TicketMU.Dashboard.UserDashboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class LoginCinema{
    public static void main(String[] args) {
        LoginCinema login = new LoginCinema();
    }
    // By ascending scope for each variable, the variables are accessible everywhere in this class due to private
    private static JFrame frame;
    private static JPanel panel, imagePanel;
    private static JLabel jumbotron, description, userLabel, passwordLabel, loginVector, emailLabel;
    private static JLabel wrongPasswordAlert, wrongEmailAlert, successAlert, emptyAlert;
    private static JTextField userText = new JTextField("User"),
                              userStatus = new JTextField("Default");
    private static JPasswordField passwordText;
    private static JButton loginButton, exitButton;

    public static String mailDomain = "@student.ums.ac.id";


    public LoginCinema(){
        frame = new JFrame("TicketMU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setSize(500, 800);
        frame.add(panel);
        panel.setBackground(new Color(0x1C2538));
        panel.setLayout(null);

        // Jumbotron and description =======================================================================
        jumbotron = new JLabel("TICKETMU");
        jumbotron.setBounds(153, 50, 250, 30);
        jumbotron.setFont(new Font("Poppins", Font.BOLD, 35));
        jumbotron.setForeground(new Color(0xFFFFFF));
        panel.add(jumbotron);

        description = new JLabel("Muhammadiyah Cinema Ticketing System");
        description.setBounds(21, 100, 500, 30);
        description.setFont(new Font("Poppins", Font.BOLD, 20));
        description.setForeground(new Color(0xFFFFFF));
        panel.add(description);

        loginVector = new JLabel();
        URL vector = getClass().getResource("../assets/loginVector.png");
        ImageIcon imageIcon = new ImageIcon(vector);
        loginVector.setIcon(imageIcon);
        loginVector.setBounds(100, 170, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panel.add(loginVector);
        //==================================================================================================


        //Username handler =================================================================================
        userLabel = new JLabel("Username:");
        userLabel.setBounds(70, 550, 90, 25);
        userLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        userLabel.setForeground(new Color(0xFFFFFF));
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(160, 550, 80, 25);
        panel.add(userText);

        emailLabel = new JLabel(mailDomain); //getting mail domain
        emailLabel.setBounds(250, 550, 175, 25);
        emailLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        emailLabel.setForeground(new Color(0xFFFFFF));
        panel.add(emailLabel);
        //==================================================================================================


        //Password handler =================================================================================
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70, 590, 80, 25);
        passwordLabel.setFont(new Font("Poppins", Font.PLAIN, 15));
        passwordLabel.setForeground(new Color(0xFFFFFF));
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(160, 590, 240, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(320, 630, 80, 25);
        loginButton.addActionListener(new loginListener());
        loginButton.setForeground(new Color(0x1C2538));
        loginButton.setFont(new Font("Poppins", Font.PLAIN, 15));
        loginButton.setBackground(new Color(0xC69749));
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(0xC69749)));
        panel.add(loginButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(160, 630, 80, 25);
        exitButton.addActionListener(new closeListener());
        exitButton.setForeground(new Color(0x1C2538));
        exitButton.setFont(new Font("Poppins", Font.PLAIN, 15));
        exitButton.setBackground(new Color(0xC69749));
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(0xC69749)));
        panel.add(exitButton);
        //==================================================================================================


        //Alert handler ====================================================================================
        wrongPasswordAlert = new JLabel("Wrong password!");
        wrongPasswordAlert.setBounds(160, 665, 150, 25);
        wrongPasswordAlert.setFont(new Font("Poppins", Font.PLAIN, 15));
        wrongPasswordAlert.setForeground(new Color(0xFF0000));
        wrongPasswordAlert.setVisible(false);
        panel.add(wrongPasswordAlert);

        wrongEmailAlert = new JLabel("Email can't contain '@'!");
        wrongEmailAlert.setBounds(160, 665, 200, 25);
        wrongEmailAlert.setFont(new Font("Poppins", Font.PLAIN, 15));
        wrongEmailAlert.setForeground(new Color(0xFF0000));
        wrongEmailAlert.setVisible(false);
        panel.add(wrongEmailAlert);

        emptyAlert = new JLabel("Username or password can't be empty!");
        emptyAlert.setBounds(160, 665, 300, 25);
        emptyAlert.setFont(new Font("Poppins", Font.PLAIN, 15));
        emptyAlert.setForeground(new Color(0xFF0000));
        emptyAlert.setVisible(false);
        panel.add(emptyAlert);

        successAlert = new JLabel("Login success! wait a seconds...");
        successAlert.setBounds(160, 665, 300, 25);
        successAlert.setFont(new Font("Poppins", Font.PLAIN, 15));
        successAlert.setForeground(new Color(0x00FF00));
        successAlert.setVisible(false);
        panel.add(successAlert);
        //==================================================================================================



        frame.setVisible(true);
    }

    // Login button listener
    private class loginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = userText.getText();
            String password = passwordText.getText();
            if(user.contains("@")){
                System.out.println("Invalid username");
                wrongPasswordAlert.setVisible(false);
                wrongEmailAlert.setVisible(true);
                successAlert.setVisible(false);
                emptyAlert.setVisible(false);
            }
            else if (user.isEmpty() || password.isEmpty()) {
                wrongPasswordAlert.setVisible(false);
                wrongEmailAlert.setVisible(false);
                successAlert.setVisible(false);
                emptyAlert.setVisible(true);
            } else {
                if (password.equals("user")) {
                    System.out.println("Logged in as user");
                    wrongPasswordAlert.setVisible(false);
                    wrongEmailAlert.setVisible(false);
                    successAlert.setVisible(true);
                    emptyAlert.setVisible(false);
                    userStatus.setText("User");
                    Timer timer = new Timer(3000, event -> {
                        frame.dispose();
                        new UserDashboard();
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else if (password.equals("member")) {
                    System.out.println("Logged in as member");
                    wrongPasswordAlert.setVisible(false);
                    wrongEmailAlert.setVisible(false);
                    successAlert.setVisible(true);
                    emptyAlert.setVisible(false);
                    userStatus.setText("Member");
                    Timer timer = new Timer(3000, event -> {
                        frame.dispose();
                        new MemberDashboard();
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    System.out.println("Wrong password");
                    wrongPasswordAlert.setVisible(true);
                    wrongEmailAlert.setVisible(false);
                    successAlert.setVisible(false);
                    emptyAlert.setVisible(false);
                }
            }
        }
    }

    // Exit button listener
    private static class closeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    static class editListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    // Getter Setter handler =================================================================================
    public static String getUser() {
        return userText.getText();
    }

    public static String getUserStatus() {
        return userStatus.getText();
    }
}
