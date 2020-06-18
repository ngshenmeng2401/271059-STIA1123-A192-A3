package Assignment2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receipt extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton button2;

    public Receipt(){

        setTitle("Receipt");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);
        setSize(800, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JLabel label1 = new JLabel("Next-Day Delivery:");
        label1.setBounds(20, 220, 130, 25);
        JLabel label2 = new JLabel("Same-Day Delivery:");
        label1.setBounds(20, 260, 130, 25);

        button2 = new JButton("Main Menu");
        button2.setBounds(600, 350, 100, 25);
        contentPane.add(button2);
        button2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==button2){
            new MainMenu();
            setVisible(false);
        }
    }
}
