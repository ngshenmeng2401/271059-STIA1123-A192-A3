package my.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Receipt extends JFrame implements ActionListener {

    static NextDayDelivery delivery1 = new NextDayDelivery();
    static SameDayDelivery delivery2 = new SameDayDelivery();
    static PrepaidBoxEnvelope delivery3 = new PrepaidBoxEnvelope();
    static PosEkspress delivery4 = new PosEkspress();

    JButton button2;
    JLabel name, address, contactNo, nextdaydelivery, samedaydelivery, prepaidboxenvelope, posekspress, totalprice;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8;
    JLabel line1, line2, line3;
    JTextField text1, text2, text3;
    ImageIcon logo;

    private static double charge1 = delivery1.getCharge1();
    private static double charge2 = delivery2.getCharge2();
    private static double charge3 = delivery3.getCharge3();
    private static double charge4 = delivery4.getCharge4();

    public Receipt() {

        getContentPane().setLayout(null);
        setTitle("Receipt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        name = new JLabel("Name: ");
        address = new JLabel("Address: ");
        contactNo = new JLabel("Contact No: ");


        nextdaydelivery = new JLabel("Next-Day Delivery:");
        samedaydelivery = new JLabel("Same-Day Delivery:");
        prepaidboxenvelope = new JLabel("Prepaid Box Envelope:");
        posekspress = new JLabel("Pos Ekspress:");
        totalprice = new JLabel("Total Price:");

        line1 = new JLabel("-----------------------------------------------------------");
        line2 = new JLabel("-----------------------------------------------------------");
        line3 = new JLabel("-----------------------------------------------------------");

        text1 = new JTextField(30);
        text2 = new JTextField(30);
        text3 = new JTextField(30);

        label1 = new JLabel("Your Bill:");
        label2 = new JLabel("RM");
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();

        //Add image as logo
        label8 = new JLabel();
        label8.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/logo.png")).getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH)));
        label8.setBounds(-10, 30, 200, 100);

        //Set Location & Size
        name.setBounds(200, 50, 100, 20);
        address.setBounds(200, 80, 100, 20);
        contactNo.setBounds(200, 110, 100, 20);

        nextdaydelivery.setBounds(50, 270, 200, 20);
        samedaydelivery.setBounds(50, 300, 200, 20);
        prepaidboxenvelope.setBounds(50, 330, 200, 20);
        posekspress.setBounds(50, 360, 200, 20);
        totalprice.setBounds(50, 390, 200, 20);

        line1.setBounds(50, 220, 400, 10);
        line2.setBounds(50, 380, 400, 10);
        line3.setBounds(50, 410, 400, 10);

        text1.setBounds(300, 50, 200, 20);
        text2.setBounds(300, 80, 200, 20);
        text3.setBounds(300, 110, 200, 20);

        label1.setBounds(50, 200, 200, 20);
        label2.setBounds(250, 240, 100, 20);
        label3.setBounds(250, 270, 200, 20);
        label4.setBounds(250, 300, 200, 20);
        label5.setBounds(250, 330, 200, 20);
        label6.setBounds(250, 360, 200, 20);
        label7.setBounds(250, 390, 200, 20);

        //Convert Double to String
        String amount1 = Double.toString(charge1);
        String amount2 = Double.toString(charge2);
        String amount3 = Double.toString(charge3);
        String amount4 = Double.toString(charge4);
        double totalprice = charge1 + charge2 + charge3 + charge4;
        String amount5 = Double.toString(totalprice);

        label3.setText(amount1);
        label4.setText(amount2);
        label5.setText(amount3);
        label6.setText(amount4);
        label7.setText(amount5);

        //Add object
        add(name);
        add(address);
        add(contactNo);
        add(nextdaydelivery);
        add(samedaydelivery);
        add(prepaidboxenvelope);
        add(posekspress);
        add(this.totalprice);

        add(line1);
        add(line2);
        add(line3);

        add(text1);
        add(text2);
        add(text3);

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);

        button2 = new JButton("Main Menu");
        button2.setBounds(500, 450, 100, 25);
        add(button2);
        button2.addActionListener(this);

        delivery1.setVisible(false);
        delivery2.setVisible(false);
        delivery3.setVisible(false);
        delivery4.setVisible(false);

        setVisible(true);
        setSize(700, 550);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button2) {
            new MainMenu();
            setVisible(false);
        }
    }

}
