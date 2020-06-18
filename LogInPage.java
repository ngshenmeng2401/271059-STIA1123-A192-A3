package Assignment2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPage extends JFrame{

    public static void main(String[] args) {

        new LogInPage();
    }

    public LogInPage() {

        setTitle("Log In Page");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        add(panel);

        placeComponent(panel);

        setBounds(300, 200, 400, 200);
        setVisible(true);
    }

    public void placeComponent(JPanel panel) {

        panel.setLayout(null);

        JLabel label = new JLabel("Username:");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField usertext = new JTextField();
        usertext.setBounds(100, 20, 165, 25);
        panel.add(usertext);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JCheckBox checkbox = new JCheckBox("Show Password");
        checkbox.setBounds(100, 80, 150, 25);

        checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkbox.isSelected()) {
                    passwordText.setEchoChar((char) 0);
                } else {
                    passwordText.setEchoChar('*');
                }
            }
        });

        panel.add(checkbox);

        //Create login button
        JButton loginbutton = new JButton("Login");
        loginbutton.setBounds(10, 100, 80, 25);
        panel.add(loginbutton);

        loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usertext.getText();
                String password = passwordText.getText();
                if (username.trim().equals("SHENMENG") && password.trim().equals("Meng0124")) {
                    new MainMenu();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username & Password");
                }
            }
        });
    }
}
