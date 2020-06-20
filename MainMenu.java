package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener{

    private JButton button1,button2,button3,button4,button5,button6;
    private JMenuItem item1,item2;

    public MainMenu() {

        setTitle("Main Menu Pos Laju Malaysia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("About Us");
        item1 = new JMenuItem("Contact");
        item1.addActionListener(this);
        item2 = new JMenuItem("Email");
        item2.addActionListener(this);

        setJMenuBar(menubar);
        menubar.add(menu);
        menu.add(item1);
        menu.add(item2);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));

        button1 = new JButton("Next-Day Delivery");
        button2 = new JButton("Same-Day Delivery");
        button3 = new JButton("Prepaid Box & Envelope");
        button4 = new JButton("Pos Ekspres");
        button5 = new JButton("Receipt");
        button6 = new JButton("Exit");


        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);

        add(panel);
        setBounds(300, 200, 400, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==item1){

            JOptionPane.showMessageDialog(this, "04-5783654");

        }if (e.getSource()==item2){

            JOptionPane.showMessageDialog(this, "poslaju@gmail.com");

        }if (e.getSource()==button1){

            new NextDayDelivery();
            setVisible(false);

        }if (e.getSource()==button2){
            new SameDayDelivery();
            setVisible(false);

        }if (e.getSource()==button3){
            new PrepaidBoxEnvelope();
            setVisible(false);

        }if (e.getSource()==button4){
            new PosEkspress();
            setVisible(false);

        }if (e.getSource()==button5){
            new Receipt();
            setVisible(false);

        }if (e.getSource()==button6){
            JOptionPane.showMessageDialog(this, "Thanks For Using Our System");
            System.exit(0);
        }
    }
}
